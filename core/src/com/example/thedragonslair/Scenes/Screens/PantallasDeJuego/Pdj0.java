package com.example.thedragonslair.Scenes.Screens.PantallasDeJuego;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.example.thedragonslair.MyGdxGame;

import static com.example.thedragonslair.AssetsCode.AssetsPaths.BACKGROUND01_PATH;
import static com.example.thedragonslair.AssetsCode.AssetsPaths.NARRATIVE_FONT_PATH;

//Esta clase pretende ser una "escena" introductoria de la historia
//Aquí se contará lo descrito en el documento
public class Pdj0 extends PantallaDeJuegoBase {

    AssetManager assetManager;
    public Stage stage;
    public Texture background1;
    public BitmapFont bmFont;

    public Pdj0(MyGdxGame myGdxGame) {
        super(myGdxGame);
        assetManager = myGdxGame.getAssetManager();

        stage = new Stage();

        bmFont = assetManager.get(NARRATIVE_FONT_PATH, BitmapFont.class);
        background1 = assetManager.get(BACKGROUND01_PATH, Texture.class);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {



    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}