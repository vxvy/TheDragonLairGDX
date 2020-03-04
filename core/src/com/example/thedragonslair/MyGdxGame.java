package com.example.thedragonslair;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Logger;
import com.example.thedragonslair.Scenes.Screens.PantallasDeJuego.GameScreen;
import com.example.thedragonslair.Scenes.Screens.loading.LoadingScreen;

//Game incluye  todo lo que necesitamos de AplicationAdapter
//AplicationAdapter tiene los métodos de AplicationListener (create, dispose, etc.)
//Además incorpora el métpdo "setScreen" que usaremos para cambiar entre pantallas
public class MyGdxGame extends Game {

	public static final Logger log = new Logger(MyGdxGame.class.getName(), Logger.DEBUG);

//	public static Skin gameSkin;
	private AssetManager assetManager;
	private SpriteBatch batch;

	/**
	 * El constructor tiene menos prioridad que el create()
	 * en esta clase, por lo que lo mantendremos vacío
	 */

	public MyGdxGame() {
		super();
	}

	/**
	 * Inicializa el juego y de carga los recursos
	 */
	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);		// Los logs están deshabilitados por defecto en libgdx,
														// Con esto se habilitan y se determina un canal
//		log.debug("placeholder");						// Ejemplo imperecedero de log.

//		gameSkin = new Skin(Gdx.files.internal("skin\\skinsMaster\\glassy\\skin\\glassy-ui.json"));
//		gameSkin = new Skin(Gdx.files.internal("skin\\skinsMaster\\gdx-holo\\skin\\uiskin.json"));

		assetManager = new AssetManager();

		batch = new SpriteBatch();

		//loading assets
		assetManager = new AssetManager();
		assetManager.getLogger().setLevel(Logger.DEBUG);

		this.setScreen(new LoadingScreen(this));
//		this.setScreen(new GameScreen(this));
	}


	/**
	 * Se ejecuta por defecto 60 veces por segudo
	 * Se usa para renderizar los elementos del juego
	 */

	@Override
	public void render () {
		super.render();
	}

	/**
	 * Libera recursos al cerrar el juego
	 */

	@Override
	public void dispose () {
		assetManager.dispose();
		batch.dispose();
	}

	/**
	 * Se usa para gestionar el estado del juego cuando este
	 * deja de estar en primer plano/focus.
	 * No tiene por qué pausar el juego.
	 * Se puede usar para guardar el "gamestate" actual
	 */

	@Override
	public void pause() {
		super.pause();
	}

	/**
	 * Es el contrario de pause.
	 * Se usa para gestionar qué hace el juego al recuperar el primer plano/foocus
	 */

	@Override
	public void resume() {
		super.resume();
	}

	/**
	 * Determina el tamaño de la pantalla en "full screen"
	 * Se ejecuta en la primera ejecución y cada vez que el juego
	 * "regresa" a primer plano
	 * @param width anchura de la pantalla en píxels físicos
	 * @param height altura de la pantalla en píxels físicos
	 */
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	//***************************************************
	// GETTERS AND SETTERS
	//***************************************************

	/**
	 * Método propio de la clase Game,
	 * permite cambiar de escena fácilmente
	 * @param screen Pantalla a la que cambiaremos, es necesario que herede de Screen
	 */
	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
	}

	/**
	 * Método para obtener el gestor de assets
	 * @return el gestor de assets contiene el contenido "no-código" del juego
	 */
	public AssetManager getAssetManager() {
		return assetManager;
	}

	/**
	 * El spriteBatch es la capa que usamos para dibujar.
	 * Podemos usar batch o stage.
	 * @return batch correspondiente al juego, lo instanciamos una sola vez porque es muy pesado
	 */
	public SpriteBatch getBatch() {
		return batch;
	}

}