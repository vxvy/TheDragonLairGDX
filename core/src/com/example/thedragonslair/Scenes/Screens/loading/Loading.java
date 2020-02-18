package com.example.thedragonslair.Scenes.Screens.loading;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.AssetsCode.AssetsDescriptors;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.Scenes.Screens.GameMainMenu;
import com.example.thedragonslair.config.GameConfig;
import com.example.thedragonslair.util.CodeResources;

public class Loading extends GeneralScreen {

    private static final Logger log = new Logger(Loading.class.getName(), Logger.DEBUG);
    private static final float PROGRESS_BAR_WIDTH = GameConfig.WU_WORLD_WIDTH/2f;
    private static final float PROGRESS_BAR_HEIGHT = GameConfig.WU_DEFAULT_CELL_SIZE;


    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected ShapeRenderer renderer;


    private float loadingProgress;
    private float waitingTime; //Tiempo de margen que va a pasar DESPUÉS de cargar los assets
    private boolean changeScreen; //false por defecto
    protected Texture texture;

    public Loading(MyGdxGame myGdxGame) {
        super(myGdxGame);
        this.loadingProgress = 0f;
        this.waitingTime = 0.75f;
        this.changeScreen = false;
    }

    @Override
    public void show() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        log.debug("show");

        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.PIXEL_WIDTH,GameConfig.PIXEL_HEIGHT,camera);
        renderer = new ShapeRenderer();

        texture = new Texture("logo/logo.png");

        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO00_DES);
        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO01_DES);
        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO02_DES);
        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO03_DES);
        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO04_DES);
        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO05_DES);
        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO06_DES);
        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO07_DES);

        assetManager.load(AssetsDescriptors.FONT_COMIC_DES);
        assetManager.load(AssetsDescriptors.BACKGROUND01_DES);
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

        isGame.getBatch().begin();
        isGame.getBatch().draw(texture,
                0,
                0
        );
        isGame.getBatch().end();

        if(changeScreen){
            isGame.setScreen(new GameMainMenu(isGame));
        }
    }

    private void update(float delta){
        CodeResources.waitmillisecs(400);
        loadingProgress = assetManager.getProgress(); //entre 0 y 1
        if(assetManager.update()){ //true cuando todos los assets estén cargados
            waitingTime -= delta;
            if(waitingTime <= 0){
                changeScreen = true;
            }
        }
    }

    /**
     * Dibuja la barra de progreso
     */
    private void draw(){
        float progressBarX = (GameConfig.WU_WORLD_WIDTH-PROGRESS_BAR_WIDTH)/2;
        float progressBarY = (GameConfig.PIXEL_HEIGHT-PROGRESS_BAR_HEIGHT)/2;

        renderer.setColor(Color.BLACK);
        renderer.rect(GameConfig.WU_DEFAULT_CELL_SIZE, progressBarY,
                loadingProgress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT);
    }

    /**
     * Le da tamaño a la pantalla
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
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
        renderer = null;
    }
}
