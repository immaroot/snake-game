package com.immaroot.snakegame;

import java.util.LinkedList;

public class Snake {

    private final LinkedList<Cell> snakeBody = new LinkedList<>();
    private Direction direction = Direction.RIGHT;

    public Snake(Cell initialCell) {
        initialCell.setCellType(CellType.SNAKE_NODE);
        snakeBody.addFirst(initialCell);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isOppositeDirection(Direction direction) {
        return this.direction.getOpposite() == direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void move(Cell nextCell) {
        nextCell.setCellType(CellType.SNAKE_NODE);
        snakeBody.addFirst(nextCell);
        Cell tail = snakeBody.removeLast();
        tail.setCellType(CellType.EMPTY);
    }

    public boolean checkBodyCollision(Cell nextCell) {
        return snakeBody.stream().anyMatch(cell -> nextCell == cell);
    }

    public Cell getHead() {
        return snakeBody.getFirst();
    }

    public void eat(Cell nextCell) {
        nextCell.setCellType(CellType.SNAKE_NODE);
        snakeBody.addFirst(nextCell);
    }
}
