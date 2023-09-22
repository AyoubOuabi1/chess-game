package com.ayoub.chess;

import com.ayoub.chess.board.ChessBoard;
import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.pieces.ChessPiece;
import com.ayoub.chess.prints.PrintMessages;

import javax.print.attribute.standard.PrinterInfo;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiConsumer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        System.out.println(ChessPiece.getQueenMoves(new Move(4,4)).get(PieceType.QUEEN).size());//.forEach((pieceType, moves) -> System.out.println(pieceType+" "+moves));
        // ChessBoard.printBoard();
        PrintMessages.printFirstMessage();
       // Optional<List<Move>> moveList=Optional.of(PrintMessages.getPositions());
        //moveList.ifPresent(move -> ChessBoard.printBoard(move.get(0),move.get(1)));
        PrintMessages.getPositions().ifPresent(move -> ChessBoard.printBoard(move.get(0),move.get(1)).forEach(new BiConsumer<String, List<Move>>() {
            @Override
            public void accept(String s, List<Move> moves) {
                System.out.println(s+" "+moves);
            }
        }));
    }
}