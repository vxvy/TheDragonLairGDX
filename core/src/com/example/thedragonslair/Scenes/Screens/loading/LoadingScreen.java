package com.example.thedragonslair.Scenes.Screens.loading;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.AssetsCode.AssetsDescriptors;
import com.example.thedragonslair.AssetsCode.AssetsPaths;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.Scenes.Screens.GameMainMenu;
import com.example.thedragonslair.config.GameConfig;
import com.example.thedragonslair.config.GameStrings;
import com.example.thedragonslair.util.CodeResources;

import static com.example.thedragonslair.config.GameConfig.LANGUAGE_SPA;
import static com.example.thedragonslair.config.GameConfig.WU_DEFAULT_CELL_SIZE;
import static com.example.thedragonslair.config.GameConfig.WU_WORLD_HEIGHT;
import static com.example.thedragonslair.config.GameConfig.WU_WORLD_WIDTH;

public class LoadingScreen extends GeneralScreen {

    private static final float PROGRESS_BAR_WIDTH = GameConfig.WU_WORLD_WIDTH;
    private static final float PROGRESS_BAR_HEIGHT = WU_DEFAULT_CELL_SIZE;
    private static final Logger log = new Logger(LoadingScreen.class.getName(), Logger.DEBUG);

    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected ShapeRenderer renderer;

    private float loadingProgress;
    private float waitingTime; //Tiempo de margen que va a pasar DESPUÉS de cargar los assets
    private boolean changeScreen; //false por defecto
    protected Texture texture;
    protected BitmapFont bmFont;
    protected GameStrings gameStrings;
    private static GlyphLayout glyphLayout;

    public LoadingScreen(MyGdxGame myGdxGame) {
        super(myGdxGame);

        gameStrings = new GameStrings(GameStrings.eLanguage.LANGUAGE_SPA);

        this.loadingProgress = 0f;
        this.waitingTime = 0.75f;
        this.changeScreen = false;

        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WU_WORLD_WIDTH, GameConfig.WU_WORLD_HEIGHT, camera);
        renderer = new ShapeRenderer();

