package com.bullionvault.chess;

import static org.junit.Assert.*;

import org.junit.*;


public class KnightTest {

	ChessGame game;
	
	@Before public void setup() {
		game = new ChessGame();
		game.outputBoard();
	}
	
	@Test public void testKnightLegal() {
		assertTrue(game.isLegalMove(new int[]{6,0}, new int[]{5,2}));
		assertTrue(game.isLegalMove(new int[]{6,0}, new int[]{7,2}));
	}

	@Test public void testKnightIllegal() {
		assertFalse(game.isLegalMove(new int[]{6,0}, new int[]{4,1}));
		assertFalse(game.isLegalMove(new int[]{6,0}, new int[]{8,1}));
		assertFalse(game.isLegalMove(new int[]{6,0}, new int[]{3,1}));
	}
}
