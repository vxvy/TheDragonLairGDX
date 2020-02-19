package com.example.thedragonslair.config;

// Screen Size vs World Size
// https://gamedev.stackexchange.com/questions/120722/screensize-vs-worldsize


// la última respuesta es quizás la forma adecuada de escalar, pero no la voy a usar
// https://gamedev.stackexchange.com/questions/81067/yet-another-libgdx-resolution-independance-question
public class GameConfig {
    private GameConfig(){} // Impedimos la instanciación de la clase

    public static final float PIXEL_WIDTH = 800f; //Aspect ratio 4:3
    public static final float PIXEL_HEIGHT = 600f; //Aspect ratio 4:3


    //tamaño virtual del mundo a dibujar
    public static final float WU_WORLD_WIDTH = 80f; //WORLD UNITS
    public static final float WU_WORLD_HEIGHT = 60f; //WORLD UNITS

    public static final float WU_HALF_WIDTH_CENTER = WU_WORLD_WIDTH /2f; //WORLD UNITS
    public static final float WU_HALF_HEIGHT_CENTER = WU_WORLD_HEIGHT /2f; //WORLD UNITS

    public static final int WU_DEFAULT_CELL_SIZE = 5; //world units
}