package com.example.thedragonslair.util;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.example.thedragonslair.MyGdxGame;

public class LoadingScreen extends ScreenAdapter {

    //Constantes

    private final MyGdxGame esteEsElJuego;
    private final AssetManager assetManager;

    public LoadingScreen(MyGdxGame myGdxGame) {
        esteEsElJuego = myGdxGame;
        assetManager = myGdxGame.getAssetManager();
    }



}
