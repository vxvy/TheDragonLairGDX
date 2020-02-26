package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.AssetsCode.AssetsDescriptors;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Personajes.BaseActor;

import static com.example.thedragonslair.config.GameConfig.WU_WORLD_HEIGHT;
import static com.example.thedragonslair.config.GameConfig.WU_WORLD_WIDTH;

public class Pdj1 extends PantallaDeJuegoBase {

//    //Hay que ir con cuidado porque
//    //no siempre se ejecuta el constructor antes del show
//    //por eso las nuevas instanciaciones están en el show

    private TiledMap mapPB; //tutorial seguido para los mapas: https://www.youtube.com/watch?v=zckxJn751Gw
    private OrthogonalTiledMapRenderer renderer;
//    private OrthographicCamera camera;    Stage crea una cámara por defecto
    private Viewport viewport;
//    private SpriteBatch batch;            Stage contiene uno por defecto
    private Stage stage;
    private Texture texture;
//    private ArrayList<Enemy> enemies;


    private ShapeRenderer shapeRenderer;
//    private Siegfried siegfried;
    private BaseActor baseActor;

    public Pdj1(MyGdxGame myGdxGame) {
        super(myGdxGame);
//        enemies = new ArrayList<Enemy>();
//        Enemy aux = new Enemy(1,0,);
        //int enemyValue, int enemyCurrentFrame, Texture[] enemyFrames, int enemyAttackValue)
    }

    @Override
    public void show() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        viewport = new FitViewport(WU_WORLD_WIDTH, WU_WORLD_HEIGHT);
        stage = new Stage(viewport);

        texture = isGame.getAssetManager().get(AssetsDescriptors.SIEGFRIED_ANDANDO_DES);
        // TmxMapLoader loader = new TmxMapLoader();
        // mapPB = loader.load("maps/stages/floor0/pb.tmx");

        //Creamos al personaje
        baseActor = new BaseActor(new TextureRegion(texture));
//        siegfried = new Siegfried();
        //Le damos posición. No se le resta el tamaño del player???
//        siegfried.setPosition(
//                // GameConfig.WU_HALF_WIDTH_CENTER , //(WU) world units
//                // GameConfig.WU_HALF_HEIGHT_CENTER
//                WU_WORLD_WIDTH/2f,
//                WU_WORLD_HEIGHT/2f
//        );
        //tamaño del actor
        baseActor.setSize(100,100);
        baseActor.setPosition(
                (WU_WORLD_WIDTH-baseActor.getWidth())/2f,
                (WU_WORLD_HEIGHT-baseActor.getHeight())/2f
                );
//        baseActor.addListener(new )

        stage.addActor(baseActor);

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
        texture.dispose();
//        mapPB.dispose();
        renderer.dispose();
    }


//    public void setEnemies(ArrayList<Enemy> enemies) {
//
//    }
}