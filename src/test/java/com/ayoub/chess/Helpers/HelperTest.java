package com.ayoub.chess.Helpers;

import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    @Test
    void getMoveAfterVerification() {
    }

    @Test
    void getMoveByName() {
    }
    @Test
    void removeMove() {
        Helper.removeInvalidMoves(getMove()).forEach((piece,move) ->System.out.println(piece+" "+move));
        //assertEquals(true,Helper.canMove(new Move(7,0),getMove()));

        //getMove().forEach((piece,move) ->System.out.println(piece+" "+move));
    }

    @Test
    void canMove() {
        //getMove().forEach((piece,move) ->System.out.println(piece+" "+move));
        assertEquals(false,Helper.canMove(new Move(0,7),Helper.removeInvalidMoves(getMove())));
    }


    Map<PieceType, List<Move>> getMove() {
        Map<PieceType, List<Move>> moves = new HashMap<>();

        // Enumerate through each PieceType
        for (PieceType pieceType : PieceType.values()) {
            List<Move> moveList = new ArrayList<>();

            // Generate random moves within the constraints
            Random random = new Random();
            int numberOfMoves = random.nextInt(10) + 1; // Generates between 1 and 10 moves
            for (int i = 0; i < numberOfMoves; i++) {
                int from = random.nextInt(12) - 1; // Generates between -1 and 10
                int to = random.nextInt(12) - 1;   // Generates between -1 and 10
                Move move = new Move(from, to);

                moveList.add(move);
            }

            if (pieceType == PieceType.PAWN) {
                // Add the move (0, 7) to the PAWN's list
                moveList.add(new Move(0, 7));
            }

            moves.put(pieceType, moveList);
        }

        // Print the generated moves
        return moves;
    }
}