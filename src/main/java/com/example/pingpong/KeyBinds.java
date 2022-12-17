package com.example.pingpong;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import static com.example.pingpong.Game.*;
import static com.example.pingpong.GameText.pauseText;
import static com.example.pingpong.Player.player;

public class KeyBinds{

  public static void mouseMove(){

      gameWindow.setOnMouseMoved(mouseEvent -> {
          player.setY(mouseEvent.getSceneY() - (player.getHeight() / 2));
      });
  }

    public static void keyBindingSpace(){
        gameWindow.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE){
                started = true;
            }
        });
    }

    public static void keyBindingPause(){
        gameWindow.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.P){
                pauseText.setVisible(true);
                gameWindow.setFill(Color.STEELBLUE);
                gameLoop.pause();
            }
            if (keyEvent.getCode() == KeyCode.SPACE){
                pauseText.setVisible(false);
                gameLoop.play();
            }
            if (keyEvent.getCode() == KeyCode.X){
                System.exit(0);
            }
        });
    }
}

