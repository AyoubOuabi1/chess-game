package com.ayoub.chess.pieces;


import com.ayoub.chess.Helpers.Helper;
import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessPiece {

    public static Map<PieceType,List<Move>> getQueenMoves(Move move){
        Map<PieceType,List<Move>> pieceMove=new HashMap<>();
        List<Move> queenMove=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
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
        for (int i = 0; i < 8; i++) {
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
        for (int i = 0; i < 8; i++) {
            rookMove.add(new Move(move.getFromRow(),move.getFromCol()+i));
            rookMove.add(new Move(move.getFromRow()+i,move.getFromCol()));
            rookMove.add(new Move(move.getFromRow(),move.getFromCol()-i));
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
        PawnMove.add(new Move(move.getFromRow()-2,move.getFromCol()));
        PawnMove.add(new Move(move.getFromRow()+2,move.getFromCol()));
        PawnMove.add(new Move(move.getFromRow()+1,move.getFromCol()+1));
        PawnMove.add(new Move(move.getFromRow()-1,move.getFromCol()+1));
        PawnMove.add(new Move(move.getFromRow()+1,move.getFromCol()-1));
        PawnMove.add(new Move(move.getFromRow()-1,move.getFromCol()-1));
        PawnMove.add(new Move(move.getFromRow()-1,move.getFromCol()));
        PawnMove.add(new Move(move.getFromRow()+1,move.getFromCol()));
        pieceMove.put(PieceType.ROOK,PawnMove);
        return pieceMove;
    }

    public static Boolean chekePieceAvailbeInRookPath(Map<String, Move> pieceMap, String color,Move move,Move oldMove){
        List<Move> moveList =new ArrayList<>();
        for (Move newmove :  Helper.getAllMovesByColor(pieceMap, color)) {
            if(oldMove.getFromRow()== newmove.getFromRow() || oldMove.getFromCol()== newmove.getFromCol()){
                moveList.add(newmove);
            }
        }
        moveList.removeIf(existingMove -> existingMove.getFromRow() == oldMove.getFromRow() && existingMove.getFromCol() == oldMove.getFromCol());
         for (Move newMove : moveList){
             if(newMove.getFromRow() == move.getFromRow()|| newMove.getFromCol()== move.getFromCol()){
                return false;
            }
        }
        return true;
    }
    public static Boolean chekePieceAvailbeInBishopPath(Map<String, Move> pieceMap, String color,Move move,Move oldMove){
        List<Move> moveList = Helper.getAllMovesByColor(pieceMap, color);
        boolean check=true;
        for (Move newmove :  Helper.getAllMovesByColor(pieceMap, color)) {
            if(oldMove.getFromRow()== newmove.getFromRow() || oldMove.getFromCol()== newmove.getFromCol()){
                moveList.add(newmove);
            }
        }

        moveList.forEach(System.out::println);
        moveList.removeIf(existingMove -> existingMove.getFromRow() == oldMove.getFromRow() && existingMove.getFromCol() == oldMove.getFromCol());
        int i =0;
        for (Move newMove : moveList){
            i++;
            for (int j = 0; j < 8; j++) {
                if(newMove.getFromRow() == move.getFromRow()+i && newMove.getFromCol()== move.getFromCol()+j){
                    check= false;
                    break;
                }else  if(newMove.getFromRow() == move.getFromRow()+i && newMove.getFromCol()== move.getFromCol()-i){

                    check= false;
                    break;
                }else  if(newMove.getFromRow() == move.getFromRow()-i && newMove.getFromCol()== move.getFromCol()-i){
                    check= false;

                    break;
                }else  if(newMove.getFromRow() == move.getFromRow()-i && newMove.getFromCol()== move.getFromCol()+i){

                    check= false;
                    break;
                }
            }

        }
        return check;
    }


}
