package com.example.thedragonslair.Assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

//Tutorial para entender el assets manager: https://www.youtube.com/watch?v=JXThbQir2gU

public class Assets {
    public static final AssetManager assetManager = new AssetManager();
    public static final String pathWarrior0 ="\\warrior\\f0.png";
    public static final String pathWarrior1 ="\\warrior\\f1.png";
    public static final String pathWarrior2="\\warrior\\f2.png";
    public static final String pathWarrior3 ="\\warrior\\f3.png";
    public static final String pathWarrior4 ="\\warrior\\f4.png";
    public static final String pathWarrior5 ="\\warrior\\f5.png";
    public static final String pathWarrior6 ="\\warrior\\f6.png";
    public static final String pathWarrior7 ="\\warrior\\f7.png";

    public static void load(){
        assetManager.load(pathWarrior0 , Texture.class);
        assetManager.load(pathWarrior1 , Texture.class);
        assetManager.load(pathWarrior2 , Texture.class);
        assetManager.load(pathWarrior3 , Texture.class);
        assetManager.load(pathWarrior4 , Texture.class);
        assetManager.load(pathWarrior5 , Texture.class);
        assetManager.load(pathWarrior6 , Texture.class);
        assetManager.load(pathWarrior7 , Texture.class);
        //Esto no carga realmente, sólo lo añade a la queue de carga
    }

    public static void dispose(){
        assetManager.dispose();
    }

}
