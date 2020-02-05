package com.example.thedragonslair.Personajes.Enemigos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.example.thedragonslair.Personajes.BasePersonaje;

import static com.example.thedragonslair.util.CodeResources.DEFAULT_GRAVITY;
import static com.example.thedragonslair.util.CodeResources.DEFAULT_SPEED;

public class Enemy extends BasePersonaje {

    private int enemyValue;

    public Enemy(int enemyValue, Vector2 enemyVelocity,
                 float posX, float posY,
                 int pnjTotalHP, int pnjCurrentHP, int pnjBaseHitDamage,
                 Texture[] pnjTextureArr, int pnjTextureArrPosition) {

        this.enemyValue = enemyValue;

        enemySpeed = DEFAULT_SPEED;
        enemyGravity = DEFAULT_GRAVITY;
        enemyVelocity = enemyVelocity;

        pnjTextureArr = pnjTextureArr;
        pnjTextureArrPosition = pnjTextureArrPosition;
        pnjCurrentTexture = pnjTextureArr[pnjTextureArrPosition];

        pnjPosX = posX;
        pnjPosY = posY;

        pnjTotalHP = pnjTotalHP;
        pnjCurrentHP = pnjCurrentHP;

        pnjBaseHitDamage = pnjBaseHitDamage;
    }

    public Enemy(int enemyValue, Vector2 enemyVelocity,
                 float posX, float posY,
                 int pnjTotalHP, int pnjCurrentHP, int pnjBaseHitDamage,
                 Texture[] pnjTextureArr, int pnjTextureArrPosition,
                 float enemySpeed, float enemyGravity) {
        this(enemyValue,enemyVelocity, posX, posY, pnjTotalHP, pnjCurrentHP, pnjBaseHitDamage, pnjTextureArr, pnjTextureArrPosition);

        this.enemyVelocity = enemyVelocity;
        this.enemySpeed = enemySpeed;
        this.enemyGravity = enemyGravity;
    }

    public int getEnemyValue() {
        return enemyValue;
    }

    public void setEnemyValue(int enemyValue) {
        this.enemyValue = enemyValue;
    }

    public Vector2 getEnemyVelocity() {
        return enemyVelocity;
    }

    public void setEnemyVelocity(Vector2 enemyVelocity) {
        this.enemyVelocity = enemyVelocity;
    }

    public float getEnemySpeed() {
        return enemySpeed;
    }

    public void setEnemySpeed(float enemySpeed) {
        this.enemySpeed = enemySpeed;
    }

    public float getEnemyGravity() {
        return enemyGravity;
    }

    public void setEnemyGravity(float enemyGravity) {
        this.enemyGravity = enemyGravity;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}