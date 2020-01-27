package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.example.thedragonslair.Assets.Assets;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.Scenes.Personajes.MainCharacter.Siegfried;


//Aquí sucede el juego
public abstract class PantallaDeJuegoBase extends GeneralScreen {
    protected Stage stage;
    protected Siegfried siegfried;

    public PantallaDeJuegoBase(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
    }

}
