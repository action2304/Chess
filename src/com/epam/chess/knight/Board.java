package com.epam.chess.knight;

public class Board {

    static final int BOARD_SIZE = 8;
    static final int[][] boardArray = new int[BOARD_SIZE][BOARD_SIZE];

    Knight knight = null;

    public void arrayFillWithZero() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                boardArray[i][j] = 0;
            }
        }
    }
}
