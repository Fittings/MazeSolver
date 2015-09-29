
package mazesolver;



public class MazeSolver {
	static int counter; //ZZZ
	
	public static int[][] solveMaze(int[][] maze_array,int staX, int staY, int endX, int endY) {
		counter = 0; //ZZZ
		int[][] maze_sol = maze_array.clone();
		maze_sol[staY][staX] = 2; //2 meaning Start.
		if (trySolveMaze(maze_sol, staX, staY, endX, endY)) {
			return maze_sol;
		}
		return maze_array; //No solution
	}
	
	//Lets do this using backtracking~!
	public static boolean trySolveMaze(int[][] maze_array,int currX, int currY, int endX, int endY) {
		System.out.println("Counter: " + counter++);
		if (currX == endX && currY == endY) return true; //We have reached the end.
		int tempX = currX, tempY = currY;
		//Try North, try East, Try South, Try West
		
		//North
		tempY = currY-1; tempX = currX;
		if (tempY >= 0 && maze_array[tempY][tempX] == 0) {
			maze_array[tempY][tempX] = 3; //3 Meaning X
			if (trySolveMaze(maze_array, tempX, tempY, endX, endY)) return true; //Solved
		}
		
		//East
		tempY = currY; tempX = currX+1;
		if (tempX < maze_array[tempY].length && maze_array[tempY][tempX] == 0) {
			maze_array[tempY][tempX] = 3; //3 Meaning X
			if (trySolveMaze(maze_array, tempX, tempY, endX, endY)) return true; //Solved
		}
		
		//South
		tempY = currY+1; tempX = currX;
		if (tempY < maze_array.length && maze_array[tempY][tempX] == 0) {
			maze_array[tempY][tempX] = 3;
			if (trySolveMaze(maze_array, tempX, tempY, endX, endY)) return true; //Solved
		}
		
		//West
		tempY = currY; tempX = currX-1;
		if (tempX >= 0 && maze_array[tempY][tempX] == 0) {
			maze_array[tempY][tempX] = 3;
			if (trySolveMaze(maze_array, tempX, tempY, endX, endY)) return true; //Solved
		}
		
		return false; //No movements for this iteration
	}
	
	
	

}



