package com.example.thedragonslair.Personajes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Logger;

public class BaseActor extends Actor {

    private static final float BOUNDS_X_WU_SIZE = 1f;
    private static final float BOUNDS_Y_WU_SIZE = 1f;

    private final TextureRegion region;

    public static final Logger log = new Logger(BaseActor.class.getName(), Logger.DEBUG);

    //Recordemos que Actor no incluye de por sí ninguna textura, con lo que este parámetro
    // siempre será necesario
    private float posXIni;
    private float posYIni;
    private float posXFin;
    private float posYFin;

    private Rectangle boundsRect;

    //Constructor
    public BaseActor(TextureRegion textureRegion) {
        region = textureRegion;

        this.boundsRect = new Rectangle(posXIni, posYIni, posXFin, posYFin);


    }

    /**
     * Equivalente a "update"
     * Sirve para actualizar el estado del actor
     * @param delta tiempo de la última ejecución
     */
    @Override
    public void act(float delta) {
        log.debug("act on actor = " + this);
        super.act(delta);
    }

    /**
     * Es necesario hacer el override para que se dibuje el actor
     * @param batch
     * @param parentAlpha
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color);

        batch.draw(
                region,
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(),getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );
    }

    public void setPosition(float x, float y){
        this.posXIni = x;
        this.posYIni = y;
        this.posXFin = x + BOUNDS_X_WU_SIZE;
        this.posYFin = y + BOUNDS_Y_WU_SIZE;
        this.updateRectBounds();
    }

    private void updateRectBounds(){
        boundsRect.setPosition(posXIni,posYIni);
    }

    public void drawDebug(ShapeRenderer renderer){
        renderer.rect(
                boundsRect.x, boundsRect.y,
                boundsRect.width, boundsRect.height
        );
    }
}