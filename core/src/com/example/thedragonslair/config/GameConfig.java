package com.example.thedragonslair.config;

// Screen Size vs World Size
// https://gamedev.stackexchange.com/questions/120722/screensize-vs-worldsize


// la última respuesta es quizás la forma adecuada de escalar, pero no la voy a usar
// https://gamedev.stackexchange.com/questions/81067/yet-another-libgdx-resolution-independance-question
public class GameConfig {
    private GameConfig(){} // Impedimos la instanciación de la clase

    public static final float PIXEL_WIDTH = 1080f;
    public static final float PIXEL_HEIGHT = 720f;

    public static final float VISUAL_WORLD_WIDTH = 10.8f; //WORLD UNITS
    public static final float VISUAL_WORLD_HEIGHT = 7.2f; //WORLD UNITS



    public static final float VISUAL_WORLD_WIDTH_CENTER = VISUAL_WORLD_WIDTH/2f; //WORLD UNITS
    public static final float VISUAL_WORLD_HEIGHT_CENTER = VISUAL_WORLD_HEIGHT/2f; //WORLD UNITS
}
