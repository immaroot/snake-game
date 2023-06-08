package com.immaroot.snakegame;

import com.immaroot.snakegame.game.Cell;
import com.immaroot.snakegame.game.CellType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell(1, 1);
    }

    @Test
    void getCellType() {
        assertEquals(CellType.EMPTY, cell.getCellType());
    }

    @Test
    void setCellType() {
        cell.setCellType(CellType.SNAKE_NODE);
        assertEquals(CellType.SNAKE_NODE, cell.getCellType());
    }

    @Test
    void getRow() {
        assertEquals(1, cell.getRow());
    }

    @Test
    void getCol() {
        assertEquals(1, cell.getCol());
    }
}