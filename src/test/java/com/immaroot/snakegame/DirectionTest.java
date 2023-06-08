package com.immaroot.snakegame;

import com.immaroot.snakegame.game.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void getRowChange() {
        assertEquals(0, Direction.RIGHT.getRowChange());
        assertEquals(0, Direction.LEFT.getRowChange());
        assertEquals(-1, Direction.UP.getRowChange());
        assertEquals(1, Direction.DOWN.getRowChange());
    }

    @Test
    void getColChange() {
        assertEquals(1, Direction.RIGHT.getColChange());
        assertEquals(-1, Direction.LEFT.getColChange());
        assertEquals(0, Direction.UP.getColChange());
        assertEquals(0, Direction.DOWN.getColChange());
    }
}