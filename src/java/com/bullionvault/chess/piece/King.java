package com.bullionvault.chess.piece;

import com.bullionvault.chess.Player;

public class King extends Piece {

	public King(Player player) {
		super(player);
	}
	public String toString() {
		return super.toString() + "K";
	}
	public boolean verifyMove(int[] from, int[] to) {
		if(super.verifyMove(from, to) &&
				(Math.abs(from[0]-to[0])==1 ||
				Math.abs(from[1]-to[1])==1))
			return true;
		return false;
	}
}
