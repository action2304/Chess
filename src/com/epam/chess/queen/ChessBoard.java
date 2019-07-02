package com.epam.chess.queen;

public class ChessBoard {

    private final int BOARD_SIZE = 8;
    private int[] queensLocation;
    private int combinationIndexNumber;

    public ChessBoard(int queensCount) {
        this.queensLocation = new int[queensCount];

        for (int i = 0; i < this.queensLocation.length; i++) {
            this.queensLocation[i] = 0;
        }
    }

    public boolean nextCombination() {
        combinationIndexNumber++;
        return moveQueen(BOARD_SIZE - 1);
    }

    public void printState() {
        for (int i = 0; i < queensLocation.length; i++) {
            int position = queensLocation[i];
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j == position){
                    System.out.print("X ");
                }else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public boolean moveQueen(int index) {

        if (queensLocation[index] < BOARD_SIZE - 1) {
            queensLocation[index]++;
            return true;
        }

        queensLocation[index] = 0;
        if (index == 0) {
            return false;
        } else {
            return moveQueen(index - 1);
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < queensLocation.length; i++) {
            for (int j = i + 1; j < queensLocation.length; j++) {
                if (queensLocation[i] == queensLocation[j]) {
                    return false;
                }
                if (Math.abs(i - j) == Math.abs(queensLocation[i] - queensLocation[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
