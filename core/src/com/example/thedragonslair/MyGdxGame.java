package com.example.thedragonslair;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.example.thedragonslair.util.LoadingScreen;


//    Gdx.app.log("Tag", "Debug message");
public class MyGdxGame extends Game {

	public static Skin gameSkin;
	private AssetManager assetManager;
	private SpriteBatch batch;

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		gameSkin = new Skin(Gdx.files.internal("skin\\skinsMaster\\glassy\\skin\\glassy-ui.json"));
//		gameSkin = new Skin(Gdx.files.internal("skin\\skinsMaster\\vhs\\skin\\vhs-ui.json"));
//		gameSkin = new Skin(Gdx.files.internal("skin\\skinsMaster\\gdx-holo\\skin\\uiskin.json"));

		assetManager = new AssetManager();

		batch = new SpriteBatch();

//		this.setScreen(new GameMainMenu(this));
		this.setScreen(new LoadingScreen(this)); //Sólo disponible cuando extends Game
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		gameSkin.dispose();
		assetManager.dispose();
		batch.dispose();
	}

	public MyGdxGame() {
		super();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
	}

	@Override
	public Screen getScreen() {
		return super.getScreen();
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}

	public SpriteBatch getBatch() {
		return batch;
	}

}