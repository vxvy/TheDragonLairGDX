package com.example.thedragonslair.Scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.example.thedragonslair.MyGdxGame;

//Esta clase existe para que las demás hereden de ella
//Así, todas tendrán acceso al juego
public abstract class GeneralScreen implements Screen {

    protected MyGdxGame estoEsElJuego;
    protected AssetManager assetManager;

    public GeneralScreen(MyGdxGame estoEsElJuego){
        this.estoEsElJuego = estoEsElJuego;
        this.assetManager = estoEsElJuego.getAssetManager();


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
        this.dispose();
    }

    @Override
    public void dispose() {

    }
}
