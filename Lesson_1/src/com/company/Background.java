package com.company;

import java.awt.*;

public class Background {
    private static int r = 0;
    private static int g = 0;
    private static int b = 0;
    private float deltaTime;

    Background(GameCanvas canvas, float deltaTime){
        canvas.setBackground(backgroundColor());
        this.deltaTime = deltaTime;
    }

    private Color backgroundColor() {
        if (r < 255) {
           r++;
           g++;
           b++;
        }
        try {
            Thread.sleep(((int)deltaTime + 16) * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Color(r, g, b);
    }




}
