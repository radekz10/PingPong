package com.example.pingpong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static com.example.pingpong.Game.*;

public class Enemy {

    public static void drawEnemy(){
        enemy = new Rectangle();
        enemy.setHeight(130);
        enemy.setWidth(20);
        enemy.setX((gameWindow.getWidth() - gameWindow.getWidth()) + gap);
        enemy.setY((gameWindow.getHeight() / 2) - (enemy.getHeight() / 2));

        enemy.setFill(Color.WHITE);
    }

    public static void enemyMove(){

        if (enemy.getY() + 10< ball.getCenterY()) {
            enemy.setY(enemy.getY() + enemySpeed);
        }
        if (enemy.getY() + 10 > ball.getCenterY()) {
            enemy.setY(enemy.getY() - enemySpeed);
        }

    }
}
