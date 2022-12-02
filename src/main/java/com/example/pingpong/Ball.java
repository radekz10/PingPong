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

        ballSpeedX = 3;
        ballSpeedY = 1;

    }

    public static void checkBallPosition(){

        //score
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

        //player hit
        if(ball.getCenterX() >= gameWindow.getWidth() - player.getWidth() - gap){
            if(ball.getCenterY() >= player.getY() && ball.getCenterY() <= player.getY() + player.getHeight()){

                ballSpeedX = -ballSpeedX;


                if(ball.getCenterY() >= player.getY() + (player.getHeight() / 2) - 15 && ball.getCenterY() <= player.getY() + player.getHeight()/2 + 15){
                    ballSpeedX = -ballSpeedX - 2;
            }
                if(ball.getCenterY() >= player.getY() && ball.getCenterY() <= player.getHeight() / 2){
                    ballSpeedY = -ballSpeedY - 1;
                }
                if(ball.getCenterY() >= player.getHeight() / 2 && ball.getCenterY() <= player.getHeight()){
                    ballSpeedY = ballSpeedY + 1;
                }
            }
        }
        //enemy hit
        if(ball.getCenterX() <= enemy.getWidth() + gap) {
            if (ball.getCenterY() >= enemy.getY() && ball.getCenterY() <= enemy.getY() + player.getHeight()) {

                ballSpeedX = -ballSpeedX;


                if (ball.getCenterY() >= enemy.getY() + (enemy.getHeight() / 2) - 15 && ball.getCenterY() <= enemy.getY() + enemy.getHeight() / 2 + 15) {
                    ballSpeedX = -ballSpeedX - 2;
                }
                if(ball.getCenterY() >= enemy.getY() && ball.getCenterY() <= enemy.getHeight() / 2){
                    ballSpeedY = -ballSpeedY - 1;
                }
                if(ball.getCenterY() >= enemy.getHeight() / 2 && ball.getCenterY() <= enemy.getHeight()){
                    ballSpeedY = ballSpeedY + 1;
                }
            }
        }

        //ground hit
        if (ball.getCenterY() >= gameWindow.getHeight() || ball.getCenterY() == 0) {
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
