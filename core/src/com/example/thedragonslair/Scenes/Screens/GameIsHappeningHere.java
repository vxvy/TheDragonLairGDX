package com.example.thedragonslair.Scenes.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.example.thedragonslair.MyGdxGame;
import com.example.thedragonslair.Scenes.GeneralScreen;
import com.example.thedragonslair.Scenes.Screens.PantallasDeJuego.GameScreen;
import com.example.thedragonslair.config.GameStrings;
import com.example.thedragonslair.util.CodeResources;

import static com.example.thedragonslair.AssetsCode.AssetsPaths.BACKGROUND01_PATH;
import static com.example.thedragonslair.AssetsCode.AssetsPaths.SKIN_GLASSY_PATH;
import static com.example.thedragonslair.config.GameConfig.LANGUAGE_SPA;

public class GameIsHappeningHere extends GeneralScreen {

    private static final Logger log = new Logger(GameIsHappeningHere.class.getName(), Logger.DEBUG);
//    Siegfried siegfried; //instanciamos el personaje principal al abrir el juego porque será el mismo en todas las pantallas de juego
    protected AssetManager assetManager;
    protected Stage stage;
    protected Skin menu2Skin;
    protected GameStrings gameStrings;
    protected Texture backgroundTitle;

    public GameIsHappeningHere(MyGdxGame myGdxGame) {
        super(myGdxGame);
        gameStrings = new GameStrings(LANGUAGE_SPA);

        assetManager = myGdxGame.getAssetManager();
        menu2Skin = assetManager.get(SKIN_GLASSY_PATH, Skin.class);

        stage = new Stage(new ScreenViewport());

        backgroundTitle = assetManager.get(BACKGROUND01_PATH,Texture.class);
        Image placeholderBackground = new Image(backgroundTitle);
        placeholderBackground.setFillParent(true);
        stage.addActor(placeholderBackground);

        Label title = new Label(gameStrings.gameTitle, menu2Skin,"big");
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        TextButton resumeButton = new TextButton(gameStrings.btnStrContinue, menu2Skin);
        resumeButton.setWidth(Gdx.graphics.getWidth()/2);
        resumeButton.setPosition(Gdx.graphics.getWidth()/2-resumeButton.getWidth()/2,Gdx.graphics.getHeight()/2-resumeButton.getHeight()/2);
        resumeButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.app.log("123","Touched");
                isGame.setScreen(new GameScreen(isGame));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(resumeButton);

        TextButton newGameButton = new TextButton(gameStrings.btnStrNewGame,menu2Skin);
        newGameButton.setWidth(Gdx.graphics.getWidth()/2);
        newGameButton.setPosition(Gdx.graphics.getWidth()/2-newGameButton.getWidth()/2,Gdx.graphics.getHeight()/4-newGameButton.getHeight()/2);
        newGameButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                isGame.setScreen(new GameMainMenu(isGame));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(newGameButton);

        TextButton backButton = new TextButton("X",menu2Skin);
//        backButton
    }


    @Override
    public void show() {
        Gdx.app.log("MainScreen","show");
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        CodeResources.clearScreen(Color.ORANGE);

        stage.act();
        stage.draw();
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
        log.debug("hide");
        dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
//        assetManager.dispose(); Se realiza este dispose en la clase principal para así ejecutarlo una sola vez
    }
}
