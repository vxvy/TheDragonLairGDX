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
    private Viewport viewport;
    private ArrayList<Enemy> enemies;


    private ShapeRenderer shapeRenderer;
    private Siegfried siegfried;

    public Pdj1(MyGdxGame myGdxGame) {
        super(myGdxGame);

//        enemies = new ArrayList<Enemy>();
//        Enemy aux = new Enemy(1,0,);
        //int enemyValue, int enemyCurrentFrame, Texture[] enemyFrames, int enemyAttackValue)

    }

    @Override
    public void show() {
        // TmxMapLoader loader = new TmxMapLoader();
        // mapPB = loader.load("maps/stages/floor0/pb.tmx");

        renderer = new OrthogonalTiledMapRenderer(mapPB);
        camera = new OrthographicCamera();
        viewport = new FitViewport(GameConfig.WU_WORLD_WIDTH,GameConfig.WU_WORLD_HEIGHT, camera);

        //Creamos al personaje
        siegfried = new Siegfried();
        //Le damos posición. No se le resta el tamaño del player???
        siegfried.setPosition(
            // GameConfig.WU_HALF_WIDTH_CENTER , //(WU) world units
            // GameConfig.WU_HALF_HEIGHT_CENTER
            WU_WORLD_WIDTH/2f,
            WU_WORLD_HEIGHT/2f
        ); 

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

        renderDebug(); //Nos muestra el cuadrado de coolisiones del personaje

        stage.draw();
        stage.act(delta);

    }

    private void renderDebug(){
        //Dibujar gradilla
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(shapeRenderer.ShapeType.Line);
        drawDebug();
        shapeRenderer.end();
    }

    private void drawDebug(){
        siegfried.drawDebug(shapeRenderer);

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
        mapPB.dispose();
        renderer.dispose();
    }


    public void setEnemies(ArrayList<Enemy> enemies) {

    }
}