package com.example.thedragonslair.Scenes.Screens.loading;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.config.GameConfig;
import com.example.thedragonslair.util.CeilingViewer;
import com.example.thedragonslair.util.CodeResources;

public class LoadingScreen extends GeneralScreen implements InputProcessor {

    private static final float PROGRESS_BAR_WIDTH = 500;
    private static final float PROGRESS_BAR_HEIGHT = 100;
    private static final Logger log = new Logger(LoadingScreen.class.getName(), Logger.DEBUG);

    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private Texture texture;

    private float loadingProgress = 100f;
    private float waitingTime = 0.75f; //Tiempo de margen que va a pasar DESPUÉS de cargar los assets
    private boolean changeScreen; //false por defecto

    public LoadingScreen(MyGdxGame myGdxGame) {
        super(myGdxGame);
    }

    public void show() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        log.debug("show");
        camera = new OrthographicCamera();
//        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), camera);
        viewport = new FitViewport(GameConfig.WU_WORLD_WIDTH,GameConfig.WU_WORLD_HEIGHT, camera);
        shapeRenderer = new ShapeRenderer();

        Gdx.input.setInputProcessor(this);
    }

//    @Override
//    public void show() {
//        super.show();
//    }


    @Override
    public void render(float delta) {
        CodeResources.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        draw();
        batch.end();
    }

    private void draw(){
//        int touchX = Gdx.input.getX();
//        int touchY = Gdx.input.getY();
//
//
//        log.debug("Ha tocado en x: " + touchX + " y en y: "+touchY);
        // Esto funcionó con éxito
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.rect(10,10,100,100);
            shapeRenderer.end();

    }



    @Override
    public void resize(int width, int height) {
//        viewport.update(width,height);
        viewport.update(width,height,true); //Técnicamente centra la cámara, pero pone el eje arriba izquierda???
        CeilingViewer.debugPixelPerUnit(viewport);
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
        shapeRenderer.dispose();
//        estoEsElJuego.getBatch().dispose(); // No hacer dispose
    }

    //=================================================================
    //============== Input Processor
    //=================================================================

    /**
     *
     * @return false cuando el evento no se gestiona, true cuando sí
     */

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        log.debug("Touch DOWN2 on "+screenX+" - "+screenY);;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        log.debug("Touch UP2 on "+screenX+" - "+screenY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        log.debug("Touch DRAGGING2 on "+screenX+" - "+screenY);
        return true;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

    //
//    @Override
//    public void show() {
//        Gdx.app.setLogLevel(Application.LOG_DEBUG);
//        log.debug("show");
//
//        camera = new OrthographicCamera();
//        viewport = new FitViewport(GameConfig.PIXEL_WIDTH,GameConfig.PIXEL_HEIGHT,camera);
//        renderer = new ShapeRenderer();
//
//        texture = new Texture("logo/logo.png");
//
//        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO00_DES);
//        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO01_DES);
//        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO02_DES);
//        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO03_DES);
//        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO04_DES);
//        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO05_DES);
//        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO06_DES);
//        assetManager.load(AssetsDescriptors.SIEGFRIED_ANDANDO07_DES);
//
//        assetManager.load(AssetsDescriptors.FONT_COMIC_DES);
//        assetManager.load(AssetsDescriptors.BACKGROUND01_DES);
//    }
//
//    @Override
//    public void render(float delta) {
//        update(delta);
//        CodeResources.clearScreen();
//        viewport.apply(); //Es una buena práctica aplicar el viewport para cuando cambiemos el tipo de viewport
//        renderer.setProjectionMatrix(camera.combined);
//        renderer.begin(ShapeRenderer.ShapeType.Filled);
//        renderer.rect(10,10,200,200);
//
//        draw();
//        renderer.end();
//
//        if(changeScreen){
//            this.estoEsElJuego.setScreen(new GameMainMenu(this.estoEsElJuego));
//        }
//    }
//
//    private void update(float delta){
//        CodeResources.waitmillisecs(400);
//        loadingProgress = assetManager.getProgress(); //entre 0 y 1
//        if(assetManager.update()){ //true cuando todos los assets estén cargados
//            waitingTime -= delta;
//            if(waitingTime <= 0){
//                changeScreen = true;
//            }
//        }
//    }
//
//    /**
//     * Dibuja la barra de progreso
//     */
//    private void draw(){
//        float progressBarX = (GameConfig.PIXEL_WIDTH-PROGRESS_BAR_WIDTH)/2;
//        float progressBarY = (GameConfig.PIXEL_HEIGHT-PROGRESS_BAR_HEIGHT)/2;
//
//        renderer.rect(GameConfig.WU_DEFAULT_CELL_SIZE, progressBarY,
//                loadingProgress * PROGRESS_BAR_WIDTH, PROGRESS_BAR_HEIGHT);
//    }
//
//    /**
//     * Le da tamaño a la pantalla
//     * @param width
//     * @param height
//     */
//    @Override
//    public void resize(int width, int height) {
//        viewport.update(width,height);
//    }
//
//
//    /**
//     * Cuando termine la pantalla de carga, se llama automátivamente al hide, no al dispose
//     */
//    @Override
//    public void hide() {
//        log.debug("hide");
//        dispose();
//    }
//
//    /**
//     * Cabe remarcar que las pantallas por detecto no se tiran, se ocultan
//     */
//    @Override
//    public void dispose() {
//        log.debug("dispose");
//        renderer.dispose();
//        renderer = null;
//    }
//}