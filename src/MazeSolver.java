package mazesolver;


/**
* This class takes a maze and starting/end position and tries to find a solution.
*
* @author Cameron Milsom
*/
public class MazeSolver {
	
	/**
	* Takes an array of the specified maze format and attempts to find the end from the start.
	* 0 - Free space, 1 - Blocked space, 2 - Starting position, 3 - Traversed position, 4 - Ending position.
	* 
	* @param maze_array - an array designed to be a maze
	* @param staX Starting X position
	* @param staY Starting Y position
	* @param endX Goal X position
	* @param endY Goal Y position
	* @return Returns a modified array that represents a solution to the exit
	*/
	public static int[][] solveMaze(int[][] maze_array,int staX, int staY, int endX, int endY) {
		int[][] maze_sol = maze_array.clone();
		maze_sol[staY][staX] = 2; //2 meaning Start.
		
		if (trySolveMaze(maze_sol, staX, staY, endX, endY)) return maze_sol;

		return maze_array; //No solution
	}
	
	/**
	* Attempts to solve a maze from the starting values to the ending values.
	* This uses a backtracking algorithm to fall back if it reaches a fail state
	*/
	private static boolean trySolveMaze(int[][] maze_array,int currX, int currY, int endX, int endY) {
		if (currX == endX && currY == endY) {
			maze_array[currY][currX] = 4; //4 Meaning End.
			return true; //We have reached the end
		}
		
		
		//Try North
		int tempY = currY-1; int tempX = currX;
		if (tempY >= 0 && maze_array[tempY][tempX] == 0) {
			maze_array[tempY][tempX] = 3; //3 Meaning X
			if (trySolveMaze(maze_array, tempX, tempY, endX, endY)) return true; //Solved
			maze_array[tempY][tempX] = 0; //Failed, return to previous state
		}
		
		//Try East
		tempY = currY; tempX = currX+1;
		if (tempX < maze_array[tempY].length && maze_array[tempY][tempX] == 0) {
			maze_array[tempY][tempX] = 3; //3 Meaning X
			if (trySolveMaze(maze_array, tempX, tempY, endX, endY)) return true; //Solved
			maze_array[tempY][tempX] = 0; //Failed, return to previous state
		}
		
		//Try South
		tempY = currY+1; tempX = currX;
		if (tempY < maze_array.length && maze_array[tempY][tempX] == 0) {
			maze_array[tempY][tempX] = 3;
			if (trySolveMaze(maze_array, tempX, tempY, endX, endY)) return true; //Solved
			maze_array[tempY][tempX] = 0; //Failed, return to previous state
		}
		
		//Try West
		tempY = currY; tempX = currX-1;
		if (tempX >= 0 && maze_array[tempY][tempX] == 0) {
			maze_array[tempY][tempX] = 3;
			if (trySolveMaze(maze_array, tempX, tempY, endX, endY)) return true; //Solved
			maze_array[tempY][tempX] = 0; //Failed, return to previous state
		}
		
		return false; //No valid movements, Failed at this location
	}
	
	
	

} //end class



