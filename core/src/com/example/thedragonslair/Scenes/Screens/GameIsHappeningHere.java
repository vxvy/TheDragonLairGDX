package com.example.thedragonslair.Scenes.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.example.thedragonslair.AssetsHandler;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.Personajes.MainCharacter.Siegfried;
import com.example.thedragonslair.Scenes.Screens.PantallasDeJuego.Pdj1;

public class GameIsHappeningHere extends GeneralScreen {

    public MyGdxGame esteEsElJuego;
    AssetsHandler assetsHandler;
    Siegfried siegfried; //instanciamos el personaje principal al abrir el juego porque será el mismo en todas las pantallas de juego
    Stage stage;

    public GameIsHappeningHere(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
        assetsHandler.load(); //Al tener las asignaciones de recursos establecidas en la clase assetsHandler sólo la cargamos una vez
        while(!assetsHandler.assetManager.update()){ //Sin esto no cargan los recursos que quedaron en la queue

        }

        this.esteEsElJuego = estoEsElJuego;
        stage = new Stage(new ScreenViewport());

        Label title = new Label("Playing Screen", MyGdxGame.gameSkin,"big-black");
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        TextButton backButton = new TextButton("Back",MyGdxGame.gameSkin);
        backButton.setWidth(Gdx.graphics.getWidth()/2);
        backButton.setPosition(Gdx.graphics.getWidth()/2-backButton.getWidth()/2,Gdx.graphics.getHeight()/4-backButton.getHeight()/2);
        backButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                esteEsElJuego.setScreen(new GameMainMenu(esteEsElJuego));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(backButton);

        estoEsElJuego.setScreen(new Pdj1(estoEsElJuego));

    }


    @Override
    public void show() {
        Gdx.app.log("MainScreen","show");
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
        super.dispose();
        stage.dispose();
        assetsHandler.dispose(); //Al tener la retirada de recursos en assetsHandler, sólo es necesaria una llamada
    }
}