        texture = new Texture(AssetsPaths.LOGO_PATH);
        bmFont = new BitmapFont(Gdx.files.internal("fonts/dungrg.fnt"));
        glyphLayout = new GlyphLayout();
        glyphLayout.setText(bmFont,gameStrings.msgLoading);
    }

    @Override
    public void show() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        log.debug("show");

        loadStuff();
    }

    @Override
    public void render(float delta) {
        update(delta);
        CodeResources.clearScreen(Color.WHITE);
        viewport.apply(); //Es una buena práctica aplicar el viewport para cuando cambiemos el tipo de viewport

        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        draw();
        renderer.end();

        isGame.getBatch().setProjectionMatrix(camera.combined);
        isGame.getBatch().begin();
        this.drawBatch();
        this.drawText();
        isGame.getBatch().end();

        if (changeScreen) {
            isGame.setScreen(new GameMainMenu(isGame));
        }
    }

    private void update(float delta) {
        CodeResources.waitmillisecs(400);
        loadingProgress = isGame.getAssetManager().getProgress(); //entre 0 y 1
        if (isGame.getAssetManager().update()) { //true cuando todos los assets estén cargados
            waitingTime -= delta;
            if (waitingTime <= 0) {
                changeScreen = true;
            }
        }
    }

    /**
     * Dibuja la barra de progreso
     */
    private void draw() {
//        float progressBarX = (GameConfig.WU_WORLD_WIDTH-PROGRESS_BAR_WIDTH)/2;
//        float progressBarY = (GameConfig.PIXEL_HEIGHT-PROGRESS_BAR_HEIGHT)/2;

        renderer.setColor(Color.BLACK);
        renderer.rect(
                0,
                0,
                loadingProgress * PROGRESS_BAR_WIDTH,
                PROGRESS_BAR_HEIGHT);
    }

    private void drawBatch() {
        log.debug(
                GameConfig.WU_HALF_HEIGHT_CENTER + "x / " +
                        GameConfig.WU_HALF_HEIGHT_CENTER + "y / " +
                        texture.getWidth() + "x / " +
                        texture.getHeight() + "y"
        );

        isGame.getBatch().draw(texture,
                WU_WORLD_WIDTH/2-(texture.getWidth()/12)/2,
                WU_WORLD_WIDTH/2-(texture.getHeight()/12)/2,
                texture.getWidth()/12,
                texture.getHeight()/12
        );
    }

    private void drawText(){
        bmFont.getData().setScale(1/4.5f);

        bmFont.draw(
                isGame.getBatch(),
                gameStrings.msgLoading,
                WU_WORLD_WIDTH/2-(glyphLayout.width*bmFont.getScaleX())/2, //con esto centra horizontal
                WU_WORLD_HEIGHT/3-(glyphLayout.height*bmFont.getScaleY())/2
        );

    }

    /**
     * Le da tamaño a la pantalla
     *
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
//        viewport.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


    /**
     * Cuando termine la pantalla de carga, se llama automátivamente al hide, no al dispose
     */
    @Override
    public void hide() {
        log.debug("hide");
        dispose();
    }

    /**
     * Cabe remarcar que las pantallas por detecto no se tiran, se ocultan
     */
    @Override
    public void dispose() {
        log.debug("dispose");

        renderer.dispose();
        texture.dispose();
        bmFont.dispose();

        renderer = null;
    }

    private void loadStuff() {
        isGame.getAssetManager().load(AssetsDescriptors.LOGO_DES);
        isGame.getAssetManager().load(AssetsDescriptors.CUT_TITLE_DES);
        isGame.getAssetManager().load(AssetsDescriptors.BACKGROUND01_DES);

        isGame.getAssetManager().load(AssetsDescriptors.ENEMIGO1_DES);
        isGame.getAssetManager().load(AssetsDescriptors.ENEMIGO2_DES);
        isGame.getAssetManager().load(AssetsDescriptors.ENEMIGO3_DES);

        isGame.getAssetManager().load(AssetsDescriptors.SIEGFRIED_ANDANDO_DES);
        isGame.getAssetManager().load(AssetsDescriptors.SIEGFRIED_ESPADA_DES);
        isGame.getAssetManager().load(AssetsDescriptors.SIEGFRIED_GOLPEADO_DES);
        isGame.getAssetManager().load(AssetsDescriptors.SIEGFRIED_LOGRO_DES);
        isGame.getAssetManager().load(AssetsDescriptors.SIEGFRIED_MUERIENDO_DES);
        isGame.getAssetManager().load(AssetsDescriptors.SIEGFRIED_PARADO_DES);
        isGame.getAssetManager().load(AssetsDescriptors.SIEGFRIED_SALTANDO_DES);

        isGame.getAssetManager().load(AssetsDescriptors.LLAMAS_DES);

        isGame.getAssetManager().load(AssetsDescriptors.PB_PARED_DES);
        isGame.getAssetManager().load(AssetsDescriptors.PB_SUELO_DES);
        isGame.getAssetManager().load(AssetsDescriptors.P1_PARED_DES);
        isGame.getAssetManager().load(AssetsDescriptors.P1_SUELO_DES);
        isGame.getAssetManager().load(AssetsDescriptors.P2_PARED_DES);
        isGame.getAssetManager().load(AssetsDescriptors.P2_SUELO_DES);

        isGame.getAssetManager().load(AssetsDescriptors.NARRATIVE_FONT_DES);

//        isGame.getAssetManager().load(AssetsDescriptors.SKIN_GLASSY_DES, Skin.class, new SkinLoader.SkinParameter("skin/skinsMaster/glassy/preview.png"));
        isGame.getAssetManager().load(AssetsDescriptors.SKIN_GLASSY_DES);
        isGame.getAssetManager().load(AssetsDescriptors.SKIN_GOLDEN_DES);
        isGame.getAssetManager().load(AssetsDescriptors.SKIN_SQUARE_DES);
        isGame.getAssetManager().load(AssetsDescriptors.SKIN_NEON_DES);
    }
}