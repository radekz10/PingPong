package com.example.pingpong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import static com.example.pingpong.Ball.*;
import static com.example.pingpong.Enemy.drawEnemy;
import static com.example.pingpong.Enemy.enemyMove;
import static com.example.pingpong.KeyBinds.*;
import static com.example.pingpong.Player.drawPlayer;
import static com.example.pingpong.GameText.*;

public class Game {

    public static int playerScore = 0;
    public static int enemyScore = 0;

    public static int gap = 5;

    public static double ballSpeedX = 5;
    public static double ballSpeedY = 1;

    public static double enemySpeed = 1;

    public static int maxScore = 5;

    //public static boolean gameLoop = true;
    public static boolean started;

    public static Rectangle player;
    public static Rectangle enemy;
    public static Circle ball;
    public static Rectangle middleLine;

    public static Text playerScoreText;
    public static Text enemyScoreText;
    public static Text startText;
    public static Text pauseText;
    public static Text winLoseText;

    public static Group root;
    public static Scene gameWindow;

    public static Timeline gameLoop;

    public static void game(){

        drawPlayer();
        drawEnemy();

        drawMiddleLine();
        drawBall();

        drawPlayerScore();
        drawEnemyScore();
        drawStartText();
        drawPauseText();
        drawWinLoseText();

        gameLoop = new Timeline(new KeyFrame(Duration.millis(3), arg -> {

            checkGameStart();
            checkBallPosition();

            enemyMove();
            gameScore();

        }));

        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();

        root.getChildren().addAll(player, enemy, ball, middleLine, playerScoreText, enemyScoreText, startText, pauseText,
                winLoseText);
    }

    public static void startGame(){

        mouseMove();
        keyBindingW();
        keyBindingS();
        keyBindingPause();

        startText.setVisible(false);
        winLoseText.setVisible(false);

        ball.setCenterX(ball.getCenterX() + ballSpeedX);
        ball.setCenterY(ball.getCenterY() + ballSpeedY);

    }

    public static void checkGameStart(){
            if(started){
            startGame();
        }
            else {
                KeyBinds.keyBindingSpace();
            }
    }

    public static void gameScore(){
        if(playerScore == maxScore || enemyScore == maxScore){
            if (playerScore == maxScore){
                playerWin();
            }
            if (enemyScore == maxScore){
                enemyWin();
            }
        }
    }

    public static void resetGame(){

        playerScore = 0;
        enemyScore = 0;
        playerScoreText.setText("Player Score : " + playerScore);
        enemyScoreText.setText("Enemy Score : " + enemyScore);
        gameLoop.pause();

    }

    public static void playerWin(){

        winLoseText.setText("YOU ARE THE WINNER!");
        winLoseText.setVisible(true);
        startText.setVisible(true);
        resetGame();
    }

    public static void enemyWin(){

        winLoseText.setText("ENEMY IS THE WINNER!");
        winLoseText.setVisible(true);
        startText.setVisible(true);
        resetGame();

    }
}
