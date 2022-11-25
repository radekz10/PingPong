package com.example.pingpong;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class PingPong extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root,1400,700);

        scene.setFill(Color.ROYALBLUE);

        Rectangle player = new Rectangle();
        player.setHeight(200);
        player.setWidth(20);
        player.setX(scene.getWidth() - 25);
        player.setY((scene.getHeight() / 2) - (player.getHeight() / 2));
        player.setFill(Color.WHITE);

        Rectangle enemy = new Rectangle();
        enemy.setHeight(200);
        enemy.setWidth(20);
        enemy.setX((scene.getWidth() - scene.getWidth()) + 5);
        enemy.setY((scene.getHeight() / 2) - (enemy.getHeight() / 2));

        enemy.setFill(Color.WHITE);

        Circle ball = new Circle((scene.getWidth() / 2), (scene.getHeight() / 2), 10);
        ball.setFill(Color.WHITE);

        Text text = new Text();
        text.setText("Score : ");
        text.setFont(Font.font("Impact", 50));
        text.setFill(Color.WHITE);
        text.setX((scene.getWidth() / 2) - 80);
        text.setY(scene.getHeight() - scene.getHeight() + 50);
        text.setVisible(true);

        root.getChildren().addAll(player, enemy, ball, text);

        stage.setTitle("2D PingPong");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}