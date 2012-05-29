package com.bullionvault.chess.piece;

import com.bullionvault.chess.Player;

public class Piece {
	private Player player;
	
	public Piece(Player player) {
		this.player = player;
	}
	public String toString() {
		return player.getName();
	}
	public boolean verifyMove(int[] from, int[] to) {
		if(from[0]>=0 && from[0]<8 &&
				from[1]>=0 && from[1]<8 &&
				to[0]>=0 && to[0]<8 &&
				to[1]>=0 && to[1]<8 &&
				!(from[0]==to[0] && from[1]==to[1])) // check that the piece has actually moved
			return true;
		return false;
	}
	public Player getPlayer() { return player; }
}
