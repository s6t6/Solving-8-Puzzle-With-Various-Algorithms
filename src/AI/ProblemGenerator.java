package AI;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ProblemGenerator {

	
	static Problem generate() {
		
		Problem p = new Problem();
		Set<Integer> check = new HashSet<Integer>();
		int j = 0, i = 0;
		
		while (i < 3) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 9);
			
			if (!check.contains(randomNum)) {
				p.initial.board[i][j] = randomNum;
				check.add(randomNum);
				if (randomNum == 0) {
					p.initial.x = i;
					p.initial.y = j;
				}
				j++;
				
				if (j == 3) {
					j = 0;
					i++;
				}
			}
		}
		
		j = 0;
		i = 0;
		check.clear();
		while (i < 3) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, 9);
			
			if (!check.contains(randomNum)) {
				p.goal.board[i][j] = randomNum;
				check.add(randomNum);
				if (randomNum == 0) {
					p.goal.x = i;
					p.goal.y = j;
				}
				j++;
				
				if (j == 3) {
					j = 0;
					i++;
				}
			}
		}
		return p;
	}
	
}
