package com.example.thedragonslair.Personajes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BaseActor extends Actor {

    private final TextureRegion region;
    //Recordemos que Actor no incluye de por sí ninguna textura, con lo que este parámetro
    // siempre será necesario

    public BaseActor(TextureRegion region) {
        this.region=region;

    }

    /**
     * Equivalente a "update"
     * Sirve para actualizar el estado del actor
     * @param delta tiempo de la última ejecución
     */
    @Override
    public void act(float delta) {
        super.act(delta);
    }

    /**
     * Es necesario hacer el override para que se dibuje el actor
     * @param batch
     * @param parentAlpha
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        //te has quedado aquí
    }
}
