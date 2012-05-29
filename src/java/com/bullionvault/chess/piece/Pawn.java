package com.bullionvault.chess.piece;

import com.bullionvault.chess.Player;

public class Pawn extends Piece {

	public Pawn(Player player) {
		super(player);
	}
	public String toString() {
		return super.toString() + "P";
	}
	public boolean verifyMove(Piece[][] board, int[] from, int[] to) {
		if(super.verifyMove(from, to) &&
				(board[from[1]][from[0]].getPlayer().getColour().equals(Colour.WHITE) && 
				 		(board[to[1]][to[0]]==null && from[1]==6 && to[1]==4 || // starting double up
						 		board[to[1]][to[0]]==null && to[1]-from[1]==-1 && from[0]==to[0] || // one up
						 		board[to[1]][to[0]]!=null && to[1]-from[1]==-1 && Math.abs(to[0]-from[0])==1) // taking a piece
				 || board[from[1]][from[0]].getPlayer().getColour().equals(Colour.BLACK) && 
				 		(board[to[1]][to[0]]==null && from[1]==1 && to[1]==3 || // starting double up
				 		board[to[1]][to[0]]==null && to[1]-from[1]==1 && from[0]==to[0] || // one up
				 		board[to[1]][to[0]]!=null && to[1]-from[1]==1 && Math.abs(to[0]-from[0])==1))) // taking a piece
			return true;
		return false;
	}
}
