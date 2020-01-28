package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.example.thedragonslair.MyGdxGame;

public class Pdj1 extends PantallaDeJuegoBase {

    //Hay que ir con cuidado porque
    //no siempre se ejecuta el constructor antes del show
    //por eso las nuevas instanciaciones están en el show
    public Pdj1(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
    }

    private TiledMap mapPB; //tutorial seguido para los mapas: https://www.youtube.com/watch?v=zckxJn751Gw
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    @Override
    public void show() {
        super.show();
        TmxMapLoader loader = new TmxMapLoader();
        mapPB = loader.load("maps\\stages\\floor0\\pb.tmx");

        renderer = new OrthogonalTiledMapRenderer(mapPB);
        camera = new OrthographicCamera();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setView(camera);
        renderer.render();
//        renderer.render(arrayDeCapasQueCargar); Se puede elegir las capas que se quieren cargar
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        camera.viewportHeight = height;
        camera.viewportWidth = width;
        camera.update();
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
        super.dispose();


        mapPB.dispose();
        renderer.dispose();
    }
}
