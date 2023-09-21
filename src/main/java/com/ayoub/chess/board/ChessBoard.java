package com.ayoub.chess.board;

import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.pieces.ChessPiece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessBoard {

    public static void printBoard(){
        int size = 8;
        String[][] chessboard = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if ((row + col) % 2 == 0) {
                    chessboard[row][col] = " ■  "; // Print a white square
                } else {
                    chessboard[row][col] =" □  " ;// Print a black square
                }
            }
         }

        // Fill the chessboard with piece symbols
        chessboard[0][0] = " ♜ "; // Rook
        chessboard[0][1] = " ♞ "; // Knight
        chessboard[0][2] = " ♝ "; // Bishop
        chessboard[0][3] = "  ♛ "; // Queen
        chessboard[0][4] = "  ♚ "; // King
        chessboard[0][5] = " ♝ "; // Bishop
        chessboard[0][6] = " ♞ "; // Knight
        chessboard[0][7] = " ♜ "; // Rook


        chessboard[7][0] = " ♖ "; // Rook
        chessboard[7][1] = " ♘ "; // Knight
        chessboard[7][2] = " ♗ "; // Bishop
        chessboard[7][3] = "  ♕ "; // Queen
        chessboard[7][4] = " ♔ "; // King
        chessboard[7][5] = " ♗ "; // Bishop
        chessboard[7][6] = " ♘ "; // Knight
        chessboard[7][7] = "  ♖ "; // Rook

        for (int i = 0; i < 3; i++) {
            chessboard[6][i] = " ♙ "; // Pawn (white)
            chessboard[1][i] = " ♟ "; // Pawn (black)
        }
        chessboard[6][3] = "  ♙ "; // Pawn (white)
        chessboard[1][3] = "  ♟ "; // Pawn (black)
        chessboard[6][4] = "  ♙ "; // Pawn (white)
        chessboard[1][4] = "  ♟ "; // Pawn (black)
        for (int i = 5; i < size; i++) {
            chessboard[6][i] = " ♙ "; // Pawn (white)
            chessboard[1][i] = " ♟ "; // Pawn (black)
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

