package AI;

import java.util.ArrayList;

public class Solution {
	public ArrayList<Puzzle> list = new ArrayList<Puzzle>();
	public boolean isSuccessful = false;
	public int fringeMaxSize;
	public int nodesExpanded;
	public int depth;
	
	public void print() {
		list.forEach(e -> {
			System.out.println("////////////////////////");
			e.print();
			System.out.println("////////////////////////");
		});
		
		System.out.println();
		System.out.println();
		System.out.println("Max fringe size: " + fringeMaxSize  + 
				" Number of nodes expanded: " + nodesExpanded +
				" Solution found: " + isSuccessful);
		if (depth != 0) {
			System.out.println("Solution foun on the " + depth + " depth iteration");
		}
	}
}
