package com.bullionvault.chess;

import static org.junit.Assert.*;

import org.junit.*;


public class PawnTest {

	ChessGame game;
	
	@Before public void setup() {
		game = new ChessGame();
		game.outputBoard();
	}
	
	@Test public void testPawnMoves() {
		assertFalse(game.processMove(new int[]{1,6}, new int[]{2,5}));
		assertTrue(game.processMove(new int[]{1,6}, new int[]{1,5}));
		assertTrue(game.processMove(new int[]{1,1}, new int[]{1,2}));
		assertTrue(game.processMove(new int[]{2,6}, new int[]{2,4}));
		assertTrue(game.processMove(new int[]{1,2}, new int[]{1,3}));
		assertFalse(game.processMove(new int[]{2,4}, new int[]{3,3}));
		assertFalse(game.processMove(new int[]{2,4}, new int[]{2,2}));
		assertTrue(game.processMove(new int[]{2,4}, new int[]{1,3}));
	}
	
	@After public void finalState() {
		game.outputBoard();
	}

}
