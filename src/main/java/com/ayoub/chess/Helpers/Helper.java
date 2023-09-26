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


}
