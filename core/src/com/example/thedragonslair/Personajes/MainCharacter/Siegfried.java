package com.example.thedragonslair.Personajes.MainCharacter;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.thedragonslair.Personajes.BasePersonaje;

import javax.xml.bind.annotation.XmlType;

public class Siegfried extends BasePersonaje implements InputProcessor {

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
        this.siegfriedEstado = eEstado.CORRIENDO;
        this.setPosition(screenX,screenY);



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

    public enum eEstado{
        QUIETO,
        ATACANDO,
        CORRIENDO,
        MURIENDO
    }

//    private Texture[] siegfriedWalking;
//    private Texture[] siegfriedAttaking;
//    private Texture[] siegfriedDying;
    private eEstado siegfriedEstado;

    public Siegfried() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        switch (siegfriedEstado){
            case ATACANDO:
                //Cambia por frames atacando
//                pnjTextureArr;
                break;
            case MURIENDO:
                break;
            case QUIETO:
                break;
            case CORRIENDO:
            default:

                break;
        }
        batch.draw(pnjTextureArr[pnjTextureArrPosition],getX(),getY());
    }
}