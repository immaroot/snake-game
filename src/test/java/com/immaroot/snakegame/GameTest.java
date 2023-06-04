package com.immaroot.snakegame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Snake snake;
    Board board;
    Game game;

    @BeforeEach
    void setUp() {
        board = new Board(10, 10);
        snake = new Snake(board.getCells()[0][0]);
        game = new Game(snake, board);
    }

    @Test
    void getCurrentScore0() {
        assertEquals(0, game.getCurrentScore());
    }

    @Test
    void getCurrentScore1() {
        game.getBoard().getCells()[0][1].setCellType(CellType.FOOD);
        snake.setDirection(Direction.RIGHT);
        game.setDirection(Direction.RIGHT);
        game.update();
        assertEquals(1, game.getCurrentScore());
    }

    @Test
    void updateMove() {
        game.getBoard().getCells()[0][1].setCellType(CellType.EMPTY);
        snake.setDirection(Direction.RIGHT);
        game.setDirection(Direction.RIGHT);
        game.update();
        assertTrue(game.isNotGameOver());
    }

    @Test
    void updateMoveOpposite() {
        game.getBoard().getCells()[0][1].setCellType(CellType.EMPTY);
        snake.setDirection(Direction.RIGHT);
        game.setDirection(Direction.LEFT);
        game.update();
        assertFalse(game.isNotGameOver());
    }

    @Test
    void setGameOver() {
        game.setGameOver(true);
        assertFalse(game.isNotGameOver());
    }
}