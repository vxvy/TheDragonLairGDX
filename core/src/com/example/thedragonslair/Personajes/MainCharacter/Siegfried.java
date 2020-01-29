package com.example.thedragonslair.Personajes.MainCharacter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.thedragonslair.Personajes.BasePersonaje;

public class Siegfried extends BasePersonaje {

    private Texture[] siegfriedWalking;
    private Texture[] siegfriedAttaking;
    private Texture[] siegfriedDying;

    public Siegfried() {
        this.siegfriedWalking =  new Texture[]{
          new Texture("warrior\\f0.png"),
          new Texture("warrior\\f1.png"),
          new Texture("warrior\\f2.png"),
          new Texture("warrior\\f3.png"),
          new Texture("warrior\\f4.png"),
          new Texture("warrior\\f5.png"),
          new Texture("warrior\\f6.png"),
          new Texture("warrior\\f7.png")
        };
        spritesActor = siegfriedWalking; //Esto es realmente innecesario


    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(spritesActor[currentSprite],getX(),getY());
    }
}
