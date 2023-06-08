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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class WelcomeScene extends Scene {

    public WelcomeScene(GameApplication application, double width, double height, Paint fill) {
        super(new VBox(20), width, height, fill);

        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.CENTER);
        root.setBackground(Background.fill(fill));

        Label welcomeLabel = new Label();
        welcomeLabel.setText("Welcome to \nthe snake game!");
        welcomeLabel.setTextFill(Color.WHITE);
        welcomeLabel.setTextAlignment(TextAlignment.CENTER);
        welcomeLabel.setStyle("-fx-font-size: 4em;");

        Button startButton = new Button();
        startButton.setText("Start Game");
        startButton.setStyle("-fx-font-size: 2em; -fx-text-fill: white; -fx-background-color: #363636");

        startButton.setOnAction(actionEvent -> {
            Stage primaryStage = application.getPrimaryStage();
            primaryStage.setScene(new RunningScene(application, application.getPrimaryStage().getWidth(), application.getPrimaryStage().getHeight(), Color.BLACK));
        });

        root.getChildren().setAll(welcomeLabel, startButton);
    }
}
