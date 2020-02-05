package com.example.thedragonslair.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.thedragonslair.Personajes.Enemigos.Enemy;
import com.example.thedragonslair.PowerUps.PowerUpBase;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class CodeResources {

    private CodeResources() {}//no se instancia


    private static final Logger log = new Logger(CodeResources.class.getName(), Logger.DEBUG);

    public static final float LOW_SPEED = 1;
    public static final float DEFAULT_SPEED = 2;
    public static final float HIGH_SPEED = 4;

    public static final float DEFAULT_GRAVITY = 1;

    public static final int EASY_DUNGEON_LEVEL = 100;
    public static final int AVERAGE_DUNGEON_LEVEL = 250;
    public static final int HARD_DUNGEON_LEVEL = 500;

    public static final int EASY_DUNGEON_DIFFICULTY = 1;
    public static final int AVERAGE_DUNGEON_DIFFICULTY = 2;
    public static final int HARD_DUNGEON_DIFFICULTY = 3;

    public static final float EASY_MONSTER_VALUE = 10;
    public static final float SUB_MONSTER_VALUE = 20;
    public static final float STRONG_MONSTER_VALUE = 30;

    public static final Vector2 testVelVect2 = new Vector2(10, 0);

    public static final int DEFAULT_CELL_SIZE = 1; //world units

//    public static final Enemy EASY_ENEMY =
//            new Enemy(EASY_MONSTER_VALUE, testVelVect2, 0, 0, 2, 2, 1, , 0);
//    public static final Enemy SUB_ENEMY =
//            new Enemy(SUB_MONSTER_VALUE, testVelVect2, 0, 0, 5, 5, 2, , 0);
//    public static final Enemy STRONG_ENEMY =
//            new Enemy(STRONG_MONSTER_VALUE, testVelVect2, 0, 0, 8, 8, 4, , 0);

    /**
     * Este método determina qué monstruos aparecerán en la sala
     *
     * @param dungeonLevel      nivel total que tendrán que sumar entre todos los enemigos de la sala
     * @param dungeonDifficulty a más dificultad más montruos fuertes saldrán en la sala
     * @return arraylist de enemigos presentes en la sala
     */
    public static ArrayList<Enemy> generaEnemigos(int dungeonLevel, int dungeonDifficulty) {
        ArrayList<Enemy> enemigosNivel = new ArrayList<Enemy>();
        int easyPercent = 0;
        int subPercent = 0;
        int hardPercent = 0;
        int dungeonContent = 0;
        int rdm = (int) Math.random() * 100 + 1;

        switch (dungeonDifficulty) {
            case EASY_DUNGEON_DIFFICULTY:
                //porcentajes: 66, 21, 12
                easyPercent = 66;
                subPercent = 21;
                hardPercent = 12;
                break;
            case AVERAGE_DUNGEON_DIFFICULTY:
                //porcentajes: 50, 25, 25
                easyPercent = 50;
                subPercent = 25;
                hardPercent = 25;
                break;
            case HARD_DUNGEON_DIFFICULTY:
                //porcentajes: 30, 30, 40
                easyPercent = 30;
                subPercent = 30;
                hardPercent = 40;
                break;
            default:
                throw new InvalidParameterException();
        }

        do {
            dungeonContent = 0;

//            if (rdm <= easyPercent) {
//                enemigosNivel.add(EASY_ENEMY);
//            } else if (rdm <= subPercent) {
//                enemigosNivel.add(SUB_ENEMY);
//            } else {
//                enemigosNivel.add(STRONG_ENEMY);
//            }

            for (Enemy e : enemigosNivel) {
                dungeonContent += e.getEnemyValue();
            }
        } while (dungeonContent < dungeonLevel);

        return enemigosNivel;
    }


    public static ArrayList<PowerUpBase> generaPowerUps(int dungeonLevel, int dungeonDifficulty, int playerHealth) {
        ArrayList<PowerUpBase> powerUps = new ArrayList<PowerUpBase>();
        return powerUps;
    }

    //Utility para limpiar pantalla

    public static void clearScreen(Color color) {
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public static void clearScreen() {
        clearScreen(Color.BLACK);
    }

    //Utility para renderizar gradilla "psicológica"
    //Dibuja la grid de juego correspondiente al viewpoint dado

    public static void drawGrid(Viewport viewport, ShapeRenderer renderer) {
        drawGrid(viewport, renderer, DEFAULT_CELL_SIZE);
    }

    public static void drawGrid(Viewport viewport, ShapeRenderer renderer, int cellSize) {
        // validate parameters/arguments
        if (viewport == null) {
            throw new IllegalArgumentException("viewport param is required.");
        }

        if (renderer == null) {
            throw new IllegalArgumentException("renderer param is required.");
        }

        if (cellSize < DEFAULT_CELL_SIZE) {
            cellSize = DEFAULT_CELL_SIZE;
        }

        // copy old color from render
        Color oldColor = new Color(renderer.getColor());

        int worldWidth = (int) viewport.getWorldWidth();
        int worldHeight = (int) viewport.getWorldHeight();
        int doubleWorldWidth = worldWidth * 2;
        int doubleWorldHeight = worldHeight * 2;

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.WHITE);

        // draw vertical lines
        for (int x = -doubleWorldWidth; x < doubleWorldWidth; x += cellSize) {
            renderer.line(x, -doubleWorldHeight, x, doubleWorldHeight);
        }

        // draw horizontal lines
        for (int y = -doubleWorldHeight; y < doubleWorldHeight; y += cellSize) {
            renderer.line(-doubleWorldWidth, y, doubleWorldWidth, y);
        }

        // draw x-y axis lines
        renderer.setColor(Color.RED);
        renderer.line(0, -doubleWorldHeight, 0, doubleWorldHeight);
        renderer.line(-doubleWorldWidth, 0, doubleWorldWidth, 0);

        // draw world bounds
        renderer.setColor(Color.GREEN);
        renderer.line(0, worldHeight, worldWidth, worldHeight);
        renderer.line(worldWidth, 0, worldWidth, worldHeight);

        renderer.end();

        renderer.setColor(oldColor);
    }

    public static void debugPixelPerUnit(Viewport viewport) {
        if (viewport == null) {
            throw new IllegalArgumentException("viewport no puede ser null");
        }

        float screenWidth = viewport.getScreenWidth();
        float screenHeight = viewport.getScreenHeight();

        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        // PPU => pixels per world unit
        float xPPU = screenWidth / worldWidth;
        float yPPU = screenHeight / worldHeight;

        log.debug("x PPU= " + xPPU + " yPPU= " + yPPU);
    }

}