package com.ayoub.chess;

import com.ayoub.chess.board.ChessBoard;
import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.pieces.ChessPiece;
import com.ayoub.chess.prints.PrintMessages;

import javax.print.attribute.standard.PrinterInfo;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        gg();
    }
    static void gg(){
        Map<String,Move> pieceMap = new HashMap<>();
        Move[] move1 = new Move[2];
        PrintMessages.getPositions().ifPresent(new Consumer<List<Move>>() {
            @Override
            public void accept(List<Move> moves) {
                pieceMap.putAll(ChessBoard.printBoard(moves.get(0),moves.get(1)));
                move1[0] =moves.get(0);
                move1[1] =moves.get(1);
            }
        });

        for (Map.Entry<String, Move> entry : pieceMap.entrySet()) {
            if(entry.getValue().getFromRow()==move1[0].getFromRow() && entry.getValue().getFromCol()==move1[0].getFromCol()){
                System.out.println(entry.getKey());
                break;
            }
        }

    }

}