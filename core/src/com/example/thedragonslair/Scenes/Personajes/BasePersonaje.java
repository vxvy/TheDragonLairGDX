package com.example.thedragonslair.Scenes.Personajes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class BasePersonaje extends Actor {

    protected Texture[] spritesActor;
    protected int currentSprite;
    public BasePersonaje() {}

    /**
     *
     * @param delta sirve para que podamos actualizar el actor según el tiempo
     */
    @Override
    public void act(float delta) {
        super.act(delta);
    }

    /**
     *
     * @param batch al igual que stage, actor usa batch aquí viene a ser un conjunto de sprites pertenecientes al actor
     * @param parentAlpha opacidad del actor en pantalla
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

    }
}
