package com.ayoub.chess.board;

import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.pieces.ChessPiece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessBoard {

    public static void printBoard(Move move,Move move2){
        int size = 8;
        String[][] chessboard = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                    chessboard[row][col] =" { } " ;
            }
         }

        chessboard[0][0] = " {♜}"; // Rook
        chessboard[0][1] = " {♞}"; // Knight
        chessboard[0][2] = " {♝}"; // Bishop
        chessboard[0][3] = "  {♛}"; // Queen
        chessboard[0][4] = "  {♚}"; // King
        chessboard[0][5] = " {♝}"; // Bishop
        chessboard[0][6] = " {♞}"; // Knight
        chessboard[0][7] = " {♜}"; // Rook


        chessboard[7][0] = " {♖}";
        chessboard[7][1] = " {♘}";
        chessboard[7][2] = " {♗}";
        chessboard[7][3] = "  {♕}";
        chessboard[7][4] = " {♔}";
        chessboard[7][5] = " {♗}";
        chessboard[7][6] = "  {♘}";
        chessboard[7][7] = "  {♖}";

        for (int i = 0; i < 3; i++) {
            chessboard[6][i] = " {♙}";
            chessboard[1][i] = " {♟}";
        }
        chessboard[6][3] = "  {♙}";
        chessboard[1][3] = "  {♟}";
        chessboard[6][4] = "  {♙}";
        chessboard[1][4] = "  {♟}";
        for (int i = 5; i < size; i++) {
            chessboard[6][i] = " {♙}";
            chessboard[1][i] = " {♟}";
        }
        if(move!=null){
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (move.getFromRow() == i && move.getFromCol() == j) {
                        String oldValue = chessboard[i][j];
                        chessboard[i][j] = " { } ";
                        chessboard[move2.getFromRow()][move2.getFromCol()]=oldValue;
                    }
                }
            }
        }
        // Print the chessboard
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(chessboard[i][j] );
            }
            System.out.println(); // Move to the next row
        }

    }
}

