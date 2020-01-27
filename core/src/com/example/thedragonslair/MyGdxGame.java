package com.example.thedragonslair;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.example.thedragonslair.Scenes.Screens.GameMainMenu;


public class MyGdxGame extends Game {

	static public Skin gameSkin;

	@Override
	public void create () {
		gameSkin = new Skin(Gdx.files.internal("skin\\skinsMaster\\glassy\\skin\\glassy-ui.json"));
//		gameSkin = new Skin(Gdx.files.internal("skin\\skinsMaster\\vhs\\skin\\vhs-ui.json"));
//		gameSkin = new Skin(Gdx.files.internal("skin\\skinsMaster\\gdx-holo\\skin\\uiskin.json"));
		this.setScreen(new GameMainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
	}
}
