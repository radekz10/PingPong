package com.example.pingpong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;


public class PingPong extends Application {

    public static int player_score = 0;
    public static int enemy_score = 0;

    public static int gap = 5;

    public static int speedX = 2;
    public static int speedY = 1;

    public static boolean gameLoop = true;

    public static Rectangle player;
    public static Rectangle enemy;
    public static Circle ball;

    public static Text text;
    public static Text text2;

    public static Group root;
    public static Scene scene;


    @Override
    public void start(Stage stage) throws IOException {
        root = new Group();
        scene = new Scene(root,1400,700);

        scene.setFill(Color.ROYALBLUE);

        player = new Rectangle();
        player.setHeight(200);
        player.setWidth(20);
        player.setX(scene.getWidth() - player.getWidth() - gap);
        player.setY((scene.getHeight() / 2) - (player.getHeight() / 2));

        player.setFill(Color.WHITE);


        enemy = new Rectangle();
        enemy.setHeight(200);
        enemy.setWidth(20);
        enemy.setX((scene.getWidth() - scene.getWidth()) + gap);
        enemy.setY((scene.getHeight() / 2) - (enemy.getHeight() / 2));

        enemy.setFill(Color.WHITE);


        ball = new Circle();
        ball.setCenterX((scene.getWidth() / 2));
        ball.setCenterY((scene.getHeight() / 2));
        ball.setRadius(10);

        ball.setFill(Color.WHITE);


        text = new Text();
        text.setText("Player Score : " + player_score);
        text.setFont(Font.font("Impact", 30));
        text.setFill(Color.WHITE);
        text.setX((scene.getWidth() - 200));
        text.setY(scene.getHeight() - scene.getHeight() + 40);
        text.setVisible(true);

        text2 = new Text();
        text2.setText("Enemy Score : " + enemy_score);
        text2.setFont(Font.font("Impact", 30));
        text2.setFill(Color.WHITE);
        text2.setX((10));
        text2.setY(scene.getHeight() - scene.getHeight() + 40);
        text2.setVisible(true);


        scene.setOnMouseMoved(mouseEvent -> {
            player.setY(mouseEvent.getSceneY() - (player.getHeight() / 2));
        });

        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.W){
                player.setY(player.getY() - 30);
            }
        });

        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.S){
                player.setY(player.getY() + 30);
            }
        });



        Timeline gameLoop = new Timeline(new KeyFrame(Duration.millis(3), arg -> {

            ball.setCenterX(ball.getCenterX() + speedX);

            //ball.setCenterX(ball.getCenterX() + speedX);
            //ball.setCenterY(ball.getCenterY() + speedY);

            if (ball.getCenterX() < 0){
                player_score++;
                text.setText("Player Score : " + player_score);
                respawnBall();
            }

            if (ball.getCenterX() > scene.getWidth()){
                enemy_score++;
                text2.setText("Enemy Score : " + enemy_score);
                respawnBall();
            }

            if(ball.getCenterX() >= scene.getWidth() - player.getWidth() - gap){
                if(ball.getCenterY() >= player.getY() && ball.getCenterY() <= player.getY() + player.getHeight()){
                    speedX = - speedX;
                }
            }

            if(ball.getCenterX() <= enemy.getWidth() + gap){
                if(ball.getCenterY() >= enemy.getY() && ball.getCenterY() <= enemy.getY() + enemy.getHeight()){
                    speedX = - speedX;
                }
            }

        }));

        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();


        root.getChildren().addAll(player, enemy, ball, text, text2);

        stage.setTitle("2D PingPong");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void respawnBall(){
        ball.setCenterX((scene.getWidth() / 2));
        ball.setCenterY((scene.getHeight() / 2));
    }

    public static void win(){

    }

    public static void lose(){

    }


    public static void main(String[] args) {
        launch();
    }
}
