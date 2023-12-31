package com.ayoub.chess.moves;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class  Move {
    private int fromRow;
    private int fromCol;
   /* private int toRow;
    private int toCol;*/

    public Move(int fromRow, int fromCol) {
        this.fromRow = fromRow;
        this.fromCol = fromCol;
    }

    public Move() {

    }


    public int getFromRow() {
        return fromRow;
    }

    public int getFromCol() {
        return fromCol;
    }

   /* public int getToRow() {
        return toRow;
    }

    public int getToCol() {
        return toCol;
    }
*/
    @Override
    public String toString() {
        return "(" + fromRow + ", " + fromCol + ") \n";
    }

    public static List<Move> allMoves(){
        List<Move> m=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
               m.add(new Move(i+1,j+1));
            }
        }
        return m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        if (fromRow != move.fromRow) return false;
        return fromCol == move.fromCol;
    }


}
