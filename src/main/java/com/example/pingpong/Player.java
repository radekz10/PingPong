package com.example.pingpong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static com.example.pingpong.PingPong.*;

public class Player {

    public static void drawPlayer(){

        player = new Rectangle();
        player.setHeight(130);
        player.setWidth(20);
        player.setX(gameWindow.getWidth() - player.getWidth() - gap);
        player.setY((gameWindow.getHeight() / 2) - (player.getHeight() / 2));

        player.setFill(Color.WHITE);
    }

}
