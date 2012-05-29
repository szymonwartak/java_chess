package com.bullionvault.chess;

import java.io.*;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserInput input = new UserInputFile(new File("input.txt"));
		
		ChessGame game = new ChessGame();
		game.outputBoard();
		
		int[] from = new int[2];
		int[] to= new int[2];
		while(input.nextMove(from, to)) {
			game.processMove(from, to);
		}
		game.outputBoard();
	}

}
