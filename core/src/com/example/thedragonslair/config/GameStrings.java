package com.example.thedragonslair.config;

import static com.example.thedragonslair.config.GameConfig.LANGUAGE_ENG;
import static com.example.thedragonslair.config.GameConfig.LANGUAGE_SPA;

public class GameStrings {

    public String gameTitle;
    public String btnStrStart;
    public String btnStrOptions;
    public String btnStrBack;
    public String btnStrNewGame;
    public String btnStrContinue;
    public String msgLoading;
    public String textStoryIntro;
    public String siegD1;
//    public String

    public GameStrings(String language){
        switch (language){
            case LANGUAGE_SPA:
                gameTitle = "La guarida del Dragon";
                btnStrStart = "Entrar en la mazmorra";
                btnStrOptions = "Opciones";
                btnStrBack = "Atras";
                msgLoading = "Cargando, espera por favor...";
                btnStrNewGame = "Juego nuevo";
                btnStrContinue = "Continuar";
                textStoryIntro = "Había una vez, un conejo mago morado llamado Moradín." +
                        "Moradín era un poco peculiar. En vez de vivir en una madriguera vivía en un castillo." +
                        "El terrible castillo Draconiano suscitaba rumores y creaba leyendas. Pero no era más que piedras." +
                        "..." +
                        "Hasta que un día, decidió adoptat a Fafnir el dragón y se acabó la tranquilidad, " +
                        "pues este se había metido en algún que otro berengenal aquí y allá." +
                        "Concretamente, ganándose la enemistad alguien llamado Siegfried...";
                siegD1 = "¡FAFNIR! Malditas sean tus entrañas... Avaro bastardo, ¿cómo osas rehuír a mi encuentro? " +
                        "Me debes al menos la posibilidad de vengar a mi padre";
                break;
            default:
            case LANGUAGE_ENG:
                gameTitle = "The Dragon's lair";
                btnStrStart = "Enter the Dungeon";
                btnStrOptions = "Options";
                btnStrBack = "Back";
                msgLoading = "Loagin assets, please wait...";
                btnStrNewGame = "New Game";
                btnStrContinue = "Continue";
                break;
        }
    }

}
