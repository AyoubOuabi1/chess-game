package com.ayoub.chess;

import com.ayoub.chess.board.ChessBoard;
import com.ayoub.chess.enums.PieceType;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.pieces.ChessPiece;
import com.ayoub.chess.prints.PrintMessages;

import javax.print.attribute.standard.PrinterInfo;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        //System.out.println(ChessPiece.getQueenMoves(new Move(4,4)).get(PieceType.QUEEN).size());//.forEach((pieceType, moves) -> System.out.println(pieceType+" "+moves));
        // ChessBoard.printBoard();
        PrintMessages.printFirstMessage();
        ChessBoard.printBoard(null,null);
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter x position");
        int fromRow =scanner.nextInt();
        System.out.println("please enter y position");
        int fromCol =scanner.nextInt();
        System.out.println("please enter x1 position");
        int toRow =scanner.nextInt();
        System.out.println("please enter y1 position");
        int toCol =scanner.nextInt();
        ChessBoard.printBoard(new Move(fromRow,fromCol),new Move(toRow,toCol));
    }
}