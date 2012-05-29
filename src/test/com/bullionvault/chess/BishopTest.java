package com.bullionvault.chess;

import static org.junit.Assert.*;

import org.junit.*;


public class BishopTest {

	ChessGame game;
	
	@Before public void setup() {
		game = new ChessGame();
		game.processMove(new int[]{6,1}, new int[]{6,2});
		game.outputBoard();
	}
	
	@Test public void testBishopLegal() {
		assertTrue(game.isLegalMove(new int[]{5,0}, new int[]{6,1}));
		assertTrue(game.isLegalMove(new int[]{5,0}, new int[]{7,2}));
		
	}

	@Test public void testBishopIllegal() {
		assertFalse(game.isLegalMove(new int[]{5,0}, new int[]{6,2}));
		assertFalse(game.isLegalMove(new int[]{5,0}, new int[]{5,0}));
		assertFalse(game.isLegalMove(new int[]{5,0}, new int[]{4,1}));
		assertFalse(game.isLegalMove(new int[]{5,0}, new int[]{3,2}));
		assertFalse(game.isLegalMove(new int[]{5,0}, new int[]{3,0}));
	}
}
