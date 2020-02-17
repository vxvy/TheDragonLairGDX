package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.graphics.Texture;
import com.example.thedragonslair.AssetsCode.AssetsDescriptors;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Personajes.MainCharacter.Siegfried;

//Esta clase pretende ser una "escena" introductoria de la historia
//Aquí se contará lo descrito en el documento
public class Pdj0 extends PantallaDeJuegoBase {

    Texture background1;
    Siegfried siegfried;

    public Pdj0(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
        background1 = assetManager.get(AssetsDescriptors.BACKGROUND01_DES);

        siegfried = new Siegfried();
    }

    @Override
    public void show() {
        assetManager.load(AssetsDescriptors.BACKGROUND01_DES);
        assetManager.finishLoading();



    }

    @Override
    public void render(float delta) {



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