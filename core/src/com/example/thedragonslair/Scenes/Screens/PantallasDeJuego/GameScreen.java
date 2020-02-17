package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.config.GameConfig;
import com.example.thedragonslair.util.CeilingViewer;
import com.example.thedragonslair.util.CodeResources;

public class GameScreen extends GeneralScreen{
//public class GameScreen extends GeneralScreen implements InputProcessor {

    public static final Logger log = new Logger(MyGdxGame.class.getName(), Logger.DEBUG);

    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected ShapeRenderer shapeRenderer;


//    protected Stage stage;
//    protected Siegfried siegfried;
//    protected TiledMap mapPB; //tutorial seguido para los mapas: https://www.youtube.com/watch?v=zckxJn751Gw
//    protected OrthogonalTiledMapRenderer mapRenderer;

    public GameScreen(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
//        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), camera);
        viewport = new FitViewport(GameConfig.VISUAL_WORLD_WIDTH,GameConfig.VISUAL_WORLD_HEIGHT, camera);
        shapeRenderer = new ShapeRenderer();
        //        estoEsElJuego.getBatch();

        InputMultiplexer inputMultiplexer = new InputMultiplexer();

        InputAdapter inputAdapterUno = new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                log.debug("Touch DOWN on "+screenX+" - "+screenY);
                CeilingViewer.debugPixelPerUnit(viewport);
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                log.debug("Touch UP on "+screenX+" - "+screenY);
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                log.debug("Touch DRAGGING on "+screenX+" - "+screenY);
                return true;
            }
        };
        InputAdapter inputAdapterDos = new InputAdapter(){
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
        };
            inputMultiplexer.addProcessor(inputAdapterUno);
            inputMultiplexer.addProcessor(inputAdapterDos);

            Gdx.input.setInputProcessor(inputMultiplexer);
        }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        CodeResources.clearScreen();

        estoEsElJuego.getBatch().setProjectionMatrix(camera.combined);
        estoEsElJuego.getBatch().begin();
        draw();
        estoEsElJuego.getBatch().end();
    }

    private void draw(){
//        int touchX = Gdx.input.getX();
//        int touchY = Gdx.input.getY();
//
//
//        log.debug("Ha tocado en x: " + touchX + " y en y: "+touchY);
        // Esto funcionó con éxito
        CeilingViewer.drawGrid(viewport,shapeRenderer);
    }



    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
        CeilingViewer.debugPixelPerUnit(viewport);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void hide() {
        super.hide();
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

//    @Override
//    public boolean keyDown(int keycode) {
//        return false;
//    }
//
//    @Override
//    public boolean keyUp(int keycode) {
//        return false;
//    }
//
//    @Override
//    public boolean keyTyped(char character) {
//        return false;
//    }
//
//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        log.debug("Touch DOWN on "+screenX+" - "+screenY);
//        return true;
//    }
//
//    @Override
//    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//        log.debug("Touch UP on "+screenX+" - "+screenY);
//        return true;
//    }
//
//    @Override
//    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        log.debug("Touch DRAGGING on "+screenX+" - "+screenY);
//        return true;
//    }
//
//    @Override
//    public boolean mouseMoved(int screenX, int screenY) {
//        return false;
//    }
//
//    @Override
//    public boolean scrolled(int amount) {
//        return false;
//    }
}
