package com.ayoub.chess.Helpers;

import com.ayoub.chess.moves.Move;
import org.junit.jupiter.api.Test;

import java.util.*;

class HelperTest {

    @Test
    void getMoveAfterVerification() {

    }

    @Test
    void getMoveByName() {
    }
    @Test
    void removeMove() {
        //Helper.removeInvalidMoves(getMove()).forEach((piece,move) ->System.out.println(piece+" "+move));
        //assertEquals(true,Helper.canMove(new Move(7,0),getMove()));

        //getMove().forEach((piece,move) ->System.out.println(piece+" "+move));
    }

    @Test
    void canMove() {
        //getMove().forEach((piece,move) ->System.out.println(piece+" "+move));
        //assertEquals(false,Helper.canMove(new Move(0,7),Helper.removeInvalidMoves(getMove())));
    }


    Map<String, Move> getMove() {
        Map<String, Move> pieceMap = new HashMap<>();
        pieceMap.put("rook_white", new Move(0,0));
        pieceMap.put("Knight_white",new Move(0,1));
        pieceMap.put("Bishop_white",new Move(0,2));
        pieceMap.put("Queen_white",new Move(0,3));
        pieceMap.put("King_white",new Move(0,4));
        pieceMap.put("Bishop_2_white",new Move(0,5));
        pieceMap.put("Knight_2_white",new Move(0,6));
        pieceMap.put("Rook_2_white",new Move(0,8));
        pieceMap.put("Rook_black",new Move(7,0));
        pieceMap.put("knight_black",new Move(7,1));
        pieceMap.put("Bishop_black",new Move(7,2));
        pieceMap.put("King_black",new Move(7,3));
        pieceMap.put("queen_black",new Move(7,4));
        pieceMap.put("Bishop_2_black",new Move(7,5));
        pieceMap.put("knight_2_black",new Move(7,6));
        pieceMap.put("Rook_2_black",new Move(7,7));
        for (int i = 0; i < 8; i++) {
             pieceMap.put("Pawn_"+(i+1)+"_black",new Move(6,i));
             pieceMap.put("Pawn_"+(i+1)+"_white",new Move(1,i));

        }
        return pieceMap;
    }

    @Test
    void getAllMovesByColor() {

        ChessPieceController.getAllMovesByColor(getMove(),"queen_white").forEach(move -> System.out.println(move.toString()));
       // assertEquals(false,Helper.chekePieceAvailbeInPath(getMove(),"queen_white",new Move(0,3)));
    }
}