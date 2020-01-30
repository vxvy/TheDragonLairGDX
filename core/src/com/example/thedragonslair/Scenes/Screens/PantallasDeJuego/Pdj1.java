package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Personajes.Enemigos.Enemy;
import com.example.thedragonslair.Personajes.MainCharacter.Siegfried;
import com.example.thedragonslair.Scenes.Screens.GameMainMenu;

import java.util.ArrayList;

public class Pdj1 extends PantallaDeJuegoBase {

//    //Hay que ir con cuidado porque
//    //no siempre se ejecuta el constructor antes del show
//    //por eso las nuevas instanciaciones están en el show

    private TiledMap mapPB; //tutorial seguido para los mapas: https://www.youtube.com/watch?v=zckxJn751Gw
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private ArrayList<Enemy> enemies;

    public Pdj1(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);

        siegfried = new Siegfried();
        enemies = new ArrayList<Enemy>();
//        Enemy aux = new Enemy(1,0,);
        //int enemyValue, int enemyCurrentFrame, Texture[] enemyFrames, int enemyAttackValue)

    }

    @Override
    public void show() {
        super.show();
        TmxMapLoader loader = new TmxMapLoader();
        mapPB = loader.load("maps/stages/floor0/pb.tmx");

        renderer = new OrthogonalTiledMapRenderer(mapPB);
        camera = new OrthographicCamera();


        stage = new Stage(new ScreenViewport());
        stage.addActor(siegfried);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setView(camera);
        renderer.render();
//        renderer.render(arrayDeCapasQueCargar); Se puede elegir las capas que se quieren cargar

        stage.draw();
        stage.act(delta);

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

        stage.dispose();
        mapPB.dispose();
        renderer.dispose();
    }


    public void setEnemies(ArrayList<Enemy> enemies) {

    }
}