package com.example.thedragonslair.AssetsCode;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

//Tutorial para entender el assets manager: https://www.youtube.com/watch?v=JXThbQir2gU

public class AssetsHandler {
    public static final AssetManager assetManager = new AssetManager();

    public static void load(){
//        assetManager.load(WARRIORSPRITE0 , Texture.class);
//        assetManager.load(WARRIORSPRITE1 , Texture.class);
//        assetManager.load(WARRIORSPRITE2 , Texture.class);
//        assetManager.load(WARRIORSPRITE3 , Texture.class);
//        assetManager.load(WARRIORSPRITE4 , Texture.class);
//        assetManager.load(WARRIORSPRITE5 , Texture.class);
//        assetManager.load(WARRIORSPRITE6 , Texture.class);
//        assetManager.load(WARRIORSPRITE7 , Texture.class);
        //Esto no carga realmente, sólo lo añade a la queue de carga

        assetManager.finishLoading();
    }

    public static void dispose(){
        assetManager.dispose();
    }

}
