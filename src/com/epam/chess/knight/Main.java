package com.epam.chess.knight;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        Knight knight = new Knight();
        board.arrayFillWithZero();
        knight.fillingTheBoard();
        knight.printArray();
    }
}
