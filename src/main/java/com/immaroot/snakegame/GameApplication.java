package com.immaroot.snakegame;

import com.immaroot.snakegame.scenes.WelcomeScene;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameApplication extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Snake");
        primaryStage.setResizable(true);
        primaryStage.setHeight(470);
        primaryStage.setWidth(400);
        primaryStage.show();
        primaryStage.setScene(new WelcomeScene(this, getPrimaryStage().getWidth(), getPrimaryStage().getHeight(), Color.BLACK));

    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }
}