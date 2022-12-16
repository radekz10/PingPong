package com.example.pingpong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import static com.example.pingpong.Ball.*;
import static com.example.pingpong.Enemy.*;
import static com.example.pingpong.KeyBinds.*;
import static com.example.pingpong.GameText.*;
import static com.example.pingpong.Player.*;

public class Game {

    public static final int gap = 5;

    public static final int maxScore = 5;

    public static final String font = "Impact";
    public static final int fontSize = 30;
    public static final int bigFontSize = 65;

    public static boolean menuStarted;
    public static boolean started;

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
