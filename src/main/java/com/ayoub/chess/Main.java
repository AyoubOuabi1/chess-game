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
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

       // System.out.println(ChessPiece.getQueenMoves(new Move(4,4)).get(PieceType.QUEEN).size());//.forEach((pieceType, moves) -> System.out.println(pieceType+" "+moves));
        // ChessBoard.printBoard();
       // PrintMessages.printFirstMessage();
        //Optional<List<Move>> moveList=Optional.of(PrintMessages.getPositions());
       // moveList.ifPresent(move -> ChessBoard.printBoard(move.get(0),move.get(1)));
        /*Map<String,List<Move>> pieceMap = new HashMap<>();
        Move[] move1 = new Move[2];
        PrintMessages.getPositions().ifPresent(new Consumer<List<Move>>() {
            @Override
            public void accept(List<Move> moves) {
                pieceMap.putAll(ChessBoard.printBoard(moves.get(0),moves.get(1)));
                move1[0] =moves.get(0);
                move1[1] =moves.get(1);
            }
        });
        pieceMap.forEach((piece, position)->System.out.println(piece+" "+position));*/
        gg();
    }
    static void gg(){
        Map<String,List<Move>> pieceMap = new HashMap<>();
        Move[] move1 = new Move[2];
        PrintMessages.getPositions().ifPresent(new Consumer<List<Move>>() {
            @Override
            public void accept(List<Move> moves) {
                pieceMap.putAll(ChessBoard.printBoard(moves.get(0),moves.get(1)));
                move1[0] =moves.get(0);
                move1[1] =moves.get(1);
            }
        });
        String[] strr = new String[1];
        pieceMap.forEach(new BiConsumer<String, List<Move>>() {
            @Override
            public void accept(String s, List<Move> moves) {
                for (Move move : moves) {
                    if (move.getFromRow() == move1[0].getFromRow()&& move.getFromCol()==move1[1].getFromCol()) {
                       pieceMap.keySet().stream().filter(new Predicate<String>() {
                            @Override
                            public boolean test(String str) {

                                System.out.println(str);
                                return true;
                            }
                        });
                        break;
                    }

                }
            }
        });
        /*pieceMap.forEach(new BiConsumer<String, List<Move>>() {
            @Override
            public void accept(String s, List<Move> moves) {
                for (Move move : moves) {
                    if (move.getFromRow() == move1[0].getFromRow()&& move.getFromCol()==move1[1].getFromCol()) {
                       pieceMap.keySet().stream().filter(new Predicate<String>() {
                            @Override
                            public boolean test(String str) {

                                strr[0] =;
                                return str.equalsIgnoreCase(s);
                            }
                        });
                        break;
                    }

                }
            }
        });*/
        //System.out.println(strr[0].toString());
    }

}