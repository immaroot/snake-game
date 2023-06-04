package com.immaroot.snakegame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board;

    @BeforeEach
    void setUp() {
        board = new Board(10, 10);
    }

    @Test
    void generateFood() {
        board.generateFood();
        Cell[][] boardCells = board.getCells();
        assertTrue(Stream.of(boardCells)
                .flatMap(Stream::of)
                .anyMatch(cell -> cell.getCellType() == CellType.FOOD));
    }

    @Test
    void getCells() {
        assertEquals(10, board.getCells().length);
        assertEquals(10, board.getCells()[0].length);
    }

    @Test
    void getRowCount() {
        assertEquals(10, board.getRowCount());
    }

    @Test
    void getColCount() {
        assertEquals(10, board.getColCount());
    }

    @Test
    void toStringTest() {
        System.out.println(board);
    }
}