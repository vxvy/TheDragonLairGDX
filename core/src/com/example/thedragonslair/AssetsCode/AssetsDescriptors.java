package com.example.thedragonslair.AssetsCode;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetsDescriptors {

    /**
     * ==================================
     * Siegfried
     * ==================================
     */

    //_________________________________________________
    //SIEGFRIED STANDING
    //_________________________________________________

    public static final AssetDescriptor<Texture> SIEGFRIED_PARADO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.SIEGFRIED_STANDING_PATH, Texture.class);

    // _________________________________________________
    //SIEGFRIED ANDANDO
    //_________________________________________________

    public static final AssetDescriptor<Texture> SIEGFRIED_ANDANDO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.SIEGFRIED_WALKING_PATH, Texture.class);

    //_________________________________________________
    //GRÁFICOS SIEGFRIED SALTANDO
    //_________________________________________________

    public static final AssetDescriptor<Texture> SIEGFRIED_SALTANDO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.SIEGFRIED_JUMPING_PATH, Texture.class);

    //_________________________________________________
    //GRÁFICOS SIEGFRIED MURIENDO
    //_________________________________________________

    public static final AssetDescriptor<Texture> SIEGFRIED_MUERIENDO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.SIEGFRIED_DYING_PATH, Texture.class);

    //_________________________________________________
    //GRÁFICOS SIEGFRIED GOLPEADO
    //_________________________________________________

    public static final AssetDescriptor<Texture> SIEGFRIED_GOLPEADO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.SIEGFRIED_HURT_PATH, Texture.class);

    //_________________________________________________
    //GRÁFICOS SIEGFRIED LOGRO
    //_________________________________________________

    public static final AssetDescriptor<Texture> SIEGFRIED_LOGRO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.SIEGFRIED_ACHIVEMENT_PATH, Texture.class);

    //_________________________________________________
    //GRÁFICOS SIEGFRIED ESPADA
    //_________________________________________________

    public static final AssetDescriptor<Texture> SIEGFRIED_ESPADA_DES
            = new AssetDescriptor<Texture>(AssetsPaths.SIEGFRIED_HITTING_PATH, Texture.class);

    /**
     * ==================================
     * Enemigos
     * ==================================
     */

    //_________________________________________________
    // ENEMIGO 01
    //_________________________________________________

    public static final AssetDescriptor<Texture> ENEMIGO1_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY1_64x160_PATH, Texture.class);

    //_________________________________________________
    // ENEMIGO 02
    //_________________________________________________

    public static final AssetDescriptor<Texture> ENEMIGO2_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY2_128x128_PATH, Texture.class);

    //_________________________________________________
    // ENEMIGO 03
    //_________________________________________________

    public static final AssetDescriptor<Texture> ENEMIGO3_DES
            = new AssetDescriptor<Texture>(AssetsPaths.ENEMY3_128x64_PATH, Texture.class);

    /**
     * ==================================
     * Tiles
     * ==================================
     */

    //_________________________________________________
    // LLAMA
    //_________________________________________________

    public static final AssetDescriptor<Texture> LLAMAS_DES
            = new AssetDescriptor<Texture>(AssetsPaths.LLAMAS_PATH, Texture.class);

    /**
     * ==================================
     * Cosas del juego
     * ==================================
     */

    //_________________________________________________
    //LOGO
    //_________________________________________________

    public static final AssetDescriptor<Texture> LOGO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.LOGO_PATH,Texture.class);

    //_________________________________________________
    // BACKGROUND 01
    //_________________________________________________

    public static final AssetDescriptor<Texture> BACKGROUND01_DES
            = new AssetDescriptor<Texture>(AssetsPaths.BACKGROUND01_PATH, Texture.class);

    //_________________________________________________
    // CUT TITLE
    //_________________________________________________

    public static final AssetDescriptor<Texture> CUT_TITLE_DES
            = new AssetDescriptor<Texture>(AssetsPaths.CUT_TITLE_PATH, Texture.class);

    //_________________________________________________
    // VIDAS
    //_________________________________________________

//    public static final AssetDescriptor<Texture> VIDAS_DES
//            = new AssetDescriptor<Texture>(AssetsPaths.CUT_TITLE_PATH, Texture.class);

    //_________________________________________________
    // FONT
    //_________________________________________________

    public static final AssetDescriptor<BitmapFont> NARRATIVE_FONT_DES
            = new AssetDescriptor<BitmapFont>(AssetsPaths.NARRATIVE_FONT_PATH, BitmapFont.class);

    //_________________________________________________
    // SKIN
    //_________________________________________________

    public static final AssetDescriptor<Skin> SKIN_GLASSY_DES
            = new AssetDescriptor<Skin>(AssetsPaths.SKIN_GLASSY_PATH, Skin.class);

    public static final AssetDescriptor<Skin> SKIN_GOLDEN_DES
            = new AssetDescriptor<Skin>(AssetsPaths.SKIN_GOLDEN_PATH, Skin.class);

    public static final AssetDescriptor<Skin> SKIN_SQUARE_DES
            = new AssetDescriptor<Skin>(AssetsPaths.SKIN_SQUARED_PATH, Skin.class);

    /**
     * ==================================
     * Escenarios
     * ==================================
     */

    //_________________________________________________
    //MAZMORRA PB
    //_________________________________________________

    public static final AssetDescriptor<Texture> PB_PARED_DES
            = new AssetDescriptor<Texture>(AssetsPaths.PB_TILE_PARED_PATH, Texture.class);
    public static final AssetDescriptor<Texture> PB_SUELO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.PB_TILE_SUELO_PATH, Texture.class);

    //_________________________________________________
    //MAZMORRA 01
    //_________________________________________________

    public static final AssetDescriptor<Texture> P1_PARED_DES
            = new AssetDescriptor<Texture>(AssetsPaths.P1_TILE_PARED_PATH, Texture.class);
    public static final AssetDescriptor<Texture> P1_SUELO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.P1_TILE_SUELO_PATH, Texture.class);

    //_________________________________________________
    //MAZMORRA 02
    //_________________________________________________

    public static final AssetDescriptor<Texture> P2_PARED_DES
            = new AssetDescriptor<Texture>(AssetsPaths.P2_TILE_PARED_PATH, Texture.class);
    public static final AssetDescriptor<Texture> P2_SUELO_DES
            = new AssetDescriptor<Texture>(AssetsPaths.P2_TILE_SUELO_PATH, Texture.class);

    private AssetsDescriptors() { //no queremos que se instancie
    }
}