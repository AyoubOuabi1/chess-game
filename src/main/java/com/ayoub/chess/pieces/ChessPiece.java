package com.ayoub.chess.pieces;


import com.ayoub.chess.enums.Color;
import com.ayoub.chess.enums.PieceType;

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
}
