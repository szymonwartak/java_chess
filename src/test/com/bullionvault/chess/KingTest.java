package com.bullionvault.chess;

import static org.junit.Assert.*;

import org.junit.*;


public class KingTest {

	ChessGame game;
	
	@Before public void setup() {
		game = new ChessGame();
		game.processMove(new int[]{4,1}, new int[]{4,2});
		game.processMove(new int[]{3,1}, new int[]{3,2});
		game.outputBoard();
	}
	
	@Test public void testKingLegal() {
		assertTrue(game.isLegalMove(new int[]{3,0}, new int[]{4,1}));
		assertTrue(game.isLegalMove(new int[]{3,0}, new int[]{3,1}));
	}

	@Test public void testKingIllegal() {
		assertFalse(game.isLegalMove(new int[]{3,0}, new int[]{3,0}));
		assertFalse(game.isLegalMove(new int[]{3,0}, new int[]{4,0}));
		assertFalse(game.isLegalMove(new int[]{3,0}, new int[]{5,0}));
	}
}
