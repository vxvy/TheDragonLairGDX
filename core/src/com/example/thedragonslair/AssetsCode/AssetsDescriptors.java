package com.example.thedragonslair.AssetsCode;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class AssetsDescriptors {

    //_________________________________________________
    //TESTTING 01
    //_________________________________________________

    public static final AssetDescriptor<Texture> LOGO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.LOGO_PATH,Texture.class);

    //_________________________________________________
    //_________________________________________________

    public static final AssetDescriptor<Texture> BACKGROUND01_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY_WEAK0_PATH, Texture.class);

    //_________________________________________________
    //FONT
    //_________________________________________________

    public static final AssetDescriptor<BitmapFont> FONT_COMIC_DES
            = new AssetDescriptor<BitmapFont>(AssetsPaths.FONT_COMIC_PATH, BitmapFont.class);

    //_________________________________________________
    //ENEMIGO 01
    //_________________________________________________

    public static final AssetDescriptor<Texture> ENEMY_WEAK0_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY_WEAK0_PATH, Texture.class);
    public static final AssetDescriptor<Texture> ENEMY_WEAK1_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY_WEAK1_PATH, Texture.class);

    //_________________________________________________
    //ENEMIGO 02
    //_________________________________________________

    public static final AssetDescriptor<Texture> ENEMY_SUB0_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY_SUB0_PATH, Texture.class);
    public static final AssetDescriptor<Texture> ENEMY_SUB1_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY_SUB1_PATH, Texture.class);
    public static final AssetDescriptor<Texture> ENEMY_SUB2_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY_SUB2_PATH, Texture.class);
    public static final AssetDescriptor<Texture> ENEMY_SUB3_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY_SUB3_PATH, Texture.class);


    //_________________________________________________
    //ENEMIGO 03
    //_________________________________________________

    public static final AssetDescriptor<Texture> ENEMY_STRONG0_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY_STRONG0_PATH, Texture.class);
    public static final AssetDescriptor<Texture> ENEMY_STRONG1_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY_STRONG1_PATH, Texture.class);


    //_________________________________________________
    //GRÁFICOS SIEGFRIED CORRIENDO
    //_________________________________________________

    public static final AssetDescriptor<Texture> SIEGFRIED_ANDANDO00_DES
            = new AssetDescriptor<Texture>(AssetsPaths.WARRIORSPRITE0_PATH, Texture.class);
    public static final AssetDescriptor<Texture> SIEGFRIED_ANDANDO01_DES
            = new AssetDescriptor<Texture>(AssetsPaths.WARRIORSPRITE1_PATH, Texture.class);
    public static final AssetDescriptor<Texture> SIEGFRIED_ANDANDO02_DES
            = new AssetDescriptor<Texture>(AssetsPaths.WARRIORSPRITE2_PATH, Texture.class);
    public static final AssetDescriptor<Texture> SIEGFRIED_ANDANDO03_DES
            = new AssetDescriptor<Texture>(AssetsPaths.WARRIORSPRITE3_PATH, Texture.class);
    public static final AssetDescriptor<Texture> SIEGFRIED_ANDANDO04_DES
            = new AssetDescriptor<Texture>(AssetsPaths.WARRIORSPRITE4_PATH, Texture.class);
    public static final AssetDescriptor<Texture> SIEGFRIED_ANDANDO05_DES
            = new AssetDescriptor<Texture>(AssetsPaths.WARRIORSPRITE5_PATH, Texture.class);
    public static final AssetDescriptor<Texture> SIEGFRIED_ANDANDO06_DES
            = new AssetDescriptor<Texture>(AssetsPaths.WARRIORSPRITE6_PATH, Texture.class);
    public static final AssetDescriptor<Texture> SIEGFRIED_ANDANDO07_DES
            = new AssetDescriptor<Texture>(AssetsPaths.WARRIORSPRITE7_PATH, Texture.class);

    //_________________________________________________
    //GRÁFICOS SIEGFRIED ATACANDO
    //_________________________________________________



    //_________________________________________________
    //GRÁFICOS SIEGFRIED MURIENDO
    //_________________________________________________


    //_________________________________________________
    //GRÁFICOS SIEGFRIED QUIETO
    //_________________________________________________



    //_________________________________________________
    //MAZMORRA 01
    //_________________________________________________
    public static final AssetDescriptor<TiledMap> MAP_PB_DES
            = new AssetDescriptor<TiledMap>(AssetsPaths.MAP_PB_PATH, TiledMap.class);

    //_________________________________________________
    //MAZMORRA 02
    //_________________________________________________


    //_________________________________________________
    //MAZMORRA 03
    //_________________________________________________




    private AssetsDescriptors() { //no queremos que se instancie
    }
}
