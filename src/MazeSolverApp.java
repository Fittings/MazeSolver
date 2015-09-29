package mazesolver;
import java.lang.StringBuilder; //StringBuilder
import java.util.Scanner; //Scanner
import mazesolver.MazeSolver; //solveMaze

/**
* This is the application class that runs the MazeSolver.
* Runs this and give it a specified file to find a solution to a maze.
*
* @author Cameron Milsom
*/
public class MazeSolverApp {
	static int x_max, y_max, x_sta, y_sta, x_end, y_end;
	static int[][] maze_array;

	/**
	* Takes puzzle input from user input at command line and tries to solve it.
	* @param args Not used
	*/
	public static void main(String[] args) {
		handleInput();
		int[][] maze_sol = MazeSolver.solveMaze(maze_array, x_sta, y_sta, x_end, y_end);
		System.out.println(mazeToString(maze_sol));
	}
	
	/**
	* Takes input from user input at command line. 
	* This assumes the user input is perfectly clean to the specifications as there is no validation.
	*/
	private static void handleInput() {
		Scanner input = new Scanner(System.in);

		x_max = input.nextInt(); y_max = input.nextInt(); //input line 1
		x_sta = input.nextInt(); y_sta = input.nextInt(); //input line 2
		x_end = input.nextInt(); y_end = input.nextInt(); //input line 3
		maze_array = new int[y_max][x_max];
		
		Scanner line = new Scanner(input.nextLine());
		for (int i=0; input.hasNextLine(); i++) {
			line = new Scanner(input.nextLine());
			for (int j=0; line.hasNextInt(); j++) {
				maze_array[j][i] = line.nextInt();
			}
		}
		input.close();	
	}
	
	/** 
	* Converts the solution to a String output that is more understandable.
	* 'S' - Starting position, 'X' - Traversed path, '#' - Maze Wall, ' ' - Free Space 
	*/
	private static String mazeToString(int[][] maze) {
		StringBuilder myString = new StringBuilder();
		for (int x=0; x < maze[0].length; x++) {
			for (int y=0; y < maze.length; y++) {
				if (maze[y][x] == 2) {
					myString.append("S");
				} else if (maze[y][x] == 3) {
					 myString.append("X");
				} else if (maze[y][x] == 1) {
					myString.append("#");
				} else if (maze[y][x] == 4) {
					myString.append("E");
				} else {
					myString.append(" ");
				}
			}
			myString.append("\n");
		}
		return myString.toString();
	}


} //end class
