package com.example.pingpong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Random;

import static com.example.pingpong.Ball.*;
import static com.example.pingpong.Enemy.drawEnemy;
import static com.example.pingpong.Enemy.enemyMove;
import static com.example.pingpong.KeyBinds.*;
import static com.example.pingpong.Player.drawPlayer;
import static com.example.pingpong.GameText.*;

public class Game {

    public static final int gap = 5;

    public static final double enemySpeed = 1;
    public static final int maxScore = 5;

    public static final String font = "Impact";
    public static final int fontSize = 30;
    public static final int bigFontSize = 65;

    public static int playerScore = 0;
    public static int enemyScore = 0;

    public static int hitCombo = 0;

    public static double ballSpeedX = 5;
    public static double ballSpeedY = 1;

    public static boolean menuStarted;
    public static boolean started;

    public static Random random;

    public static Rectangle player;
    public static Rectangle enemy;
    public static Circle ball;
    public static Rectangle middleLine;

    public static Text playerScoreText;
    public static Text enemyScoreText;
    public static Text startText;
    public static Text pauseText;
    public static Text winLoseText;
    public static Text spaceToPlayText;
    public static Text comboHitText;

    public static Group root;
    public static Scene gameWindow;

    public static Timeline gameLoop;

    public static void game(){

        gameWindow.setFill(Color.STEELBLUE);
        gameWindow.setCursor(Cursor.NONE);

        drawPlayer();
        drawEnemy();

        drawMiddleLine();
        drawBall();

        drawPlayerScore();
        drawEnemyScore();
        drawCombo();
        drawStartText();
        drawPauseText();
        drawWinLoseText();

        gameLoop = new Timeline(new KeyFrame(Duration.millis(3), arg -> {

            checkGameStart();
            checkBallPosition();
            ballSize();

            enemyMove();
            gameScore();

        }));

        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();

        root.getChildren().addAll(player, enemy, ball, middleLine, playerScoreText, enemyScoreText, startText, pauseText,
                winLoseText, comboHitText);
    }

    public static void startGame(){

        gameWindow.setFill(Color.ROYALBLUE);
        mouseMove();
        keyBindingPause();
        keyBindingQuitGame();

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

        hitCombo = 0;

        playerScoreText.setText("" + playerScore);
        enemyScoreText.setText("" + enemyScore);
        winLoseText.setX((gameWindow.getWidth() / 4) + 70);

        player.setX(gameWindow.getWidth() - player.getWidth() - gap);
        player.setY((gameWindow.getHeight() / 2) - (player.getHeight() / 2));

        enemy.setX((gameWindow.getWidth() - gameWindow.getWidth()) + gap);
        enemy.setY((gameWindow.getHeight() / 2) - (enemy.getHeight() / 2));

        ball.setRadius(10);

        gameLoop.pause();

    }
}
