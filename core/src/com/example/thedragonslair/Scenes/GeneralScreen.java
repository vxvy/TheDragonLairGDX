package com.example.thedragonslair.Scenes;

import com.badlogic.gdx.Screen;
import com.example.thedragonslair.MyGdxGame;

//Esta clase existe para que las demás hereden de ella
//Así, todas tendrán acceso al juego
public abstract class GeneralScreen implements Screen {

    protected MyGdxGame estoEsElJuego;
    public GeneralScreen(MyGdxGame estoEsElJuego){
        this.estoEsElJuego = estoEsElJuego;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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

    }
}
