package com.example.thedragonslair.Personajes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.XmlFaultAction;
import com.sun.javafx.font.directwrite.RECT;

public class BaseActor extends Actor {

    private static final float BOUNDS_X_WU_SIZE = 1f;
    private static final float BOUNDS_Y_WU_SIZE = 1f;
    
    private final TextureRegion region;
    //Recordemos que Actor no incluye de por sí ninguna textura, con lo que este parámetro
    // siempre será necesario
    private float posXIni;
    private float posYIni;
    private float posXFin;
    private float posYFin;

    private RECT boundsRect;

    public BaseActor() {
        this.boundsRect = new Rect(posXIni, posYIni, posXFin, posYFin);


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

    public void setPosition(float x, float y){
        this.posXIni = x;
        this.posYIni = y;
        this.posXFin = x + BOUNDS_X_WU_SIZE;
        this.posYFin = y + BOUNDS_Y_WU_SIZE;
        this.updateRectBounds();
    }

    private void updateRectBounds(){
        boundsRect.setPosition(posXIni,posYIni,posXFin,posYFin);
    }

    public void drawDebug(ShapeRenderer renderer){
        renderer.Rect(
            boundsRect.left, boundsRect.bottom,
            boundsRect.top, boundsRect.right
        );
    }
}