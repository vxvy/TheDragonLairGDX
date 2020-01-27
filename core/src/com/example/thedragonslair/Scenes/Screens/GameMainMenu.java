package com.example.thedragonslair.Scenes.Screens;

import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.Scenes.Screens.PantallasDeJuego.Pdj1;


//Pantalla de menu desde la que accedemos a juego
public class GameMainMenu extends GeneralScreen {
    public GameMainMenu(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
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
    }
}
