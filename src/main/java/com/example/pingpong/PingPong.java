package com.example.pingpong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.pingpong.Game.*;

public class PingPong extends Application {

    @Override
    public void start(Stage stage){
        root = new Group();
        gameWindow = new Scene(root,1400,700);

        stage.setTitle("2D PingPong");
        stage.setScene(gameWindow);
        stage.setResizable(false);
        stage.show();

        game();
    }

    public static void main(String[] args) {
        launch();
    }
}
