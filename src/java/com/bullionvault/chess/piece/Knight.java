package com.bullionvault.chess.piece;

import com.bullionvault.chess.Player;

public class Knight extends Piece {

	public Knight(Player player) {
		super(player);
	}
	public String toString() {
		return super.toString() + "N";
	}
	public boolean verifyMove(int[] from, int[] to) {
		if(super.verifyMove(from, to) &&
				(Math.abs(from[0]-to[0]) == 2 && Math.abs(from[1]-to[1]) == 1) ||
				(Math.abs(from[0]-to[0]) == 1 && Math.abs(from[1]-to[1]) == 2))
			return true;
		return false;
	}
}
