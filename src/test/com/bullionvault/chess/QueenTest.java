package com.bullionvault.chess;

import static org.junit.Assert.*;

import org.junit.*;


public class QueenTest {

	ChessGame game;
	
	@Before public void setup() {
		game = new ChessGame();
		game.processMove(new int[]{4,1}, new int[]{4,3});
		game.processMove(new int[]{5,1}, new int[]{5,3});
		game.outputBoard();
	}
	
	@Test public void testQueenLegal() {
		assertTrue(game.isLegalMove(new int[]{4,0}, new int[]{4,2}));
		assertTrue(game.isLegalMove(new int[]{4,0}, new int[]{7,3}));
	}

	@Test public void testQueenIllegal() {
		assertFalse(game.isLegalMove(new int[]{4,0}, new int[]{3,1}));
		assertFalse(game.isLegalMove(new int[]{4,0}, new int[]{1,3}));
		assertFalse(game.isLegalMove(new int[]{4,0}, new int[]{4,6}));
		assertFalse(game.isLegalMove(new int[]{4,0}, new int[]{3,2}));
	}
}
