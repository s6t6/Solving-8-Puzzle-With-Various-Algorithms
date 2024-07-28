package AI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		
		
		Puzzle p1 = new Puzzle();
		Puzzle p2 = new Puzzle();
		Problem problem = ProblemGenerator.generate();

		/*
		  problem.initial.board[0][0] = 3; problem.initial.board[0][1] = 8;
		  problem.initial.board[0][2] = 2; problem.initial.board[1][0] = 4;
		  problem.initial.board[1][1] = 0; problem.initial.board[1][2] = 5;
		  problem.initial.board[2][0] = 6; problem.initial.board[2][1] = 7;
		  problem.initial.board[2][2] = 1; problem.initial.x = 1; problem.initial.y = 1;
		  
		  problem.goal.board[0][0] = 7; problem.goal.board[0][1] = 0;
		  problem.goal.board[0][2] = 6; problem.goal.board[1][0] = 8;
		  problem.goal.board[1][1] = 5; problem.goal.board[1][2] = 1;
		  problem.goal.board[2][0] = 4; problem.goal.board[2][1] = 3;
		  problem.goal.board[2][2] = 2; problem.goal.x = 0; problem.goal.y = 1;
		 */
		
		problem.goal.print("GOAL");
		problem.initial.print("INITIAL");
		
		long startingTime = System.currentTimeMillis();
		Solution s = Search.dldfs(problem.initial, problem.goal,50);
		long endingTime = System.currentTimeMillis();
		
		s.print();
		System.out.println("Time taken: " + (((endingTime - startingTime)/1000)/60) + 
				" minutes " + (((endingTime - startingTime)/1000)%60) + " seconds");
	}

}
