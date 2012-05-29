package com.bullionvault.chess.piece;

import com.bullionvault.chess.Player;

public class Rook extends Piece {

	public Rook(Player player) {
		super(player);

	}
	public String toString() {
		return super.toString() + "R";
	}
	public boolean verifyMove(int[] from, int[] to) {
		if(super.verifyMove(from, to) &&
				(from[0]-to[0]!=0 && from[1]-to[1]==0) ||
				(from[0]-to[0]==0 && from[1]-to[1]!=0))
			return true;
		return false;
	}
}
