package com.ayoub.chess.pieces;


import com.ayoub.chess.enums.Color;
import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessPiece {
    private PieceType pieceType;
    private Color color;

    public ChessPiece(PieceType pieceType, Color color) {
        this.pieceType = pieceType;
        this.color = color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
         return color.toString() + " " + pieceType.toString();
    }

    public static Map<PieceType,List<Move>> getQueenMoves(Move move){
        Map<PieceType,List<Move>> pieceMove=new HashMap<>();
        List<Move> queenMove=new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            queenMove.add(new Move(move.getFromRow(),move.getFromCol()+i));
            queenMove.add(new Move(move.getFromRow()+i,move.getFromCol()));
            queenMove.add(new Move(move.getFromRow(),move.getFromCol()+i));
            queenMove.add(new Move(move.getFromRow()-i,move.getFromCol()));
            queenMove.add(new Move(move.getFromRow()+i,move.getFromCol()+i));
            queenMove.add(new Move(move.getFromRow()-i,move.getFromCol()-i));
            queenMove.add(new Move(move.getFromRow()-i,move.getFromCol()+i));
            queenMove.add(new Move(move.getFromRow()+i,move.getFromCol()-i));
        }

        pieceMove.put(PieceType.QUEEN,queenMove);
        return pieceMove;
    }
    public static Map<PieceType,List<Move>> getKingMoves(Move move){
        Map<PieceType,List<Move>> pieceMove=new HashMap<>();
        List<Move> kingMove=new ArrayList<>();
        kingMove.add(new Move(move.getFromRow()+1,move.getFromCol()+1));
        kingMove.add(new Move(move.getFromRow()-1,move.getFromCol()-1));
        kingMove.add(new Move(move.getFromRow()-1,move.getFromCol()+1));
        kingMove.add(new Move(move.getFromRow()+1,move.getFromCol()-1));
        kingMove.add(new Move(move.getFromRow(),move.getFromCol()+1));
        kingMove.add(new Move(move.getFromRow(),move.getFromCol()-1));
        kingMove.add(new Move(move.getFromRow()+1,move.getFromCol()));
        kingMove.add(new Move(move.getFromRow()-1,move.getFromCol()));
        pieceMove.put(PieceType.KING,kingMove);
        return pieceMove;
    }
    public static Map<PieceType,List<Move>> getBishopMoves(Move move){
        Map<PieceType,List<Move>> pieceMove=new HashMap<>();
        List<Move> bishopMove=new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            bishopMove.add(new Move(move.getFromRow()+i,move.getFromCol()+i));
            bishopMove.add(new Move(move.getFromRow()-i,move.getFromCol()-i));
            bishopMove.add(new Move(move.getFromRow()-i,move.getFromCol()+i));
            bishopMove.add(new Move(move.getFromRow()+i,move.getFromCol()-i));

        }

        pieceMove.put(PieceType.BISHOP,bishopMove);
        return pieceMove;
    }
    public static Map<PieceType,List<Move>> getRookMoves(Move move){
        Map<PieceType,List<Move>> pieceMove=new HashMap<>();
        List<Move> rookMove=new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            rookMove.add(new Move(move.getFromRow(),move.getFromCol()+i));
            rookMove.add(new Move(move.getFromRow()+i,move.getFromCol()));
            rookMove.add(new Move(move.getFromRow(),move.getFromCol()+i));
            rookMove.add(new Move(move.getFromRow()-i,move.getFromCol()));

        }
        pieceMove.put(PieceType.ROOK,rookMove);
        return pieceMove;
    }

    public static Map<PieceType,List<Move>> getKnightMoves(Move move){
        Map<PieceType,List<Move>> pieceMove=new HashMap<>();
        List<Move> knightMove=new ArrayList<>();
        knightMove.add(new Move(move.getFromRow()+2,move.getFromCol()+1));
        knightMove.add(new Move(move.getFromRow()+2,move.getFromCol()-1));
        knightMove.add(new Move(move.getFromRow()-2,move.getFromCol()-1));
        knightMove.add(new Move(move.getFromRow()-2,move.getFromCol()+1));
        knightMove.add(new Move(move.getFromRow()+1,move.getFromCol()+2));
        knightMove.add(new Move(move.getFromRow()-1,move.getFromCol()+2));
        knightMove.add(new Move(move.getFromRow()-1,move.getFromCol()-2));
        knightMove.add(new Move(move.getFromRow()+1,move.getFromCol()-2));

        pieceMove.put(PieceType.ROOK,knightMove);
        return pieceMove;
    }

    public static Map<PieceType,List<Move>> getPawnMoves(Move move){
        Map<PieceType,List<Move>> pieceMove=new HashMap<>();
        List<Move> PawnMove=new ArrayList<>();
        PawnMove.add(new Move(move.getFromRow(),move.getFromCol()+2));
        PawnMove.add(new Move(move.getFromRow(),move.getFromCol()+1));
        PawnMove.add(new Move(move.getFromRow()+1,move.getFromCol()+1));
        pieceMove.put(PieceType.ROOK,PawnMove);
        return pieceMove;
    }


}
