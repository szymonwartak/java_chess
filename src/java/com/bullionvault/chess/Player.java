package com.bullionvault.chess;

import com.bullionvault.chess.piece.Colour;

public class Player {
	private String name;
	private Colour colour;

	public Player(String name, Colour colour) {
		this.name = name;
		this.colour = colour;
	}
	
	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
