package com.example.thedragonslair;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

//Tutorial para entender el assets manager: https://www.youtube.com/watch?v=JXThbQir2gU

public class AssetsHandler {
    public static final AssetManager assetManager = new AssetManager();

    public static final String WARRIORSPRITE0 ="warrior/f0.png";
    public static final String WARRIORSPRITE1 ="warrior/f1.png";
    public static final String WARRIORSPRITE2="warrior/f2.png";
    public static final String WARRIORSPRITE3 ="warrior/f3.png";
    public static final String WARRIORSPRITE4 ="warrior/f4.png";
    public static final String WARRIORSPRITE5 ="warrior/f5.png";
    public static final String WARRIORSPRITE6 ="warrior/f6.png";
    public static final String WARRIORSPRITE7 ="warrior/f7.png";

    public static final String ENEMY_WEAK0 ="enemies/enemigo1/enemy1_00";
    public static final String ENEMY_WEAK1 ="enemies/enemigo1/enemy1_00";

    public static final String ENEMY_SUB0 ="enemies/enemigo2/foe2_f0.png";
    public static final String ENEMY_SUB1 ="enemies/enemigo2/foe2_f1.png";
    public static final String ENEMY_SUB2 ="enemies/enemigo2/foe2_f2.png";
    public static final String ENEMY_SUB3 ="enemies/enemigo2/foe2_f3.png";


    public static final String ENEMY_STRONG0 ="enemies/enemigo3/foe3_f0.png";
    public static final String ENEMY_STRONG1 ="enemies/enemigo3/foe3_f1.png";

    public static final String ENEMY_STRONG_ATK ="enemies/enemigo3/foe3_atk.png";

    public static final String LLAMA1 ="maps/flames/llama1.png";
    public static final String LLAMA2 ="maps/flames/llama2.png";

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
