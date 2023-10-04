package com.ayoub.chess;

import com.ayoub.chess.board.ChessBoard;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.prints.PrintMessages;

import java.util.*;
import java.util.function.Consumer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static String key;
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();

        while (true) {
            chessBoard.updateBoard();
        }
    }
/*
    static void gg(){
        ChessBoard chessBoard=new ChessBoard();
        PrintMessages.printBoard(chessBoard.getChessboard());
        PrintMessages.getPositions().ifPresent(new Consumer<List<Move>>() {
            @Override
            public void accept(List<Move> moves) {
                chessBoard.updateBoard(moves.get(0),moves.get(1));

            }
        });


    }
*/

}