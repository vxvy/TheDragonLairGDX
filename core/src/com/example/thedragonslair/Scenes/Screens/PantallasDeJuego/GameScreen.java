package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Personajes.MainCharacter.Siegfried;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.config.GameConfig;
import com.example.thedragonslair.util.CeilingViewer;
import com.example.thedragonslair.util.CodeResources;

//public class GameScreen extends GeneralScreen{
public class GameScreen extends GeneralScreen implements InputProcessor {

    public static final Logger log = new Logger(MyGdxGame.class.getName(), Logger.DEBUG);

    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected ShapeRenderer shapeRenderer;
    protected SpriteBatch batch;
    protected boolean drawGrid = false;

//    protected Stage stage;
    protected Siegfried siegfried;
//    protected TiledMap mapPB; //tutorial seguido para los mapas: https://www.youtube.com/watch?v=zckxJn751Gw
//    protected OrthogonalTiledMapRenderer mapRenderer;

    public GameScreen(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

//        Siegfried siegfried = new Siegfried();
        camera = new OrthographicCamera();
//        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), camera);
        viewport = new FitViewport(GameConfig.WU_WORLD_WIDTH,GameConfig.WU_WORLD_HEIGHT, camera);
        shapeRenderer = new ShapeRenderer();
        this.batch=new SpriteBatch();

        Gdx.input.setInputProcessor(this);
   }

//    @Override
//    public void show() {
//        super.show();
//    }

    @Override
    public void show() {

    }

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
        if(drawGrid){
            CeilingViewer.drawGrid(viewport,shapeRenderer);
        }else{
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.rect(10,10,100,100);
            shapeRenderer.end();
        }
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