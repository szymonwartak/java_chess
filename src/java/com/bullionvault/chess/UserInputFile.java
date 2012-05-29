package com.bullionvault.chess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class UserInputFile implements UserInput {
	String nextMoveBuffer = "";
	Queue<String> queue = new LinkedList<String>();
	
	public UserInputFile(File file) {
		try {
			BufferedReader r = new BufferedReader(new FileReader(file));
			String moves = "";
			while((moves = r.readLine()) != null) {
				queue.addAll(Arrays.asList(moves.split(" ")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void printAll () {
		while(queue.peek() != null)
			System.out.println(queue.poll());
	}
	public boolean nextMove(int[] from, int[] to) {
		String next = queue.poll();
		if(next == null) {
			return false;
		} else {
			from[0] = rowToInt(next.substring(0, 1));
			from[1] = new Integer(next.substring(1, 2))-1;
			to[0] = rowToInt(next.substring(2, 3));
			to[1] = new Integer(next.substring(3, 4))-1;
		}
		return true;
	}
	private int rowToInt(String row) {
		switch(row.charAt(0)) {
		case 'a': return 0;
		case 'b': return 1;
		case 'c': return 2;
		case 'd': return 3;
		case 'e': return 4;
		case 'f': return 5;
		case 'g': return 6;
		case 'h': return 7;
		}
		return -1;
	}
}
