package com.ayoub.chess.board;


import com.ayoub.chess.Helpers.ChessPieceController;
import com.ayoub.chess.Players.Player;
import com.ayoub.chess.moves.Move;
import com.ayoub.chess.prints.PrintMessages;

import java.util.*;

public class ChessBoard {
    private Map<String, Move> pieceMap;
    private String[][] chessboard;
    private Player player1;
    private Player player2;
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private Player currentPlayer;
    public ChessBoard() {
        initBoard();
        setupPlayers();
        currentPlayer = player1;
    }


    public Map<String, Move> getPieceMap() {
        return pieceMap;
    }

    public String[][] getChessboard() {
        return chessboard;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    private void setupPlayers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player 1's name: ");
        String name1 = scanner.nextLine();

        System.out.println("Enter Player 2's name: ");
        String name2 = scanner.nextLine();

        player1 = new Player(name1, "white");
        player2 = new Player(name2, "black");
    }

    private void initBoard() {
        int size = 8;
        chessboard = new String[size][size];
        pieceMap = new HashMap<>();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                chessboard[row][col] = " { } ";
            }
        }

        chessboard[0][0] = " {♜}"; // Rook
        pieceMap.put("rook_white", new Move(0, 0));

        chessboard[0][1] = " {♞}"; // Knight
        pieceMap.put("Knight_white", new Move(0, 1));

        chessboard[0][2] = " {♝}"; // Bishop
        pieceMap.put("Bishop_white", new Move(0, 2));

        chessboard[0][3] = "  {♛}"; // Queen
        pieceMap.put("Queen_white", new Move(0, 3));

        chessboard[0][4] = "  {♚}"; // King
        pieceMap.put("King_white", new Move(0, 4));

        chessboard[0][5] = " {♝}"; // Bishop
        pieceMap.put("Bishop_2_white", new Move(0, 5));

        chessboard[0][6] = " {♞}"; // Knight
        pieceMap.put("Knight_2_white", new Move(0, 6));

        chessboard[0][7] = " {♜}"; // Rook
        pieceMap.put("Rook_2_white", new Move(0, 7));

        chessboard[7][0] = " {♖}";
        pieceMap.put("Rook_black", new Move(7, 0));

        chessboard[7][1] = " {♘}";
        pieceMap.put("knight_black", new Move(7, 1));

        chessboard[7][2] = " {♗}";
        pieceMap.put("Bishop_black", new Move(7, 2));

        chessboard[7][3] = "  {♕}";
        pieceMap.put("King_black", new Move(7, 3));

        chessboard[7][4] = "  {♔}";
        pieceMap.put("queen_black", new Move(7, 4));

        chessboard[7][5] = " {♗}";
        pieceMap.put("Bishop_2_black", new Move(7, 5));

        chessboard[7][6] = " {♘}";
        pieceMap.put("knight_2_black", new Move(7, 6));

        chessboard[7][7] = " {♖}";
        pieceMap.put("Rook_2_black", new Move(7, 7));

        for (int i = 0; i < 3; i++) {
            chessboard[6][i] = " {♙}";
            pieceMap.put("Pawn_" + (i + 1) + "_black", new Move(6, i));

            chessboard[1][i] = " {♟}";
            pieceMap.put("Pawn_" + (i + 1) + "_white", new Move(1, i));
        }

        chessboard[6][3] = "  {♙}";
        pieceMap.put("Pawn_4_black", new Move(6, 3));

        chessboard[1][3] = "  {♟}";
        pieceMap.put("Pawn_4_white", new Move(1, 3));

        chessboard[6][4] = "  {♙}";
        pieceMap.put("Pawn_5_black", new Move(6, 4));

        chessboard[1][4] = "  {♟}";
        pieceMap.put("Pawn_5_white", new Move(1, 4));

        for (int i = 5; i < size; i++) {
            chessboard[6][i] = " {♙}";
            pieceMap.put("Pawn_" + (i + 1) + "_black", new Move(6, i));
            chessboard[1][i] = " {♟}";
            pieceMap.put("Pawn_" + (i + 1) + "_white", new Move(1, i));
        }
    }

    public void updateBoard() {
        PrintMessages.printBoard(chessboard);
        System.out.println(currentPlayer.getName() + ", it's your turn. ( "+currentPlayer.getColor()+" )");

        while (true) {
            Optional<List<Move>> moveList = PrintMessages.getPositions();
            if (moveList.isPresent()) {
                List<Move> moves = moveList.get();
                Move oldMove = moves.get(0);
                Move targetMove = moves.get(1);

                if (oldMove != null && targetMove != null) {
                    String key = ChessPieceController.findKeyForMove(pieceMap, oldMove);
                    if (ChessPieceController.canMove(targetMove, ChessPieceController.getMoveAfterVerification(oldMove, key))) {
                        if (ChessPieceController.chekePieceAvailbeInPath(pieceMap, key, targetMove, oldMove)) {
                            if(ChessPieceController.checkCap(getCurrentPlayerColor(),targetMove,pieceMap)){
                                String key2=ChessPieceController.findKeyForMove(pieceMap,targetMove);
                                pieceMap.remove(key2);
                                if (currentPlayer == player1) {
                                    scorePlayer1 += 1;
                                } else {
                                    scorePlayer2 += 1;
                                }
                            }
                            pieceMap.put(key, targetMove);
                            for (int i = 0; i < chessboard.length; i++) {
                                for (int j = 0; j < chessboard[i].length; j++) {
                                    if (oldMove.getFromRow() == i && oldMove.getFromCol() == j) {
                                        String oldValue = chessboard[i][j];
                                        chessboard[i][j] = " { } ";
                                        chessboard[targetMove.getFromRow()][targetMove.getFromCol()] = oldValue;
                                    }
                                }
                            }

                            break;
                        } else {
                            System.out.println("Invalid move: Square is not allowed");
                        }
                    } else {
                        System.out.println("Invalid move");
                    }
                }
            }
        }
        displayScores();
        switchPlayer();
    }
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    private void displayScores() {
        System.out.println("Scores:");
        System.out.println(player1.getName() + ": " + scorePlayer1);
        System.out.println(player2.getName() + ": " + scorePlayer2);
    }

    String getCurrentPlayerColor(){
        return currentPlayer.getColor();
    }
}

