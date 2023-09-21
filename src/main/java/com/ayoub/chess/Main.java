package com.ayoub.chess;

import com.ayoub.chess.moves.Move;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Move.allMoves().stream().forEach(m->System.out.println(m));
    }


}