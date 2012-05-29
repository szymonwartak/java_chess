package com.bullionvault.chess;

import com.bullionvault.chess.piece.*;

public class ChessGame {

	private Piece[][] board = new Piece[8][8];
	private Player player1, player2;
	private Player currentPlayer;
	
	public ChessGame() {
		player1 = new Player("B", Colour.BLACK);	
		board[1][0] = new Pawn(player1);
		board[1][1] = new Pawn(player1);
		board[1][2] = new Pawn(player1);
		board[1][3] = new Pawn(player1);
		board[1][4] = new Pawn(player1);
		board[1][5] = new Pawn(player1);
		board[1][6] = new Pawn(player1);
		board[1][7] = new Pawn(player1);
		board[0][0] = new Rook(player1);
		board[0][1] = new Knight(player1);
		board[0][2] = new Bishop(player1);
		board[0][3] = new King(player1);
		board[0][4] = new Queen(player1);
		board[0][5] = new Bishop(player1);
		board[0][6] = new Knight(player1);
		board[0][7] = new Rook(player1);

		player2 = new Player("W", Colour.WHITE);
		board[6][0] = new Pawn(player2);
		board[6][1] = new Pawn(player2);
		board[6][2] = new Pawn(player2);
		board[6][3] = new Pawn(player2);
		board[6][4] = new Pawn(player2);
		board[6][5] = new Pawn(player2);
		board[6][6] = new Pawn(player2);
		board[6][7] = new Pawn(player2);
		board[7][0] = new Rook(player2);
		board[7][1] = new Knight(player2);
		board[7][2] = new Bishop(player2);
		board[7][3] = new King(player2);
		board[7][4] = new Queen(player2);
		board[7][5] = new Bishop(player2);
		board[7][6] = new Knight(player2);
		board[7][7] = new Rook(player2);

		currentPlayer = player1;
	}
	public boolean processMove(int[] from, int[] to) {
		if(isLegalMove(from,to)) {
			if(board[to[1]][to[0]]==null)
				System.out.println("Player "+currentPlayer.getName()+" move from "+from[0]+","+from[1]+" to "+to[0]+","+to[1]);
			else
				System.out.println("Player "+currentPlayer.getName()+" takes piece at "+to[0]+","+to[1]+" with "+from[0]+","+from[1]);
			board[to[1]][to[0]] = board[from[1]][from[0]];
			board[from[1]][from[0]] = null;
			return true;
		} else {
			System.out.println("Illegal move from "+from[0]+","+from[1]+" to "+to[0]+","+to[1]);
			return false;
		}
	}
	/**
	 * Checks that the move is legal. First check is the piece movement, then 
	 * check that there is nothing in the way of the piece moving to the 
	 * new position
	 * @param from
	 * @param to
	 * @return true if the move is legal
	 */
	public boolean isLegalMove(int[] from, int[] to) {
		if(board[from[1]][from[0]] == null) 
			return false;
		else if(board[from[1]][from[0]] instanceof Pawn) {
			if(((Pawn)board[from[1]][from[0]]).verifyMove(board, from, to) &&
				checkPieceConflict(from, to))
			return true;
		} else { 
			if(board[from[1]][from[0]].verifyMove(from, to) &&
				checkPieceConflict(from, to))
			return true;
		}
		return false;
	}
	/**
	 * Checks that the move does not conflict with pieces in the way during the move.
	 * This includes:
	 * - own pieces in the way
	 * - opponents pieces in the way (unless piece is being taken) 
	 * @return true if there is no piece conflict
	 */
	public boolean checkPieceConflict(int[] from, int[] to) {
		// check if moving onto own piece
		if(board[to[1]][to[0]] != null && 
				board[from[1]][from[0]].getPlayer().equals(board[to[1]][to[0]].getPlayer()))
			return false;
		// check if there's anything in the way of the move 
		if(!(board[from[1]][from[0]] instanceof Knight)) {
			for(int move=1;move<Math.max(Math.abs(to[0]-from[0]),Math.abs(to[1]-from[1]));move++) {
				int rowMod = move*(to[1]>from[1] ? 1 : (from[1]>to[1] ? -1 : 0));
				int colMod = move*(to[0]>from[0] ? 1 : (from[0]>to[0] ? -1 : 0));
				if(!(to[1]==from[1] && to[0]==from[0]) &&
						board[from[1]+rowMod][from[0]+colMod] != null)
					return false;
			}
		} 
		return true;
	}
	public void outputBoard() {
		for(int row=0;row<8;row++) {
			for(int col=0;col<8;col++) {
				System.out.format("%4s-", (board[row][col]==null) ? "" : board[row][col].toString());
			}
			System.out.println();
		}
	}
}
