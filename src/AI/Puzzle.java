package AI;
import java.util.*;

public class Puzzle {
	
	public int[][] board = new int[3][3];
	public int x, y, depth = 0;
	public Puzzle parent = null;
	
	
	public Puzzle() {
		
	}
	
	public Puzzle(Puzzle puzzle) {
		this.x = puzzle.x;
		this.y = puzzle.y;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.board[i][j] = puzzle.board[i][j];
			}
		}
	}

	
	public void print() {
		System.out.println("*************************");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("*************************");
		System.out.println();
	}
	
	public void print(String s) {
		System.out.println("************"+ s +"*************");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("*************************");
		System.out.println();
	}
	
	Puzzle moveRight(Puzzle p) {
		Puzzle result = new Puzzle(p);
		int temp = result.board[result.x][result.y];
		result.board[result.x][result.y] = result.board[result.x][result.y + 1];
		result.board[result.x][result.y + 1] = temp;
		result.y = y+1;
		return result;
	}
	Puzzle moveLeft(Puzzle p) {
		Puzzle result = new Puzzle(p);
		int temp = result.board[result.x][result.y];
		result.board[result.x][result.y] = result.board[result.x][result.y - 1];
		result.board[result.x][result.y - 1] = temp;
		result.y = y - 1;
		return result;
	}
	Puzzle moveUp(Puzzle p) {
		Puzzle result = new Puzzle(p);
		int temp = result.board[result.x][result.y];
		result.board[result.x][result.y] = result.board[result.x - 1][result.y];
		result.board[result.x - 1][result.y] = temp;
		result.x = x - 1;
		return result;
	}
	Puzzle moveDown(Puzzle p) {
		Puzzle result = new Puzzle(p);
		int temp = result.board[result.x][result.y];
		result.board[result.x][result.y] = result.board[result.x + 1][result.y];
		result.board[result.x + 1][result.y] = temp;
		result.x = x + 1;
		return result;
	}
	public ArrayList<Puzzle> child() {
		ArrayList<Puzzle> result = new ArrayList<Puzzle>();
		int i = this.x, j = this.y;

		if (i == 0) {
			if (j == 0) {
				result.add(moveRight(this));
				result.add(moveDown(this));
			}
			else if (j == 1) {
				result.add(moveRight(this));
				result.add(moveLeft(this));
				result.add(moveDown(this));
			}
			else {

				result.add(moveLeft(this));
				result.add(moveDown(this));
			}
		}
		else if (i == 1) {
			if (j == 0) {
				result.add(moveRight(this));
				result.add(moveUp(this));
				result.add(moveDown(this));
			}
			else if (j == 1) {
				result.add(moveRight(this));
				result.add(moveLeft(this));
				result.add(moveUp(this));
				result.add(moveDown(this));
			}
			else {

				result.add(moveLeft(this));
				result.add(moveUp(this));
				result.add(moveDown(this));
			}
		}

		else {
			if (j == 0) {
				result.add(moveRight(this));
				result.add(moveUp(this));
			}
			else if (j == 1) {
				result.add(moveRight(this));
				result.add(moveLeft(this));
				result.add(moveUp(this));
			}
			else {
				result.add(moveLeft(this));
				result.add(moveUp(this));
			}
		}

		return result;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puzzle other = (Puzzle) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != other.board[i][j])
					return false;
			}
		}
		return true;
	}
}
