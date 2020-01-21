package com.example.thedragonslair;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.Color;

import static javax.swing.UIManager.getColor;


public class MyGdxGame extends ApplicationAdapter {

	private Stage stage;
	Texture texture;
	Image image1;

	@Override
	public void create () {
		this.stage = new Stage(new ScreenViewport());
		this.texture = new Texture(Gdx.files.internal("menustuff\\background\\menuprovisionalbackground.png"));
		this.image1 = new Image(texture);
		this.image1.setPosition(
				Gdx.graphics.getWidth()/3-image1.getWidth()/2,
				Gdx.graphics.getHeight()*2/3-image1.getHeight()/2
		);
		this.image1.setPosition(
				0,
				Gdx.graphics.getHeight()
		);
		this.stage.addActor(image1);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();


	}
	
	@Override
	public void dispose () {
	}
}
