package com.immaroot.snakegame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SnakeTest {

    Snake snake;
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board(10, 10);
        snake = new Snake(board.getCells()[0][0]);
    }

    @Test
    void move() {
        Cell currentCell = snake.getHead();
        Cell nextCell = board.getCells()[0][1];
        snake.move(nextCell);
        assertEquals(CellType.SNAKE_NODE, nextCell.getCellType());
        assertEquals(CellType.EMPTY, currentCell.getCellType());
    }

    @Test
    void checkBodyCollisionTrue() {
        Cell nextCell = board.getCells()[0][0];
        boolean isCollision = snake.checkBodyCollision(nextCell);
        assertTrue(isCollision);
    }

    @Test
    void checkBodyCollisionFalse() {
        Cell nextCell = board.getCells()[0][1];
        boolean isCollision = snake.checkBodyCollision(nextCell);
        assertFalse(isCollision);
    }

    @Test
    void getHead() {
        Cell head = board.getCells()[0][0];
        assertEquals(head, snake.getHead());
    }

    @Test
    void eat() {
        Cell currentCell = snake.getHead();
        Cell nextCell = board.getCells()[0][1];
        nextCell.setCellType(CellType.FOOD);
        snake.eat(nextCell);
        assertEquals(CellType.SNAKE_NODE, nextCell.getCellType());
        assertEquals(CellType.SNAKE_NODE, currentCell.getCellType());
    }

    @Test
    void getDirection() {
        assertEquals(Direction.RIGHT, snake.getDirection());
    }

    @Test
    void snakeOppositeDirection() {
        snake.setDirection(Direction.LEFT);
        assertFalse(snake.isOppositeDirection(Direction.UP));
        assertTrue(snake.isOppositeDirection(Direction.RIGHT));
    }
}