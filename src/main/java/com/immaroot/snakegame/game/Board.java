package com.immaroot.snakegame.game;

import java.util.stream.IntStream;

public class Board {

    private final int ROW_COUNT, COL_COUNT;
    private final Cell[][] cells;

    public Board(int rows, int cols) {
        ROW_COUNT = rows;
        COL_COUNT = cols;
        cells = new Cell[rows][cols];
        IntStream.range(0, ROW_COUNT)
                .forEach(row ->
                        IntStream.range(0, COL_COUNT)
                                .forEach(col ->
                                        cells[row][col] = new Cell(row, col)));
    }

    public void generateFood() {
        int row, col;
        do {
            row = (int) (Math.random() * ROW_COUNT);
            col = (int) (Math.random() * COL_COUNT);
        } while (cells[row][col].getCellType() == CellType.SNAKE_NODE);
        cells[row][col].setCellType(CellType.FOOD);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getRowCount() {
        return ROW_COUNT;
    }

    public int getColCount() {
        return COL_COUNT;
    }

    //Provided for debug/testing purposes
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COL_COUNT; j++) {
                if (cells[i][j].getCellType() == CellType.EMPTY) {
                    sb.append("* ");
                } else if (cells[i][j].getCellType() == CellType.SNAKE_NODE) {
                    sb.append("X ");
                } else if (cells[i][j].getCellType() == CellType.FOOD) {
                    sb.append("O ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
