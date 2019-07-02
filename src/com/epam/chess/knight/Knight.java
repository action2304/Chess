package com.epam.chess.knight;

import static com.epam.chess.knight.Board.BOARD_SIZE;
import static com.epam.chess.knight.Board.boardArray;

public class Knight {

    private int xCoor = 0;
    private int yCoor = 0;
    private int moveCount = 1;
    private int[] stepX = {2, 2, -2, -2, 1, -1, 1, -1};
    private int[] stepY = {1, -1, -1, 1, -2, -2, 2, 2};
    private int[] stepsCount = {8, 0, 0};

    public int checkKnightSteps(int coorX, int coorY) {

        int knightSteps = 0;

        for (int i = 0; i < 8; i++) {
            if (0 <= (coorX + stepX[i])
                    && (coorX + stepX[i]) < BOARD_SIZE
                    && 0 <= (coorY + stepY[i])
                    && (coorY + stepY[i]) < BOARD_SIZE
                    && boardArray[coorX + stepX[i]][coorY + stepY[i]] == 0) {
                knightSteps++;
            }
        }
        return knightSteps;
    }

    public void fillingTheBoard() {

        boardArray[xCoor][yCoor] = 1;
        for (moveCount = 2; moveCount < Math.pow(BOARD_SIZE, 2); moveCount++) {
            stepsCount[0] = 8;
            for (int i = 0; i < 8; i++) {
                if (0 <= (xCoor + stepX[i])
                        && (xCoor + stepX[i]) < BOARD_SIZE
                        && 0 <= (yCoor + stepY[i])
                        && (yCoor + stepY[i]) < BOARD_SIZE
                        && boardArray[xCoor + stepX[i]][yCoor + stepY[i]] == 0
                        && checkKnightSteps(xCoor + stepX[i], yCoor + stepY[i]) <= stepsCount[0]) {
                    stepsCount[0] = checkKnightSteps(xCoor + stepX[i], yCoor + stepY[i]);
                    stepsCount[1] = xCoor + stepX[i];
                    stepsCount[2] = yCoor + stepY[i];
                }
            }
            xCoor = stepsCount[1];
            yCoor = stepsCount[2];
            boardArray[xCoor][yCoor] = moveCount;
        }
    }

    public void printArray() {
        for (xCoor = 0; xCoor < BOARD_SIZE; xCoor++) {
            for (yCoor = 0; yCoor < BOARD_SIZE; yCoor++) {
                if (boardArray[xCoor][yCoor] == 0) {
                    System.out.print("   X");
                } else {
                    System.out.format("%4d", boardArray[xCoor][yCoor]);
                }
            }
            System.out.println();
        }
    }
}