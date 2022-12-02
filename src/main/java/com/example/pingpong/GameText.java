package com.example.pingpong;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import static com.example.pingpong.Game.*;

public class GameText {

    public static void drawPlayerScore(){
        playerScoreText = new Text();
        playerScoreText.setText("Player Score : " + playerScore);
        playerScoreText.setFont(Font.font("Impact", 30));
        playerScoreText.setFill(Color.WHITE);
        playerScoreText.setX((gameWindow.getWidth() - 220));
        playerScoreText.setY(gameWindow.getHeight() - gameWindow.getHeight() + 40);
        playerScoreText.setVisible(true);
    }

    public static void drawEnemyScore(){
        enemyScoreText = new Text();
        enemyScoreText.setText("Enemy Score : " + enemyScore);
        enemyScoreText.setFont(Font.font("Impact", 30));
        enemyScoreText.setFill(Color.WHITE);
        enemyScoreText.setX((30));
        enemyScoreText.setY(gameWindow.getHeight() - gameWindow.getHeight() + 40);
        enemyScoreText.setVisible(true);
    }

    public static void drawStartText(){
        startText = new Text();
        startText.setText("PRESS SPACE TO PLAY!");
        startText.setFont(Font.font("Impact", 30));
        startText.setFill(Color.ORANGE);
        startText.setX((gameWindow.getWidth() / 2) + 10);
        startText.setY((gameWindow.getHeight() - 20));
        startText.setVisible(true);

    }

    public static void drawPauseText(){
        pauseText = new Text();
        pauseText.setText("PAUSED");
        pauseText.setFont(Font.font("Impact", 30));
        pauseText.setFill(Color.ORANGE);
        pauseText.setX((gameWindow.getWidth() / 2) - 50);
        pauseText.setY(35);
        pauseText.setVisible(false);

    }

    public static void drawWinLoseText(){
        winLoseText = new Text();
        winLoseText.setFont(Font.font("Impact", 30));
        winLoseText.setFill(Color.ORANGE);
        winLoseText.setX((gameWindow.getWidth() / 4) + 70);
        winLoseText.setY((gameWindow.getHeight() - 20));

    }

}




