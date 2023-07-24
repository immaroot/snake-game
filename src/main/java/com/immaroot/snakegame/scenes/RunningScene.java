package com.immaroot.snakegame.scenes;

import com.immaroot.snakegame.GameApplication;
import com.immaroot.snakegame.game.Board;
import com.immaroot.snakegame.game.Direction;
import com.immaroot.snakegame.game.Game;
import com.immaroot.snakegame.game.Snake;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class RunningScene extends Scene {

    final private int PANEL_SIZE = 20;

    public RunningScene(GameApplication application, double width, double height, Paint fill) {
        super(new VBox(), width, height, fill);

        VBox root = (VBox) getRoot();
        root.setAlignment(Pos.TOP_CENTER);
        root.setBackground(Background.fill(fill));

        //TODO implement high score feature
        Label highScore = new Label();
        highScore.setText("High Score: 4321");
        highScore.setStyle("-fx-text-fill: #ffffff; -fx-text-alignment: left");

        Pane space = new Pane();

        //TODO why set "1234" as current score?
        Label currentScore = new Label();
        currentScore.setText("1234");
        currentScore.setStyle("-fx-text-fill: #ffffff; -fx-text-alignment: right");


        HBox scoreHbox = new HBox();
        HBox.setHgrow(space, Priority.ALWAYS);
        HBox.setMargin(highScore, new Insets(10, 0, 10, 10));
        HBox.setMargin(currentScore, new Insets(10, 10, 10, 0));
        scoreHbox.setStyle("-fx-background-color: #343434");
        scoreHbox.setMaxHeight(40);
        scoreHbox.setMinHeight(40);
        scoreHbox.getChildren().addAll(highScore, space, currentScore);

        int ROW_COUNT = 20;
        int COL_COUNT = 20;
        Board board = new Board(ROW_COUNT, COL_COUNT);
        Snake snake = new Snake(board.getCells()[0][0]);
        Game game = new Game(snake, board);
        game.setGameOver(false);
        game.getBoard().generateFood();
        game.setDirection(Direction.RIGHT);

        setOnKeyPressed(keyEvent -> {
            String code = keyEvent.getCode().toString();
            game.setDirection(switch (code) {
                case "LEFT" -> Direction.LEFT;
                case "RIGHT" -> Direction.RIGHT;
                case "UP" -> Direction.UP;
                case "DOWN" -> Direction.DOWN;
                default -> game.getDirection();
            });
        });

        Pane gamePane = new Pane();
        gamePane.setMinHeight(ROW_COUNT * PANEL_SIZE);
        gamePane.setMinWidth(COL_COUNT * PANEL_SIZE);
        gamePane.setMaxHeight(ROW_COUNT * PANEL_SIZE);
        gamePane.setMaxWidth(COL_COUNT * PANEL_SIZE);
        gamePane.setBackground(Background.fill(Color.HOTPINK));
        gamePane.getChildren().setAll(renderShapes(board));


        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1), actionEvent -> {
            if (game.isNotGameOver()){
                game.update();
                gamePane.getChildren().setAll(renderShapes(board));
                currentScore.setText(String.valueOf(game.getCurrentScore()));
            } else {
                timeline.stop();
                Stage primaryStage = application.getPrimaryStage();
                primaryStage.setScene(new GameOverScene(application, application.getPrimaryStage().getWidth(), application.getPrimaryStage().getHeight(), Color.BLACK));
            }
        }));

        timeline.playFromStart();

        root.getChildren().setAll(scoreHbox,gamePane);
    }

    public ArrayList<Shape> renderShapes(Board board) {
        ArrayList<Shape> shapes = new ArrayList<>(board.getColCount() * board.getRowCount());
        IntStream.range(0, board.getRowCount())
                .forEach(row ->
                        IntStream.range(0, board.getColCount())
                                .forEach(col -> {
                                    switch (board.getCells()[row][col].getCellType()) {
                                        case FOOD -> {
                                            Circle food = new Circle(col * PANEL_SIZE + (float) PANEL_SIZE/2, row * PANEL_SIZE + (float) PANEL_SIZE/2, (float) PANEL_SIZE / 2);
                                            food.setFill(Color.RED);
                                            shapes.add(food);
                                        }
                                        case SNAKE_NODE -> {
                                            Rectangle snakeNode = new Rectangle(col * PANEL_SIZE, row * PANEL_SIZE, PANEL_SIZE, PANEL_SIZE);
                                            snakeNode.setFill(Color.WHITE);
                                            shapes.add(snakeNode);
                                        }
                                    }

                                }));
        return shapes;
    }
}