package com.bullionvault.chess.piece;

public enum Colour {

	BLACK("B"),
	WHITE("W");
	private String description;
	private Colour(String description) {
		this.description = description;
	}
	public String toString() { return description; }
}
