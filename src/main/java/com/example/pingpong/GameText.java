package com.example.pingpong;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import static com.example.pingpong.Ball.hitCombo;
import static com.example.pingpong.Enemy.enemyScore;
import static com.example.pingpong.Game.*;
import static com.example.pingpong.Player.playerScore;

public class GameText {

    public static Text playerScoreText;
    public static Text enemyScoreText;
    public static Text bindsText;
    public static Text spaceText;
    public static Text pauseText;
    public static Text winLoseText;
    public static Text comboHitText;

    public static void drawPlayerScore(){
        playerScoreText = new Text();
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
        enemyScoreText.setText("" + enemyScore);
        enemyScoreText.setFont(Font.font(font, bigFontSize));
        enemyScoreText.setFill(Color.WHITE);
        enemyScoreText.setStroke(Color.CYAN);
        enemyScoreText.setStrokeWidth(2);
        enemyScoreText.setX((30));
        enemyScoreText.setY(70);
        enemyScoreText.setVisible(true);
    }

    public static void drawBindsText(){
        bindsText = new Text();
        bindsText.setText("P - PAUSE GAME | X - EXIT GAME");
        bindsText.setFont(Font.font(font, fontSize));
        bindsText.setFill(Color.ORANGE);
        bindsText.setStroke(Color.LIGHTCORAL);
        bindsText.setStrokeWidth(1);
        bindsText.setX((gameWindow.getWidth() / 2) - 195);
        bindsText.setY((gameWindow.getHeight() - 20));
        bindsText.setVisible(true);

    }

    public static void drawSpaceText(){
        spaceText = new Text();
        spaceText.setText("PRESS SPACE TO PLAY!");
        spaceText.setFont(Font.font(font, fontSize));
        spaceText.setFill(Color.ORANGE);
        spaceText.setStroke(Color.LIGHTCORAL);
        spaceText.setStrokeWidth(1);
        spaceText.setX((gameWindow.getWidth() / 3) + 100);
        spaceText.setY((30));
        spaceText.setVisible(true);

    }

    public static void drawPauseText(){
        pauseText = new Text();
        pauseText.setText("PAUSED");
        pauseText.setFont(Font.font(font, fontSize));
        pauseText.setFill(Color.ORANGE);
        pauseText.setStroke(Color.LIGHTCORAL);
        pauseText.setStrokeWidth(1);
        pauseText.setX((gameWindow.getWidth() / 2) - 50);
        pauseText.setY((gameWindow.getHeight() / 2));
        pauseText.setVisible(false);

    }

    public static void drawWinLoseText(){
        winLoseText = new Text();
        winLoseText.setFont(Font.font(font, fontSize));
        winLoseText.setFill(Color.ORANGE);
        winLoseText.setStroke(Color.LIGHTCORAL);
        winLoseText.setStrokeWidth(1);
        winLoseText.setX((gameWindow.getWidth() / 3) + 100);
        winLoseText.setY((gameWindow.getHeight() / 4));

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
        winLoseText.setX((gameWindow.getWidth() / 3) + 100);
        winLoseText.setY((gameWindow.getHeight() / 4));
        winLoseText.setVisible(true);
        bindsText.setVisible(true);
        spaceText.setVisible(true);
        resetGame();
    }

    public static void enemyWin(){

        winLoseText.setText("ENEMY IS THE WINNER!");
        winLoseText.setX((gameWindow.getWidth() / 3) + 100);
        winLoseText.setY((gameWindow.getHeight() / 4));
        winLoseText.setVisible(true);
        bindsText.setVisible(true);
        spaceText.setVisible(true);
        resetGame();

    }
}




