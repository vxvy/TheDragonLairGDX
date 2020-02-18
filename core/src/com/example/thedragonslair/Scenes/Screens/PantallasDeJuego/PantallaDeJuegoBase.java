package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.GameRenderer;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.Personajes.MainCharacter.Siegfried;


//Aquí sucede el juego
public abstract class PantallaDeJuegoBase extends GeneralScreen {
    protected Stage stage;
    protected Siegfried siegfried;
    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected ShapeRenderer shapeRenderer;
    protected TiledMap mapPB; //tutorial seguido para los mapas: https://www.youtube.com/watch?v=zckxJn751Gw
    protected OrthogonalTiledMapRenderer mapRenderer;

    public PantallaDeJuegoBase(MyGdxGame estoEsElJuego) {
        super(estoEsElJuego);
    }
}
