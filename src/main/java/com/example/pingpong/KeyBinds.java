package com.example.pingpong;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import static com.example.pingpong.Game.*;
import static com.example.pingpong.GameText.pauseText;
import static com.example.pingpong.Player.player;
import static com.example.pingpong.Ball.middleLine;

public class KeyBinds{

  public static void mouseMove(){

      gameWindow.setOnMouseMoved(mouseEvent -> {
          player.setY(mouseEvent.getSceneY() - (player.getHeight() / 2));
      });
  }

    public static void keyBindingSpace(){
        gameWindow.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE){
                STARTED = true;
            }
        });
    }

    public static void keyBindingPause(){
        gameWindow.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.P){
                pauseText.setVisible(true);
                gameWindow.setFill(Color.STEELBLUE);
                middleLine.setOpacity(0.05);
                gameLoop.pause();
            }
            if (keyEvent.getCode() == KeyCode.SPACE){
                pauseText.setVisible(false);
                middleLine.setOpacity(1);
                gameLoop.play();
            }
            if (keyEvent.getCode() == KeyCode.X){
                System.exit(0);
            }
        });
    }
}

