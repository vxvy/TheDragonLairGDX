package com.example.thedragonslair.Personajes;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Logger;

import static com.example.thedragonslair.config.GameConfig.FRAMES_PER_SECOND;
import static com.example.thedragonslair.config.GameConfig.WU_DEFAULT_CELL_SIZE;
import static com.example.thedragonslair.config.GameConfig.WU_WORLD_HEIGHT;
import static com.example.thedragonslair.config.GameConfig.WU_WORLD_WIDTH;

public class BaseActor extends Actor implements InputProcessor {

    public enum eWhereIsFacing{
        DIAGONAL_IZQUIERDA_ARRIBA(0),
        DIAGONAL_DERECHA_ARRIBA(1),
        DIAGONAL_IZQUIERDA_ABAJO(2),
        DIAGONAL_DERECHA_ABAJO(3),
        ARRIBA(4),
        IZQUIERDA(5),
        DERECHA(6),
        ABAJO(7);

        private int whereIsFacing;
        private eWhereIsFacing(int whereIsFacing){
            this.whereIsFacing = whereIsFacing;
        }
        public int getWhereIsFacing() {
            return whereIsFacing;
        }
    }

    private static final float WU_XSIZE_ACTOR = WU_DEFAULT_CELL_SIZE;
    private static final float WU_YSIZE_ACTOR = WU_DEFAULT_CELL_SIZE;

    //Textura contenedora
    //Recordemos que Actor no incluye de por sí ninguna textura, con lo que este parámetro
    // siempre será necesario
    private Texture texture;
    public Texture getTexture() {
        return texture;
    }
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    // Frame del array que está se visualiza en ese momento
    // TODO Se puede sacar de animation
    private int currentFrame = 0;
    public int getCurrentFrame() {
        return currentFrame;
    }
    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    // Tiempo/FRAMES_PER_SECOND que va a durar cada frame de la animación
    private float frameSpan = 1;
    public float getFrameSpan() {
        return frameSpan;
    }
    public void setFrameSpan(float frameSpan) {
        this.frameSpan = frameSpan;
    }

    /**
     * ====================================
     * Frames
     * ====================================
     */

    // Secuencia de frames en uso
    private TextureRegion[] region;
    public TextureRegion[] getRegion() {
        return region;
    }
    public void setRegion(TextureRegion[] region) {
        this.region = region;
    }
    /**
     * Sobrecarga en que se le indica la "direccin" a la que mira
     */
    public void setRegion(TextureRegion[][] regionBi, int whereIsItFacing) {
        this.region = regionBi[whereIsItFacing];
    }
    public void setRegion(int horizontalCut, int verticalCut, int numElemEjeX) {
        this.region = cutAndSetRegion(horizontalCut, verticalCut, numElemEjeX);
    }
    // Colección de frames actual, puede cambiar según el estado del Actor
    // Por ejemplo, cuando el actor está corriendo tiene un set(TextureRegion[][])
    // distinto a cuando está saltando
    private TextureRegion[][] textureRegions;
    public TextureRegion[][] getTextureRegions() {
        return textureRegions;
    }
    public void setTextureRegions(TextureRegion[][] textureRegions) {
        this.textureRegions = textureRegions;
    }
    /**
     * Comparte parámetros y definición con cutAndSetRegion
     * @param horizontalCut
     * @param verticalCut
     * @param numElemEjeX
     * @param numElemEjeY
     */
    public void setTextureRegions(int horizontalCut, int verticalCut, int numElemEjeX, int numElemEjeY) {
        this.textureRegions = cutAndSetRegion(horizontalCut,verticalCut,numElemEjeX,numElemEjeY);
    }


    private Animation animation; //recordemos que hay que usar floats para la animation o no se visualiza
    public Animation getAnimation() {
        return animation;
    }
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public static final Logger log = new Logger(BaseActor.class.getName(), Logger.DEBUG);

    //Posiciones de los bounds
    protected float posXIni;
    protected float posYIni;
    protected float posXFin;
    protected float posYFin;
    protected Rectangle boundsRect;
    public void setPosition(float posXIni, float posYIni){
        this.posXIni = posXIni;
        this.posYIni = posYIni;
        this.posXFin = posXIni + WU_XSIZE_ACTOR;
        this.posYFin = posYIni + WU_YSIZE_ACTOR;
        this.updateRectBounds();
    }

    /**
     * *********************************************
     *  CONSTRUCTOR
     * *********************************************
     *
     * Constructor para actores que sólo dispongan de una tira de sprites
     *
     * @param texture
     * @param horizontalCut
     * @param verticalCut
     * @param numElemEjeX
     * @param numElemEjeY
     */

    public BaseActor(Texture texture, int horizontalCut, int verticalCut, int numElemEjeX, int numElemEjeY){
        this.boundsRect = new Rectangle(
                posXIni, posYIni,
                posXFin, posYFin
        ); //el listener de acciones funciona sólo después de asignar los bounds
        this.setTouchable(Touchable.enabled);

        this.texture = texture;
        if(numElemEjeY>0){
            this.setTextureRegions(horizontalCut, verticalCut, numElemEjeX, numElemEjeY);
        }else {
            this.setRegion(horizontalCut, verticalCut, numElemEjeX);
        }

        this.setSize(WU_XSIZE_ACTOR,WU_YSIZE_ACTOR);
        this.setX(WU_WORLD_WIDTH/2 - WU_XSIZE_ACTOR/2);
        this.setY(WU_WORLD_HEIGHT/2 - WU_YSIZE_ACTOR/2);
    }

    /**
     * *********************************************
     *  CONSTRUCTOR
     * *********************************************
     *
     * Vacío por si en algún momento necesito crearlo vacío como sucede con Siegfried
    */

    public BaseActor(){}

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
                region[currentFrame],
                getX(), getY(),
                getOriginX(), getOriginY(),
                getWidth(),getHeight(),
                getScaleX(), getScaleY(),
                getRotation()
        );
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

    protected int yJumps = 0;

    /**
     * Método para una sola fila de sprites
     * @param horizontalCut
     * @param verticalCut
     * @param numElemEjeX
     */

    public TextureRegion[] cutAndSetRegion(int horizontalCut, int verticalCut, int numElemEjeX){
        TextureRegion[] aux = new TextureRegion[numElemEjeX];

        for(int i = 0; i < aux.length; i++){
            aux[i] = new TextureRegion(
                    this.getTexture(),
                    i*horizontalCut,
                    yJumps*verticalCut,
                    (i+1)*horizontalCut,
                    (yJumps+1)*verticalCut
            );
        }
//        TextureRegion tr = new TextureRegion(
//                this.getTexture(),
//                32,0,32,32
//        );
        return aux;
    }

    /**
     * No contempla array bidimensional dentado
     * @param horizontalCut
     * @param verticalCut
     * @param numElemEjeX
     * @param numElemEjeY
     */

    public TextureRegion[][] cutAndSetRegion(int horizontalCut, int verticalCut, int numElemEjeX, int numElemEjeY){
        TextureRegion[][] aux2 = new TextureRegion[numElemEjeX][numElemEjeY];

        for(int i = 0; i < numElemEjeY; i++){
            aux2[i] = cutAndSetRegion(horizontalCut,verticalCut,numElemEjeX);
            yJumps += verticalCut;
        }
        return aux2;
    }

    /**
     * *********************************************************************************************
     *      Input Listener
     * *********************************************************************************************
     */

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}