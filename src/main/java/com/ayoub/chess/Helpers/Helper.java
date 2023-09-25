package com.ayoub.chess.Helpers;

import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.pieces.ChessPiece;

import java.util.List;
import java.util.Map;

public class Helper {
    public static String findKeyForMove(Map<String, Move> pieceMap, Move targetMove) {
        for (Map.Entry<String, Move> entry : pieceMap.entrySet()) {
            if (entry.getValue().getFromRow() == targetMove.getFromRow() && entry.getValue().getFromCol() == targetMove.getFromCol()) {
                return entry.getKey();
            }
        }
        return null;
    }
    public static Map<PieceType, List<Move>> getMoveByName(Move move, String piece) {
        if(piece.regionMatches(true,0,PieceType.ROOK.name(),0,4)){
            return ChessPiece.getRookMoves(new Move(move.getFromRow(), move.getFromCol()));
        }else if(piece.regionMatches(true,0,PieceType.KNIGHT.name(),0,6)){
            return ChessPiece.getKnightMoves(new Move(move.getFromRow(), move.getFromCol()));
        } else if (piece.regionMatches(true,0,PieceType.KING.name(),0,4)) {
            return ChessPiece.getKnightMoves(new Move(move.getFromRow(), move.getFromCol()));
        } else if (piece.regionMatches(true,0,PieceType.QUEEN.name(),0,5)) {
            return ChessPiece.getQueenMoves(new Move(move.getFromRow(), move.getFromCol()));
        }else if (piece.regionMatches(true,0,PieceType.BISHOP.name(),0,6)) {
            return ChessPiece.getBishopMoves(new Move(move.getFromRow(), move.getFromCol()));
        }
        return null;
    }

    /*public static Map<PieceType, List<Move>> getMoveAfterVerification(Move move, String piece){

    }
    public static String removeMove(Map<String, Move> pieceMap, Move targetMove) {
        for (Map.Entry<String, Move> entry : pieceMap.entrySet()) {
            if (entry.getValue().getFromRow() == targetMove.getFromRow() && entry.getValue().getFromCol() == targetMove.getFromCol()) {
                return entry.getKey();
            }
        }
        return null;
    }*/
}
