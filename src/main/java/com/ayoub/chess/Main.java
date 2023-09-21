package com.ayoub.chess;

import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.pieces.ChessPiece;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println(ChessPiece.getQueenMoves(new Move(4,4)).get(PieceType.QUEEN).size());//.forEach((pieceType, moves) -> System.out.println(pieceType+" "+moves));
    }
}