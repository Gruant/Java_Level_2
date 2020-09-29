package com.company;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Actions extends MouseAdapter {
    MainCircles gameController;

    public Actions(MainCircles gameController) {
        super();
        this.gameController = gameController;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        float x = e.getX();
        float y = e.getY();
        if (e.getButton() == MouseEvent.BUTTON1){
            addBall(gameController, x, y);
        }
    }

    private void addBall(MainCircles gameController, float x, float y) {
        Sprite[] sprites = new Sprite[gameController.sprites.length + 1];
        for (int i = 0; i < gameController.sprites.length; i++) {
            sprites[i] = gameController.sprites[i];
        }
        gameController.sprites = sprites;
        gameController.sprites[sprites.length - 1] = new Ball(x, y);
    }

}
