package com.example.pingpong;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import static com.example.pingpong.Game.*;

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

    public static void keyBindingMenuSpace(){
        gameWindow.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE){
                menuStarted = true;
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
        });
    }

      /*public static void keyBindingW(){
      gameWindow.setOnKeyPressed(keyEvent -> {
          if (keyEvent.getCode() == KeyCode.W){
              player.setY(player.getY() - 30);
          }
      });
  }

  public static void keyBindingS(){
      gameWindow.setOnKeyPressed(keyEvent -> {
          if (keyEvent.getCode() == KeyCode.S){
              player.setY(player.getY() + 30);
          }
      });
  }*/


}

