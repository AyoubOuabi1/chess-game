package com.ayoub.chess.Helpers;

import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.pieces.ChessPieceServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessPieceController {
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
            return ChessPieceServices.getRookMoves(new Move(move.getFromRow(), move.getFromCol()));
        }else if(piece.regionMatches(true,0,PieceType.KNIGHT.name(),0,6)){
            return ChessPieceServices.getKnightMoves(new Move(move.getFromRow(), move.getFromCol()));
        } else if (piece.regionMatches(true,0,PieceType.KING.name(),0,4)) {
            return ChessPieceServices.getKingMoves(new Move(move.getFromRow(), move.getFromCol()));
        } else if (piece.regionMatches(true,0,PieceType.QUEEN.name(),0,5)) {
            return ChessPieceServices.getQueenMoves(new Move(move.getFromRow(), move.getFromCol()));
        }else if (piece.regionMatches(true,0,PieceType.BISHOP.name(),0,6)) {
            return ChessPieceServices.getBishopMoves(new Move(move.getFromRow(), move.getFromCol()));
        }else if (piece.regionMatches(true,0,PieceType.PAWN.name(),0,4)) {
            return ChessPieceServices.getPawnMoves(new Move(move.getFromRow(), move.getFromCol()));
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


    public static List<Move> getAllMovesByColor(Map<String, Move> pieceMap, String color) {
        String clr;
        if(color.length()==5){
            clr=color;
        }else{
            clr = color.substring(Math.max(0, color.length() - 5));
        }
        List<Move> moves = new ArrayList<>();
        pieceMap.forEach((piece,move) ->{
            if (piece.toLowerCase().contains(clr.toLowerCase())) {
                moves.add(move);
            }
        });
        return moves;
    }


    public static Boolean chekePieceAvailbeInPath(Map<String, Move> pieceMap, String piece,Move move,Move oldMove){
        if(piece.regionMatches(true,0,PieceType.KNIGHT.name(),0,6)){
            return ChessPieceServices.checkPieceAvailableInKnightPath(pieceMap,piece,move);
        }else if(piece.regionMatches(true,0,PieceType.ROOK.name(),0,4)){
            return ChessPieceServices.chekePieceAvailbeInRookPath(pieceMap,piece, move, oldMove);
        }else if(piece.regionMatches(true,0,PieceType.BISHOP.name(),0,6)){
            return ChessPieceServices.checkPieceAvailableInBishopPath(pieceMap,piece, move, oldMove);
        }else if(piece.regionMatches(true,0,PieceType.QUEEN.name(),0,5)) {
            return ChessPieceServices.checkPieceAvailableInQueenPath(pieceMap,piece, move, oldMove);
        }else if(piece.regionMatches(true,0,PieceType.KING.name(),0,4)) {
            return ChessPieceServices.checkPieceAvailableInKingPath(pieceMap,piece, move);
        }else if(piece.regionMatches(true,0,PieceType.PAWN.name(),0,4)) {
            return ChessPieceServices.checkPieceAvailableInPawnPath(pieceMap,piece, move);
        }
        return true;
    }

    public static Boolean checkCap(String color,Move targetMove,Map<String, Move> pieceMap){
        List<Move> moveList = new ArrayList<>();
        if (color.equalsIgnoreCase("black")){
            moveList=getAllMovesByColor(pieceMap, "white");

        }else if (color.equalsIgnoreCase("white")){
            moveList=getAllMovesByColor(pieceMap, "black");

        }
        for (Move move : moveList) {
            if (move.equals(targetMove)){
                return true;
            }
        }
        return  false;
    }
}
