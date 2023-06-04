package com.immaroot.snakegame;

public class Game {

    private final Snake snake;
    private final Board board;
    private Direction direction;
    private boolean isGameOver;

    private int currentScore = 0;

    public Game(Snake snake, Board board) {
        this.snake = snake;
        this.board = board;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void update() {
        if (!isGameOver) {
            if (!isNextOppositeDirection() && !isNextOutOfBounds()) {
                snake.setDirection(direction);
                Cell nextCell = getNextCell();
                if (!isNextCollision(nextCell)) {
                    if (isNextFood(nextCell)) {
                        currentScore++;
                        snake.eat(nextCell);
                        board.generateFood();
                    } else {
                        snake.move(nextCell);
                    }
                } else {
                    isGameOver = true;
                }
            } else {
                isGameOver = true;
            }
        }
    }

    private static boolean isNextFood(Cell nextCell) {
        return nextCell.getCellType() == CellType.FOOD;
    }

    private boolean isNextCollision(Cell nextCell) {
        return snake.checkBodyCollision(nextCell);
    }

    private boolean isNextOppositeDirection() {
        return snake.isOppositeDirection(direction);
    }

    private boolean isNextOutOfBounds() {
        int row = snake.getHead().getRow() + snake.getDirection().getRowChange();
        int col = snake.getHead().getCol() + snake.getDirection().getColChange();
        return !(row < board.getRowCount() && row >= 0 && col < board.getColCount() && col >= 0);
    }

    private Cell getNextCell() {
        int row = snake.getHead().getRow() + snake.getDirection().getRowChange();
        int col = snake.getHead().getCol() + snake.getDirection().getColChange();
        return board.getCells()[row][col];
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setGameOver(boolean gameOver) {
        this.isGameOver = gameOver;
    }

    public Board getBoard() {
        return board;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isNotGameOver() {
        return !isGameOver;
    }
}
