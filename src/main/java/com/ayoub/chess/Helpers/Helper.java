package com.ayoub.chess.Helpers;

import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.pieces.ChessPiece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Helper {
    public static String findKeyForMove(Map<String, Move> pieceMap, Move targetMove) {
        for (Map.Entry<String, Move> entry : pieceMap.entrySet()) {
            if (entry.getValue().getFromRow() == targetMove.getFromRow() && entry.getValue().getFromCol() == targetMove.getFromCol()) {
                return entry.getKey();
            }
        }
        return null;
    }
    public static Map<PieceType, List<Move>>  getMoveAfterVerification(Move move, String piece){
       return removeInvalidMoves(getMoveByName(move, piece));
        //return getMoveByName(move, piece);
    }

    public static Map<PieceType, List<Move>> getMoveByName(Move move, String piece) {
        if(piece.regionMatches(true,0,PieceType.ROOK.name(),0,4)){
            return ChessPiece.getRookMoves(new Move(move.getFromRow(), move.getFromCol()));
        }else if(piece.regionMatches(true,0,PieceType.KNIGHT.name(),0,6)){
            return ChessPiece.getKnightMoves(new Move(move.getFromRow(), move.getFromCol()));
        } else if (piece.regionMatches(true,0,PieceType.KING.name(),0,4)) {
            return ChessPiece.getKingMoves(new Move(move.getFromRow(), move.getFromCol()));
        } else if (piece.regionMatches(true,0,PieceType.QUEEN.name(),0,5)) {
            return ChessPiece.getQueenMoves(new Move(move.getFromRow(), move.getFromCol()));
        }else if (piece.regionMatches(true,0,PieceType.BISHOP.name(),0,6)) {
            return ChessPiece.getBishopMoves(new Move(move.getFromRow(), move.getFromCol()));
        }else if (piece.regionMatches(true,0,PieceType.PAWN.name(),0,4)) {
            return ChessPiece.getPawnMoves(new Move(move.getFromRow(), move.getFromCol()));
        }
        return null;
    }
    public static Map<PieceType, List<Move>> removeInvalidMoves(Map<PieceType, List<Move>> pieceMap) {
        Map<PieceType, List<Move>> newPieceMap = new HashMap<>();

        pieceMap.forEach((pieceType, moves) -> {
            List<Move> validMoves = new ArrayList<>();

            moves.forEach(move -> {
                if (isValidMove(move)) {
                    validMoves.add(move);
                }
            });

            newPieceMap.put(pieceType, validMoves);
        });

        return newPieceMap;
    }

    public static boolean isValidMove(Move move) {
        int fromRow = move.getFromRow();
        int fromCol = move.getFromCol();
        return fromRow >= 0 && fromRow <= 7 && fromCol >= 0 && fromCol <= 7;
    }


    public static boolean canMove(Move move, Map<PieceType, List<Move>> pieceMap) {
        for (List<Move> moves : pieceMap.values()) {
            for (Move movee : moves) {
                if (movee.getFromRow() == move.getFromRow() && movee.getFromCol() == move.getFromCol()) {
                    return true;
                }
            }
        }
        return false;
    }

    /*public static boolean checkIfPieceOnPath(Move move, Map<PieceType, List<Move>> pieceMap) {

    }*/
    public static List<Move> getAllMovesByColor(Map<String, Move> pieceMap, String color) {
        String clr = color.substring(Math.max(0, color.length() - 5));
        List<Move> moves = new ArrayList<>();
        pieceMap.forEach((piece,move) ->{
            if (piece.toLowerCase().contains(clr.toLowerCase())) {
                moves.add(move);
            }
        });
        return moves;
    }

    public static Boolean chekMoveInList(Map<String, Move> pieceMap, String color,Move move){

        for (Move movee : getAllMovesByColor(pieceMap, color)) {
            if (movee.getFromRow() == move.getFromRow() && movee.getFromCol() == move.getFromCol()) {
                return false;
            }
        }
        return true;
    }
/*
    public static Boolean chekePieceAvailbeInPath(Map<String, Move> pieceMap, String color,Move move,Move oldMove){

         boolean check=true;
         int size=getAllMovesByColor(pieceMap, color).size();
         List<Move> moveList = getAllMovesByColor(pieceMap, color);
         String key =findKeyForMove(pieceMap,oldMove);
         assert key != null;
         if (key.regionMatches(true,0,"knight",0,5)){
             return check;
         }else {
             for (int i = 0; i < size; i++) {
                 System.out.println(i- move.getFromRow());
                 if (move.getFromRow() == moveList.get(i).getFromRow() && move.getFromCol() == moveList.get(i).getFromCol()) {
                     return false;
                 }else if(move.getFromRow()==moveList.get(i).getFromRow() && i+move.getFromCol()==moveList.get(i).getFromCol()) {
                     check=false;
                     break;
                 }else  if(i+move.getFromRow()==moveList.get(i).getFromRow() && move.getFromCol()==moveList.get(i).getFromCol()) {
                     check=false;
                     break;
                 }else  if(move.getFromRow()==moveList.get(i).getFromRow() && i-move.getFromCol()==moveList.get(i).getFromCol()) {
                     check=false;
                     break;
                 }else  if(i-move.getFromRow()==moveList.get(i).getFromRow() && move.getFromCol()==moveList.get(i).getFromCol()) {
                     check=false;
                     break;
                 }
             }


         }


        return check;
    }
*/

    public static boolean isPieceAvailableInPath(Map<String, Move> pieceMap, String color, Move move, Move oldMove) {
        List<Move> moveList = getAllMovesByColor(pieceMap, color);

        String key =findKeyForMove(pieceMap,oldMove);
        assert key != null;
        if (key.regionMatches(true,0,"knight",0,5)){
            return true;
        }

        int toRow = move.getFromRow();
        int toCol = move.getFromCol();

        for (Move otherMove : moveList) {
             if (otherMove.equals(move)) {
                continue;
            }

             if (move.getFromRow() == otherMove.getFromRow() || move.getFromCol() == otherMove.getFromCol()) {
                 toRow = otherMove.getFromRow();
                toCol = otherMove.getFromCol();

                 if (isBetween(move.getFromRow(), toRow, move.getFromRow()) &&
                        isBetween(move.getFromCol(), toCol, move.getFromCol())) {
                    return false;
                }
            }

             if (Math.abs(move.getFromRow() - otherMove.getFromRow()) == Math.abs(move.getFromCol() - otherMove.getFromCol())) {
                 toRow = otherMove.getFromRow();
                toCol = otherMove.getFromCol();

                 if (isBetween(move.getFromRow(), toRow, move.getFromRow()) &&
                        isBetween(move.getFromCol(), toCol, move.getFromCol())) {
                    return false;
                }
            }
        }

        return true;
    }

     private static boolean isBetween(int value, int lower, int upper) {
        return value >= Math.min(lower, upper) && value <= Math.max(lower, upper);
    }
}
