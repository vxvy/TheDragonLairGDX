package com.example.thedragonslair.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.Viewport;

public class CeilingViewer {

    private static final Logger log = new Logger(CeilingViewer.class.getName(), Logger.DEBUG);

    public static void drawGrid(Viewport viewport, ShapeRenderer renderer) {
        drawGrid(viewport, renderer, CodeResources.DEFAULT_CELL_SIZE);
    }

    public static void drawGrid(Viewport viewport, ShapeRenderer renderer, int cellSize) {
        // validate parameters/arguments
        if (viewport == null) {
            throw new IllegalArgumentException("viewport param is required.");
        }

        if (renderer == null) {
            throw new IllegalArgumentException("renderer param is required.");
        }

        if (cellSize < CodeResources.DEFAULT_CELL_SIZE) {
            cellSize = CodeResources.DEFAULT_CELL_SIZE;
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

    /**
     * Indica cuántos píxels de la pantalla ocupa una World unit
     * @param viewport pantalla actual
     */

    public static void debugPixelPerUnit(Viewport viewport) {
        if (viewport == null) {
            throw new IllegalArgumentException("viewport no puede ser null");
        }

        float screenWidth = viewport.getScreenWidth();
//        GameConfig.PIXEL_WIDTH;
        float screenHeight = viewport.getScreenHeight();
//        GameConfig.PIXEL_HEIGHT;

        float worldWidth = viewport.getWorldWidth();
//        GameConfig.VISUAL_WORLD_WIDTH;
        float worldHeight = viewport.getWorldHeight();
//        GameConfig.VISUAL_WORLD_HEIGHT;

        // PPU => pixels per world unit
        float xPPU = screenWidth / worldWidth;

        float yPPU = screenHeight / worldHeight;

        log.debug("x PPU= " + xPPU + " yPPU= " + yPPU);
    }
}
