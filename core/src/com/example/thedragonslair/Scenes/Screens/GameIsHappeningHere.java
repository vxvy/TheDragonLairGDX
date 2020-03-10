package com.example.thedragonslair.Scenes.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
import com.example.thedragonslair.Scenes.Screens.PantallasDeJuego.Pdj0;
import com.example.thedragonslair.config.GameStrings;
import com.example.thedragonslair.util.CodeResources;

import static com.example.thedragonslair.AssetsCode.AssetsPaths.BACKGROUND01_PATH;
import static com.example.thedragonslair.AssetsCode.AssetsPaths.LLAMAS_PATH;
import static com.example.thedragonslair.AssetsCode.AssetsPaths.LOGO_PATH;
import static com.example.thedragonslair.AssetsCode.AssetsPaths.SKIN_GLASSY_PATH;
import static com.example.thedragonslair.config.GameConfig.LANGUAGE_SPA;
import static com.example.thedragonslair.util.CodeResources.COLOR_BRIGHT_ORANGY;
import static com.example.thedragonslair.util.CodeResources.COLOR_ORANGY;

public class GameIsHappeningHere extends GeneralScreen {

    private static final Logger log = new Logger(GameIsHappeningHere.class.getName(), Logger.DEBUG);
//    Siegfried siegfried; //instanciamos el personaje principal al abrir el juego porque será el mismo en todas las pantallas de juego
    protected AssetManager assetManager;
    protected Stage stage;
    protected Skin menuSkin;
//    protected Skin menu2Skin;
    protected GameStrings gameStrings;

    public GameIsHappeningHere(MyGdxGame myGdxGame) {
        super(myGdxGame);
        gameStrings = new GameStrings(GameStrings.eLanguage.LANGUAGE_SPA);
        assetManager = myGdxGame.getAssetManager();
//        menu2Skin = assetManager.get(SKIN_NEON_PATH, Skin.class);
        menuSkin = assetManager.get(SKIN_GLASSY_PATH, Skin.class);
        stage = new Stage(new ScreenViewport()); //screen viewport para evitar bandas a los lados, ya que en el menú no import que haya diferentes tamaños

        int altura = Gdx.graphics.getHeight();
        int anchura = Gdx.graphics.getWidth();

        Image placeholderBackground = new Image(assetManager.get(BACKGROUND01_PATH,Texture.class));
        placeholderBackground.setFillParent(true);
        stage.addActor(placeholderBackground);

        placeholderBackground = new Image(assetManager.get(LOGO_PATH,Texture.class));
        placeholderBackground.setScale(1/4f);
        placeholderBackground.setColor(Color.WHITE);
        placeholderBackground.setPosition(
                anchura-(placeholderBackground.getWidth()*placeholderBackground.getScaleX()),
                altura-(placeholderBackground.getHeight()*placeholderBackground.getScaleY())
        );
        placeholderBackground.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isGame.setScreen(new GameMainMenu(isGame));
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(placeholderBackground);


        Label title = new Label(gameStrings.gameTitle, menuSkin,"big");
        title.setColor(COLOR_BRIGHT_ORANGY);
        title.setFontScale(2); //aumenta el tamaño de la etiqueta
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);

        TextButton resumeButton = new TextButton(gameStrings.btnStrContinue, menuSkin);
        resumeButton.setColor(Color.DARK_GRAY);
        resumeButton.getLabel().setColor(COLOR_ORANGY);
        resumeButton.setWidth(Gdx.graphics.getWidth()/2);
        resumeButton.setPosition(Gdx.graphics.getWidth()/2-resumeButton.getWidth()/2,Gdx.graphics.getHeight()/2-resumeButton.getHeight()/2);
        resumeButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.app.log("123","Touched");
                isGame.setScreen(new GameScreen(isGame));  //lanza la partida que hemos dejado a medias
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(resumeButton);

        TextButton newGameButton = new TextButton(gameStrings.btnStrNewGame,menuSkin);
        newGameButton.setColor(Color.DARK_GRAY);
        newGameButton.getLabel().setColor(COLOR_ORANGY);
        newGameButton.setWidth(Gdx.graphics.getWidth()/2);
        newGameButton.setPosition(Gdx.graphics.getWidth()/2-newGameButton.getWidth()/2,Gdx.graphics.getHeight()/4-newGameButton.getHeight()/2);
        newGameButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                isGame.setScreen(new Pdj0(isGame));         //Inicia el juego desde 0
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(newGameButton);

        /*
        ImageButton backButton = new ImageButton(menuSkin,"default");
//        backButton.setColor(Color.ORANGE); //no funciona demasiado bien con colores claros
//        backButton.setWidth(Gdx.graphics.getHeight()/12); // ancho en relación al alto
        backButton.setWidth(120); // ancho en relación al alto
//        backButton.setHeight(Gdx.graphics.getHeight()/12);// tamaño en relación al alto
        backButton.setHeight(120);// tamaño en relación al alto
        backButton.setPosition(Gdx.graphics.getWidth()-backButton.getWidth(),Gdx.graphics.getHeight()-backButton.getHeight());
        backButton.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isGame.setScreen(new GameMainMenu(isGame));
                }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(backButton);
        */
    }


    @Override
    public void show() {
        Gdx.app.log("MainScreen","show");
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        CodeResources.clearScreen(COLOR_ORANGY);

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
