package com.example.thedragonslair.Scenes.Screens;

import com.example.thedragonslair.Assets.Assets;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.Scenes.Personajes.MainCharacter.Siegfried;
import com.example.thedragonslair.Scenes.Screens.PantallasDeJuego.Pdj1;

public class GameIsHappeningHere extends GeneralScreen {

    Assets assets;
    Siegfried siegfried; //instanciamos el personaje principal al abrir el juego porque será el mismo en todas las pantallas de juego

    public GameIsHappeningHere(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
        assets.load(); //Al tener las asignaciones de recursos establecidas en la clase assets sólo la cargamos una vez
        while(!assets.assetManager.update()){ //Sin esto no cargan los recursos que quedaron en la queue

        }


        estoEsElJuego.setScreen(new Pdj1(estoEsElJuego));

    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
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
        assets.dispose(); //Al tener la retirada de recursos en assets, sólo es necesaria una llamada
    }
}
