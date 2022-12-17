package com.example.pingpong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Random;

import static com.example.pingpong.Enemy.enemy;
import static com.example.pingpong.Enemy.enemyScore;
import static com.example.pingpong.Game.*;
import static com.example.pingpong.GameText.*;
import static com.example.pingpong.Player.player;
import static com.example.pingpong.Player.playerScore;

public class Ball {

    public static Circle ball;
    public static Rectangle middleLine;

    public static Random random;

    public static double ballSpeedX = 5;
    public static double ballSpeedY = 1;

    public static int hitCombo = 0;

    public static void drawBall(){
        ball = new Circle();
        ball.setCenterX((gameWindow.getWidth() / 2) - 5);
        ball.setCenterY((gameWindow.getHeight() / 2));
        ball.setRadius(10);
        ball.setStroke(Color.LIGHTCORAL);
        ball.setStrokeWidth(1);
        //ball.setOpacity(0.7);

        ball.setFill(Color.ORANGE);
    }

    public static void respawnBall(){

        ball.setRadius(10);
        ball.setCenterX((gameWindow.getWidth() / 2) - 5);
        ball.setCenterY((gameWindow.getHeight() / 2));

        hitCombo = 0;
        comboHitText.setText("x" + hitCombo);

        random = new Random();
        int random_num = random.nextInt(100);

        System.out.println(random_num);

        if (random_num <= 25){
            ballSpeedX = 3;
            ballSpeedY = 1;
        }
        if (random_num > 25 && random_num <= 50){
            ballSpeedX = 3;
            ballSpeedY = -0.75;
        }
        if (random_num > 51 && random_num <= 75){
            ballSpeedX = 3;
            ballSpeedY = 0.6;
        }
        if (random_num > 76){
            ballSpeedX = 3;
            ballSpeedY = -0.6;
        }
    }

    public static void checkBallPosition(){

        //score
        if (ball.getCenterX() < 0){
            playerScore++;
            playerScoreText.setText("" + playerScore);
            respawnBall();
        }

        if (ball.getCenterX() > gameWindow.getWidth()){
            enemyScore++;
            enemyScoreText.setText("" + enemyScore);
            respawnBall();
        }

        //player hit
        //if (player.intersects(ball.getBoundsInLocal()))
        if(ball.getCenterX() >= gameWindow.getWidth() - player.getWidth() - gap){

            if(ball.getCenterY() >= player.getY() && ball.getCenterY() <= player.getY() + player.getHeight()){
                ballSpeedX = -ballSpeedX;
                hitCombo++;
                comboHitText.setText("x" + hitCombo);
            }
            if(ball.getCenterY() >= player.getY() + (player.getHeight() / 2) - 15 && ball.getCenterY() <= player.getY() + player.getHeight()/2 + 15){
                ballSpeedX = ballSpeedX - 1.3;
            }
            if(ball.getCenterY() >= player.getY() && ball.getCenterY() <= player.getHeight() / 2){
                ballSpeedY = ballSpeedY + 1;
            }
            if(ball.getCenterY() >= player.getHeight() / 2 && ball.getCenterY() <= player.getHeight()){
                ballSpeedY = ballSpeedY - 1;
            }
        }

        //enemy hit
        //if (enemy.intersects(ball.getBoundsInLocal()))
        if(ball.getCenterX() <= enemy.getWidth() + gap) {

            if (ball.getCenterY() >= enemy.getY() && ball.getCenterY() <= enemy.getY() + player.getHeight()) {
                ballSpeedX = -ballSpeedX;
                hitCombo++;
                comboHitText.setText("x" + hitCombo);
            }
            if (ball.getCenterY() >= enemy.getY() + (enemy.getHeight() / 2) - 15 && ball.getCenterY() <= enemy.getY() + enemy.getHeight() / 2 + 15) {
                ballSpeedX = ballSpeedX - 1.3;
            }
            if(ball.getCenterY() >= enemy.getY() && ball.getCenterY() <= enemy.getHeight() / 2){
                ballSpeedY = ballSpeedY + 1;
            }
            if(ball.getCenterY() >= enemy.getHeight() / 2 && ball.getCenterY() <= enemy.getHeight()){
                ballSpeedY = ballSpeedY - 1;
            }
        }

        //ground hit
        if (ball.getCenterY() >= gameWindow.getHeight() || ball.getCenterY() <= 0) {
            ballSpeedY = -ballSpeedY;
        }
    }

    public static void ballSize(){

        System.out.println(hitCombo);

        if(hitCombo % 5 == 0){
            ball.setRadius(20);
        }
        else if(hitCombo % 2 == 0){
            ball.setRadius(5);
        }
        else {
            ball.setRadius(10);
        }

    }

    public static void drawMiddleLine(){
        middleLine = new Rectangle();
        middleLine.setHeight(gameWindow.getHeight());
        middleLine.setWidth(10);
        middleLine.setX((gameWindow.getWidth() / 2) - middleLine.getWidth());
        middleLine.setStroke(Color.WHITE);
        middleLine.setStrokeWidth(2);

        middleLine.setFill(Color.CYAN);
    }
}
