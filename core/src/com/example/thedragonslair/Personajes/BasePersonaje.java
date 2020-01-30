package com.example.thedragonslair.Personajes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class BasePersonaje extends Actor {

    protected Texture[] pnjTextureArr;
    protected int pnjTextureArrPosition;
    protected Texture pnjCurrentTexture;
    protected float pnjPosX, pnjPosY;
    protected int pnjTotalHP;
    protected int pnjCurrentHP;
    protected int pnjBaseHitDamage;
    protected Vector2 enemyVelocity;
    protected float enemySpeed;
    protected float enemyGravity;


    public BasePersonaje() {}

    /**
     *
     * @param delta sirve para que podamos actualizar el actor según el tiempo
*                   https://stackoverflow.com/questions/34479099/what-is-a-delta-time-in-libgdx
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

    public Texture[] getPnjTextureArr() {
        return pnjTextureArr;
    }

    public void setPnjTextureArr(Texture[] pnjTextureArr) {
        this.pnjTextureArr = pnjTextureArr;
    }

    public int getPnjTextureArrPosition() {
        return pnjTextureArrPosition;
    }

    public void setPnjTextureArrPosition(int pnjTextureArrPosition) {
        this.pnjTextureArrPosition = pnjTextureArrPosition;
    }

    public Texture getPnjCurrentTexture() {
        return pnjTextureArr[pnjTextureArrPosition];
    }

    public void setPnjCurrentTexture(Texture pnjCurrentTexture) {
        this.pnjCurrentTexture = pnjTextureArr[pnjTextureArrPosition];
    }

    public float getPnjPosX() {
        return pnjPosX;
    }

    public void setPnjPosX(float pnjPosX) {
        this.pnjPosX = pnjPosX;
    }

    public float getPnjPosY() {
        return pnjPosY;
    }

    public void setPnjPosY(float pnjPosY) {
        this.pnjPosY = pnjPosY;
    }

    public int getPnjTotalHP() {
        return pnjTotalHP;
    }

    public void setPnjTotalHP(int pnjTotalHP) {
        this.pnjTotalHP = pnjTotalHP;
    }

    public int getPnjCurrentHP() {
        return pnjCurrentHP;
    }

    public void setPnjCurrentHP(int pnjCurrentHP) {
        this.pnjCurrentHP = pnjCurrentHP;
    }

    public int getPnjBaseHitDamage() {
        return pnjBaseHitDamage;
    }

    public void setPnjBaseHitDamage(int pnjBaseHitDamage) {
        this.pnjBaseHitDamage = pnjBaseHitDamage;
    }

}