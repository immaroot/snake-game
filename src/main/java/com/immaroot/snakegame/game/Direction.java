package com.immaroot.snakegame.game;

public enum Direction {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private Direction opposite;
    private final int rowChange, colChange;

    Direction(int rowChange, int colChange) {
        this.rowChange = rowChange;
        this.colChange = colChange;
    }

    static {
        UP.opposite = DOWN;
        DOWN.opposite = UP;
        RIGHT.opposite = LEFT;
        LEFT.opposite = RIGHT;
    }

    public int getRowChange() {
        return rowChange;
    }

    public int getColChange() {
        return colChange;
    }

    Direction getOpposite() {
        return opposite;
    }
}
