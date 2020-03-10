package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.AssetsCode.AssetsDescriptors;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Personajes.BaseActor;
import com.example.thedragonslair.Personajes.Siegfried;
import com.example.thedragonslair.Scenes.Screens.GameMainMenu;

import static com.example.thedragonslair.AssetsCode.AssetsPaths.LOGO_PATH;
import static com.example.thedragonslair.AssetsCode.AssetsPaths.SIEGFRIED_STANDING_PATH;
import static com.example.thedragonslair.config.GameConfig.WU_DEFAULT_CELL_SIZE;
import static com.example.thedragonslair.config.GameConfig.WU_WORLD_HEIGHT;
import static com.example.thedragonslair.config.GameConfig.WU_WORLD_WIDTH;

public class Pdj1 extends PantallaDeJuegoBase {


    private ShapeRenderer shapeRenderer;
    private BaseActor baseActor;
    private AssetManager assetManager;
    private OrthographicCamera camera;
    private Siegfried siegfried;

    public Pdj1(MyGdxGame myGdxGame) {
        super(myGdxGame);

        assetManager = myGdxGame.getAssetManager();

        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(WU_WORLD_WIDTH, WU_WORLD_HEIGHT, camera);
        stage = new Stage(viewport);

        //botón atrás
        Image placeholderBackground = new Image(assetManager.get(LOGO_PATH,Texture.class));
        placeholderBackground.setScale(1/4f);
        placeholderBackground.setColor(Color.WHITE);
        placeholderBackground.setPosition(
                viewport.getWorldWidth()-(placeholderBackground.getWidth()*placeholderBackground.getScaleX()),
                viewport.getWorldHeight()-(placeholderBackground.getHeight()*placeholderBackground.getScaleY())
        );
        placeholderBackground.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isGame.setScreen(new GameMainMenu(isGame));
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(placeholderBackground);

        //Creamos al enemigo
        baseActor = new BaseActor(
                assetManager.get(SIEGFRIED_STANDING_PATH, Texture.class),
                64,
                64,
                1,
                5

        );
        //Le damos posición. No se le resta el tamaño del player???
//        siegfried.setPosition(
//                // GameConfig.WU_HALF_WIDTH_CENTER , //(WU) world units
//                // GameConfig.WU_HALF_HEIGHT_CENTER
//                WU_WORLD_WIDTH/2f,
//                WU_WORLD_HEIGHT/2f
//        );
        //tamaño del actor
        baseActor.setSize(WU_DEFAULT_CELL_SIZE*2,WU_DEFAULT_CELL_SIZE*2*2);
        baseActor.setPosition(
                (WU_WORLD_WIDTH/2-baseActor.getWidth())/2f,
                (WU_WORLD_HEIGHT/2-baseActor.getHeight())/2f
                );

        stage.addActor(baseActor);

        siegfried = new Siegfried();
        siegfried.setAssetManager(assetManager); //siempre será necesario pasarle el asset manager


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        renderer.setView(camera);
//        renderer.render();
//        renderer.render(arrayDeCapasQueCargar); Se puede elegir las capas que se quieren cargar

        renderDebug(); //Nos muestra el cuadrado de coolisiones del personaje

        stage.act(delta);
        stage.draw();

    }

    private void renderDebug(){
        //Dibujar gradilla
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        drawDebug();
        shapeRenderer.end();
    }

    private void drawDebug(){
        baseActor.drawDebug(shapeRenderer);

    }

    @Override
    public void resize(int width, int height) {
        camera.viewportHeight = height;
        camera.viewportWidth = width;
        camera.update();
        viewport.update(width,height,true);
        //imprimir por consola de debug lo de los px/WU
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
//        texture.dispose();
//        mapPB.dispose();
//        renderer.dispose();
    }


//    public void setEnemies(ArrayList<Enemy> enemies) {
//
//    }
}