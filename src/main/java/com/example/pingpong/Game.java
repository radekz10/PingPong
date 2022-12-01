package com.example.pingpong;

import javafx.animation.Timeline;
import javafx.scene.paint.Color;

import static com.example.pingpong.PingPong.*;
import static com.example.pingpong.Texts.drawStartText;

public class Game {

    public static void startGame(){

        ball.setCenterX(ball.getCenterX() + ballSpeedX);
        ball.setCenterY(ball.getCenterY() + ballSpeedY);

    }

    public static void checkGameStart(){
            if(started){
            startGame();
        }
            else {
                drawStartText();
                KeyBinds.keyBindingSpace();
            }
    }

    public static void gameScore(){
        if(playerScore >= 10){
            win();
        }
        if (enemyScore >= 10){
            lose();
        }
    }

    public static void win(){
        enemyScoreText.setText("You are the winner!");
        enemyScoreText.setX(gameWindow.getWidth() / 2);
        enemyScoreText.setY(gameWindow.getHeight() / 2);
        playerScoreText.setVisible(false);


        started = false;
        checkGameStart();
    }

    public static void lose(){
        enemyScoreText.setText("Enemy is the winner!");
        enemyScoreText.setX(gameWindow.getWidth() / 2);
        enemyScoreText.setY(gameWindow.getHeight() / 2);


        started = false;
        checkGameStart();
    }
}
