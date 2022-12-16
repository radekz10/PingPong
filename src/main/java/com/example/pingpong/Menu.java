package com.example.pingpong;

import javafx.scene.paint.Color;

import static com.example.pingpong.Game.*;
import static com.example.pingpong.GameText.drawSpaceToPlay;

public class Menu {

    public static void drawMenu(){
            if(menuStarted){
                game();
            }
            else {
                gameWindow.setFill(Color.STEELBLUE);

                drawSpaceToPlay();
                spaceToPlayText.setVisible(true);
                KeyBinds.keyBindingMenuSpace();
            }
    }
}
