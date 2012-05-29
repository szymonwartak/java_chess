package com.bullionvault.chess.piece;

import com.bullionvault.chess.Player;
import com.bullionvault.chess.piece.Piece;

public class Bishop extends Piece {

	public Bishop(Player player) {
		super(player);
	}
	public String toString() {
		return super.toString() + "B";
	}
	public boolean verifyMove(int[] from, int[] to) {
		if(super.verifyMove(from, to) &&
				Math.abs(from[0]-to[0]) == Math.abs(from[1]-to[1]))
			return true;
		return false;
	}
}
