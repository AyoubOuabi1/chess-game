package com.ayoub.chess;

import com.ayoub.chess.board.ChessBoard;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.prints.PrintMessages;

import java.util.*;
import java.util.function.Consumer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
     public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        while (true) {
            chessBoard.updateBoard();
        }
    }
}