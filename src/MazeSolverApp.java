package mazesolver;

import java.lang.StringBuilder; //StringBuilder
import java.util.Scanner; //Scanner
import java.util.Arrays; //ZZZ Arrays.deepToString
import mazesolver.MazeSolver; //solveMaze



public class MazeSolverApp {
	static int x_max, y_max, x_sta, y_sta, x_end, y_end;
	static int[][] maze_array;


	//Delete this later.
	public static void main(String[] args) {
		handleInput();
		System.out.println(mazeToString(maze_array));
		int[][] maze_sol = MazeSolver.solveMaze(maze_array, x_sta, y_sta, x_end, y_end);
		System.out.println(mazeToString(maze_sol));
		

	}
	
	//this is assuming input is perfect as specified.
	private static void handleInput() {
		Scanner input = new Scanner(System.in);

		x_max = input.nextInt(); y_max = input.nextInt(); //input line 1
		x_sta = input.nextInt(); y_sta = input.nextInt(); //input line 2
		x_end = input.nextInt(); y_end = input.nextInt(); //input line 3
		maze_array = new int[y_max][x_max];
		//System.out.println(x_max + ", " + y_max + "\n" + x_sta + ", " + y_sta + "\n" +  x_end +", " + y_end); //ZZZ
		
		Scanner line = new Scanner(input.nextLine());
		for (int i=0; input.hasNextLine(); i++) {
			line = new Scanner(input.nextLine());
			for (int j=0; line.hasNextInt(); j++) {
				maze_array[j][i] = line.nextInt();
			}
		}
		//System.out.println(Arrays.deepToString(maze_array)); //ZZZ 
		//System.out.println(Arrays.deepToString(maze_array)); //ZZZ 
		input.close();	
	}
	
	private static String mazeToString(int[][] maze) {
		StringBuilder myString = new StringBuilder();
		for (int x=0; x < maze.length; x++) {
			for (int y=0; y < maze.length; y++) {
				if (maze[y][x] == 2) {
					myString.append("S");
				} else if (maze[y][x] == 3) {
					 myString.append("X");
				} else if (maze[y][x] == 1) {
					myString.append("#");
				} else {
					myString.append(" ");
				}
			} //end for y
			myString.append("\n");
		}
		return myString.toString();
	}
	

}
