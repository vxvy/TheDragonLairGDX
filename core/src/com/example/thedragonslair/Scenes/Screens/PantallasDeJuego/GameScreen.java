package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.AssetsCode.AssetsDescriptors;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Personajes.MainCharacter.Siegfried;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.config.GameConfig;
import com.example.thedragonslair.util.CodeResources;

import static com.brashmonkey.spriter.Spriter.draw;
import static com.example.thedragonslair.AssetsCode.AssetsPaths.FONT_COMIC_PATH;

public class GameScreen extends GeneralScreen{



    public static final Logger log = new Logger(MyGdxGame.class.getName(), Logger.DEBUG);

    protected OrthographicCamera camera;
    protected Viewport viewport;

//    protected Stage stage;
//    protected Siegfried siegfried;
//    protected ShapeRenderer shapeRenderer;
//    protected TiledMap mapPB; //tutorial seguido para los mapas: https://www.youtube.com/watch?v=zckxJn751Gw
//    protected OrthogonalTiledMapRenderer mapRenderer;

    public GameScreen(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), camera);
//        estoEsElJuego.getBatch();
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
        int touchX = Gdx.input.getX();
        int touchY = Gdx.input.getY();


        log.debug("Ha tocado en x: " + touchX + " y en y: "+touchY);
    }



    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
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
//        shapeRenderer.dispose();
//        estoEsElJuego.getBatch().dispose(); // No hacer dispose 
    }
}
