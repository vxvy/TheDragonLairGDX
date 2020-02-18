package com.example.thedragonslair.Scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.example.thedragonslair.MyGdxGame;

//Esta clase existe para que las demás hereden de ella
//Así, todas tendrán acceso al juego
public abstract class GeneralScreen implements Screen {

    protected MyGdxGame isGame;
    protected AssetManager assetManager;
    protected SpriteBatch batch;

    public GeneralScreen(MyGdxGame myGdxGame){
        isGame = myGdxGame;
        assetManager = isGame.getAssetManager();
        batch = isGame.getBatch();
    }
}