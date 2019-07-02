package com.epam.chess.queen;

public class Main {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(8);
        int counter = 0;
        do {
            if (chessBoard.isEmpty()) {
                counter ++;
                chessBoard.printState();
                System.out.println("_______________");
            }
        } while (chessBoard.nextCombination());

        System.out.println("Total combinations: " + counter);
    }
}
