package com.ayoub.chess.board;

import com.ayoub.chess.Helpers.Helper;
import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.pieces.ChessPiece;

import java.util.*;

public class ChessBoard {

    public static Map<String,Move> printBoard(Move move,Move move2){
        int size = 8;
        String[][] chessboard = new String[size][size];
        Map<String,Move> pieceMap = new HashMap<>();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                    chessboard[row][col] =" { } " ;
            }
         }


        chessboard[0][0] = " {♜}"; // Rook
        pieceMap.put("rook_white", new Move(0,0));

        chessboard[0][1] = " {♞}"; // Knight
        pieceMap.put("Knight_white",new Move(0,1));

        chessboard[0][2] = " {♝}"; // Bishop
        pieceMap.put("Bishop_white",new Move(0,2));

        chessboard[0][3] = "  {♛}"; // Queen
        pieceMap.put("Queen_white",new Move(0,3));

        chessboard[0][4] = "  {♚}"; // King
        pieceMap.put("King_white",new Move(0,4));

        chessboard[0][5] = " {♝}"; // Bishop
        pieceMap.put("Bishop_2_white",new Move(0,5));

        chessboard[0][6] = " {♞}"; // Knight
        pieceMap.put("Knight_2_white",new Move(0,6));

        chessboard[0][7] = " {♜}"; // Rook
        pieceMap.put("Rook_2_white",new Move(0,8));


        chessboard[7][0] = " {♖}";
        pieceMap.put("Rook_black",new Move(7,0));

        chessboard[7][1] = " {♘}";
        pieceMap.put("knight_black",new Move(7,1));

        chessboard[7][2] = " {♗}";
        pieceMap.put("Bishop_black",new Move(7,2));

        chessboard[7][3] = "  {♕}";
        pieceMap.put("King_black",new Move(7,3));

        chessboard[7][4] = "  {♔}";
        pieceMap.put("queen_black",new Move(7,4));

        chessboard[7][5] = " {♗}";
        pieceMap.put("Bishop_2_black",new Move(7,5));

        chessboard[7][6] = " {♘}";
        pieceMap.put("knight_2_black",new Move(7,6));

        chessboard[7][7] = " {♖}";
        pieceMap.put("Rook_2_black",new Move(7,7));


        for (int i = 0; i < 3; i++) {
            chessboard[6][i] = " {♙}";
            pieceMap.put("Pawn_"+(i+1)+"_black",new Move(6,i));

            chessboard[1][i] = " {♟}";
            pieceMap.put("Pawn_"+(i+1)+"_white",new Move(1,i));

        }
        chessboard[6][3] = "  {♙}";
        pieceMap.put("Pawn_4_black",new Move(6,3));

        chessboard[1][3] = "  {♟}";
        pieceMap.put("Pawn_4_white",new Move(1,3));
        chessboard[6][4] = "  {♙}";
        pieceMap.put("Pawn_5_black",new Move(6,4));
        chessboard[1][4] = "  {♟}";
        pieceMap.put("Pawn_5_white",new Move(1,4));
        for (int i = 5; i < size; i++) {
            chessboard[6][i] = " {♙}";
            pieceMap.put("Pawn_"+(i+1)+"_black",new Move(6,i));
            chessboard[1][i] = " {♟}";
            pieceMap.put("Pawn_"+(i+1)+"_white",new Move(1,i));
        }

        if(move!=null&& move2!=null){
            String key=Helper.findKeyForMove(pieceMap,move);
           // Helper.getMoveVerification(move,key).forEach((pieceType, moves) -> System.out.println(moves));
            System.out.println(key);
            pieceMap.put(key,move2);
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
        return pieceMap;
    }


}

