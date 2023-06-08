package com.immaroot.snakegame.scenes;

import com.immaroot.snakegame.GameApplication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class GameOverScene extends Scene {

    public GameOverScene(GameApplication application, double width, double height, Paint fill) {
        super(new VBox(20), width, height, fill);

        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);
        root.setBackground(Background.fill(fill));

        Label gameOver = new Label();
        gameOver.setText("Game Over");
        gameOver.setTextFill(Color.WHITE);
        gameOver.setStyle("-fx-font-size: 4em;");

        Button gotToWelcomeButton = new Button();
        gotToWelcomeButton.setText("Go to Welcome");
        gotToWelcomeButton.setStyle("-fx-font-size: 2em; -fx-text-fill: white; -fx-background-color: #363636");

        gotToWelcomeButton.setOnAction(actionEvent -> {
            Stage primaryStage = application.getPrimaryStage();
            primaryStage.setScene(new WelcomeScene(application, application.getPrimaryStage().getWidth(), application.getPrimaryStage().getHeight(), Color.BLACK));
        });

        Button restartButton = new Button();
        restartButton.setText("Restart");
        restartButton.setStyle("-fx-font-size: 2em; -fx-text-fill: white; -fx-background-color: #363636");

        restartButton.setOnAction(actionEvent -> {
            Stage primaryStage = application.getPrimaryStage();
            primaryStage.setScene(new RunningScene(application, application.getPrimaryStage().getWidth(), application.getPrimaryStage().getHeight(), Color.BLACK));
        });

        root.getChildren().setAll(gameOver, gotToWelcomeButton, restartButton);
    }
}