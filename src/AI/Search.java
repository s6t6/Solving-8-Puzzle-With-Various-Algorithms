package AI;
import java.util.*;

public class Search {
	
	static public Solution bfs(Puzzle initial, Puzzle goal) {
		
		Solution result = new Solution();
		Set<Puzzle> seen = new HashSet<Puzzle>();
		Set<Puzzle> fringeSet = new HashSet<Puzzle>();
		Queue<Puzzle> fringe = new LinkedList<Puzzle>();
		Puzzle current = null;
		int maxFringeSize = 0;
		int nodesExpanded = 0;
		
		fringe.add(initial);
		fringeSet.add(initial);
		
		while (fringe.size() > 0) {
			current = fringe.peek();
			seen.add(current);
			if (current.equals(goal)) {
				break;
			}
			else {
				nodesExpanded++;
				current.child().forEach( n ->
						{	
							if (!seen.contains(n) && !fringeSet.contains(n)) {
								n.parent = fringe.peek();
								fringe.add(n);
								fringeSet.add(n);
								
							}
						}
					);
			}
			fringe.remove();
			if (fringe.size() > maxFringeSize) {
				maxFringeSize = fringe.size();
			}
		}
		if (current.equals(goal)) {
			result.isSuccessful = true;
			while (current != null) {
				result.list.add(current);
				current = current.parent;
			}
		}
		
		result.fringeMaxSize = maxFringeSize;
		result.nodesExpanded = nodesExpanded;
		return result;
	}

	static public Solution dfs(Puzzle initial, Puzzle goal) {
		Solution result = new Solution();
		Set<Puzzle> seen = new HashSet<Puzzle>();
		Set<Puzzle> fringeSet = new HashSet<Puzzle>();
		ArrayList<Puzzle> fringe = new ArrayList<Puzzle>();
		Puzzle current = null;
		int maxFringeSize = 0;
		int nodesExpanded = 0;
		
		fringe.add(initial);
		fringeSet.add(initial);
		
		while (fringe.size() > 0) {
			current = fringe.getLast();
			seen.add(current);
			if (current.equals(goal)) {
				break;
			}
			else {
				nodesExpanded++;
				current.child().reversed().forEach( n ->
						{	
							if (!seen.contains(n) && !fringeSet.contains(n)) {
								n.parent = fringe.getLast();
								fringe.add(n);
								fringeSet.add(n);
								
							}
						}
					);
			}
			fringe.remove(current);
			if (fringe.size() > maxFringeSize) {
				maxFringeSize = fringe.size();
			}
		}
		if (current.equals(goal)) {
			result.isSuccessful = true;
			while (current != null) {
				result.list.add(current);
				current = current.parent;
			}
		}
		
		result.fringeMaxSize = maxFringeSize;
		result.nodesExpanded = nodesExpanded;
		return result;
	}

	static public Solution dldfs(Puzzle initial, Puzzle goal, int limit) {
		
		Solution result = new Solution();
		Set<Puzzle> seen = new HashSet<Puzzle>();
		Set<Puzzle> fringeSet = new HashSet<Puzzle>();
		ArrayList<Puzzle> fringe = new ArrayList<Puzzle>();
		Puzzle current = null;
		int maxFringeSize = 0;
		int nodesExpanded = 0;
		
		fringe.add(initial);
		fringeSet.add(initial);
		
		while (fringe.size() > 0) {
			current = fringe.getLast();
			seen.add(current);
			if (current.equals(goal)) {
				break;
			}
			else if(current.depth < limit) {
				nodesExpanded++;
				current.child().reversed().forEach( n ->
						{	
							if (!seen.contains(n) && !fringeSet.contains(n)) {
								n.parent = fringe.getLast();
								n.depth = fringe.getLast().depth + 1;
								fringe.add(n);
								fringeSet.add(n);
								
							}
						}
					);
			}
			fringe.remove(current);
			if (fringe.size() > maxFringeSize) {
				maxFringeSize = fringe.size();
			}
		}
		if (current.equals(goal)) {
			result.isSuccessful = true;
			while (current != null) {
				result.list.add(current);
				current = current.parent;
			}
		}
		
		result.fringeMaxSize = maxFringeSize;
		result.nodesExpanded = nodesExpanded;
		return result;
	}

	static public Solution idls(Puzzle initial, Puzzle goal) {
		
		Solution s = dldfs(initial, goal, 0);
		
		int limit = 1;
		while (!s.isSuccessful) {
			s = dldfs(initial, goal, limit);
			limit++;
		}
		s.depth = limit;
		return s;
	}
}


