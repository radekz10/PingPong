package com.example.pingpong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import static com.example.pingpong.Game.*;

public class Ball {

    public static void drawBall(){
        ball = new Circle();
        ball.setCenterX((gameWindow.getWidth() / 2) - 5);
        ball.setCenterY((gameWindow.getHeight() / 2));
        ball.setRadius(10);

        ball.setFill(Color.ORANGE);
    }

    public static void respawnBall(){
        ball.setCenterX((gameWindow.getWidth() / 2) - 5);
        ball.setCenterY((gameWindow.getHeight() / 2));
    }

    public static void checkBallPosition(){

        if (ball.getCenterX() < 0){
            playerScore++;
            playerScoreText.setText("Player Score : " + playerScore);
            respawnBall();
        }

        if (ball.getCenterX() > gameWindow.getWidth()){
            enemyScore++;
            enemyScoreText.setText("Enemy Score : " + enemyScore);
            respawnBall();
        }

        if(ball.getCenterX() >= gameWindow.getWidth() - player.getWidth() - gap){
            if(ball.getCenterY() >= player.getY() && ball.getCenterY() <= player.getY() + player.getHeight()){
                ballSpeedX = -ballSpeedX;
                ballSpeedY = +ballSpeedY;
            }
            /*if(ball.getCenterY() >= player.getY() + (player.getHeight() / 2) - 10 && ball.getCenterY() <= player.getY() + player.getHeight()/2 + 10){
                ballSpeedX = -ballSpeedX;
            }*/
        }

        if(ball.getCenterX() <= enemy.getWidth() + gap){
            if(ball.getCenterY() >= enemy.getY() && ball.getCenterY() <= enemy.getY() + enemy.getHeight()){
                ballSpeedX = -ballSpeedX;
                ballSpeedY = +ballSpeedY;
            }
        }

        if (ball.getCenterY() == gameWindow.getHeight() || ball.getCenterY() == 0) {
            ballSpeedY = -ballSpeedY;

        }
    }

    public static void drawMiddleLine(){
        middleLine = new Rectangle();
        middleLine.setHeight(gameWindow.getHeight());
        middleLine.setWidth(10);
        middleLine.setX((gameWindow.getWidth() / 2) - middleLine.getWidth());

        middleLine.setFill(Color.CYAN);
    }


}
