package com.ayoub.chess.moves;

import java.util.ArrayList;
import java.util.List;

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

  /*  public Move(int fromRow, int fromCol, int toRow, int toCol) {
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }*/

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
}
