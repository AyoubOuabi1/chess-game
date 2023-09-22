package com.ayoub.chess.prints;

import com.ayoub.chess.board.ChessBoard;
import com.ayoub.chess.moves.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PrintMessages {

    public static  String printFirstMessage(){
        System.out.println("Welcome to Chess game!");
        System.out.println("Please enter your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }
    public static Optional<List<Move>> getPositions(){
        Optional<List<Move>> list;
         List<Move> positions = new ArrayList<>();
        int[] pos=getInput();
        if (checkInput(pos)){
            positions.add(new Move(pos[0], pos[1]));
            positions.add(new Move(pos[2], pos[3]));
            list=Optional.of(positions);
        }else{
            System.out.println("invalid input");
            list= Optional.empty();
        }

        return list;
    }

    public static int[] getInput(){
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
        return new int[]{fromRow,fromCol,toRow,toCol};

    }

    public static boolean checkInput(int[] pos){
        boolean check=true;
        for (int j = 0; j < 4; j++) {
            if (pos[j] < 0 || pos[j] >7 ){
                check= false;
            }
        }
        return check;
    }


}
