package com.bullionvault.chess.piece;

import com.bullionvault.chess.Player;

public class Queen extends Piece {

	public Queen(Player player) {
		super(player);

	}
	public String toString() {
		return super.toString() + "Q";
	}
	public boolean verifyMove(int[] from, int[] to) {
		if(super.verifyMove(from, to) &&
				(Math.abs(from[0]-to[0]) == Math.abs(from[1]-to[1]) ||
					(from[0]-to[0]!=0 && from[1]-to[1]==0) ||
					(from[0]-to[0]==0 && from[1]-to[1]!=0)))
			return true;
		return false;
	}
}
