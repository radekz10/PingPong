package com.example.pingpong;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import static com.example.pingpong.Game.*;

public class GameText {

    public static void drawPlayerScore(){
        playerScoreText = new Text();
        //playerScoreText.setText("Player Score : " + playerScore);
        playerScoreText.setText("" + playerScore);
        playerScoreText.setFont(Font.font(font, bigFontSize));
        playerScoreText.setFill(Color.WHITE);
        playerScoreText.setStroke(Color.CYAN);
        playerScoreText.setStrokeWidth(2);
        playerScoreText.setX((gameWindow.getWidth() - 65));
        playerScoreText.setY(70);
        playerScoreText.setVisible(true);
    }

    public static void drawEnemyScore(){
        enemyScoreText = new Text();
        //enemyScoreText.setText("Enemy Score : " + enemyScore);
        enemyScoreText.setText("" + enemyScore);
        enemyScoreText.setFont(Font.font(font, bigFontSize));
        enemyScoreText.setFill(Color.WHITE);
        enemyScoreText.setStroke(Color.CYAN);
        enemyScoreText.setStrokeWidth(2);
        enemyScoreText.setX((30));
        enemyScoreText.setY(70);
        enemyScoreText.setVisible(true);
    }

    public static void drawStartText(){
        startText = new Text();
        startText.setText("P - PAUSE GAME | PRESS SPACE TO PLAY! ");
        startText.setFont(Font.font(font, fontSize));
        startText.setFill(Color.ORANGE);
        startText.setStroke(Color.LIGHTCORAL);
        startText.setStrokeWidth(1);
        startText.setX((gameWindow.getWidth() / 2) - 195);
        startText.setY((gameWindow.getHeight() - 20));
        startText.setVisible(true);

    }

    public static void drawPauseText(){
        pauseText = new Text();
        pauseText.setText("PAUSED");
        pauseText.setFont(Font.font(font, fontSize));
        pauseText.setFill(Color.ORANGE);
        pauseText.setStroke(Color.LIGHTCORAL);
        pauseText.setStrokeWidth(1);
        pauseText.setX((gameWindow.getWidth() / 2) + 5);
        pauseText.setY(30);
        pauseText.setVisible(false);

    }

    public static void drawWinLoseText(){
        winLoseText = new Text();
        winLoseText.setFont(Font.font(font, fontSize));
        winLoseText.setFill(Color.ORANGE);
        winLoseText.setStroke(Color.LIGHTCORAL);
        winLoseText.setStrokeWidth(1);
        winLoseText.setX((gameWindow.getWidth() / 4) + 70);
        winLoseText.setY((30));

    }

    public static void drawSpaceToPlay(){
        spaceToPlayText = new Text();
        spaceToPlayText.setText("PRESS SPACE TO PLAY!");
        spaceToPlayText.setFont(Font.font(font, bigFontSize));
        spaceToPlayText.setFill(Color.ORANGE);
        spaceToPlayText.setStroke(Color.LIGHTCORAL);
        spaceToPlayText.setStrokeWidth(1);
        spaceToPlayText.setX(gameWindow.getWidth() / 2);
        spaceToPlayText.setY(gameWindow.getHeight() / 2);
        spaceToPlayText.setVisible(true);

    }

    public static void drawCombo(){
        comboHitText = new Text();
        comboHitText.setText("x" + hitCombo);
        comboHitText.setFont(Font.font(font, fontSize));
        comboHitText.setFill(Color.CYAN);
        comboHitText.setStroke(Color.ANTIQUEWHITE);
        comboHitText.setStrokeWidth(1);
        comboHitText.setX(gameWindow.getWidth() - 50);
        comboHitText.setY(gameWindow.getHeight() - 2);
        comboHitText.setVisible(true);

    }

    public static void playerWin(){

        winLoseText.setText("YOU ARE THE WINNER!");
        winLoseText.setX((gameWindow.getWidth() / 2) + 5);
        winLoseText.setVisible(true);
        startText.setVisible(true);
        resetGame();
    }

    public static void enemyWin(){

        winLoseText.setText("ENEMY IS THE WINNER!");
        winLoseText.setX((gameWindow.getWidth() / 4) + 70);
        winLoseText.setVisible(true);
        startText.setVisible(true);
        resetGame();

    }

}




