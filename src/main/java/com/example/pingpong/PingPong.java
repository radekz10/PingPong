package com.example.pingpong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.example.pingpong.Enemy.enemyMove;
import static com.example.pingpong.Game.gameScore;
import static com.example.pingpong.Game.startGame;


public class PingPong extends Application {

    public static int playerScore = 0;
    public static int enemyScore = 0;

    public static int gap = 5;

    public static int ballSpeedX = 2;
    public static int ballSpeedY = 2;

    public static double enemySpeed = 1.5;

    //public static boolean gameLoop = true;
    public static boolean started;

    public static Rectangle player;
    public static Rectangle enemy;
    public static Circle ball;
    public static Rectangle middleLine;

    public static Text playerScoreText;
    public static Text enemyScoreText;
    public static Text startText;

    public static Group root;
    public static Scene gameWindow;

    public static Timeline gameLoop;


    @Override
    public void start(Stage stage){
        root = new Group();
        gameWindow = new Scene(root,1400,700);
        gameWindow.setFill(Color.ROYALBLUE);

        Player.drawPlayer();
        Enemy.drawEnemy();

        Ball.drawMiddleLine();
        Ball.drawBall();

        Texts.drawPlayerScore();
        Texts.drawEnemyScore();

        KeyBinds.mouseMove();
        KeyBinds.keyBindingW();
        KeyBinds.keyBindingS();
        //KeyBinds.keyBindingPause();


        gameLoop = new Timeline(new KeyFrame(Duration.millis(3), arg -> {

            Game.checkGameStart();

            Ball.checkBallPosition();
            enemyMove();
            //gameScore();

        }));

        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();

        root.getChildren().addAll(player, enemy, ball, middleLine, playerScoreText, enemyScoreText);

        stage.setTitle("2D PingPong");
        stage.setScene(gameWindow);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
