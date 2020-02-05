package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.AssetsCode.AssetsDescriptors;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Personajes.MainCharacter.Siegfried;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.config.GameConfig;
import com.example.thedragonslair.util.CodeResources;

public class GameScreen extends GeneralScreen{

    protected Stage stage;
    protected Siegfried siegfried;
    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected ShapeRenderer shapeRenderer;
    protected TiledMap mapPB; //tutorial seguido para los mapas: https://www.youtube.com/watch?v=zckxJn751Gw
    protected OrthogonalTiledMapRenderer mapRenderer;

    public GameScreen(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
        stage = new Stage();
        siegfried = new Siegfried();
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.VISUAL_WORLD_WIDTH, GameConfig.VISUAL_WORLD_HEIGHT, camera);
        shapeRenderer = new ShapeRenderer();

    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        CodeResources.clearScreen();

        drawDebuj();
    }

    public void drawDebuj(){

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
        shapeRenderer.dispose();
    }
}
