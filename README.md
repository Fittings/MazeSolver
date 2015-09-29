#Maze Solver
This is my MazeSolver solution. This works by using a backtracking algorithm to go through the possibilities.

#How To Use:
Redirect the maze file to the program. Or just enter manually.

command line:
java mazesolver.MazeSolverApp < file

working example: (from *\MazeSolver\)
java mazesolver.MazeSolverApp < ".\input\input.txt"


#Maze file format


The input is a maze description file in plain text.  
 1 - denotes walls
 0 - traversable passage way

INPUT:
<HEIGHT> <WIDTH><CR>
<START_I> <START_J><CR>		(i,j) location of the start. (0,0) is upper left and (height-1,width-1) is lower right
<END_I> <END_J><CR>		(i,j) location of the end
<HEIGHT> rows where each row has <WIDTH> {0,1} integers space delimited

OUTPUT:
 the maze with a path from start to end
 walls marked by '#', passages marked by ' ', path marked by 'X', start/end marked by 'S'/'E'

Example file:  
10 10
1 1
8 8
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 1 0 1 1 1 1 1 1
1 0 1 0 0 0 0 0 0 1
1 0 1 1 0 1 0 1 1 1
1 0 1 0 0 1 0 1 0 1
1 0 1 0 0 0 0 0 0 1
1 0 1 1 1 0 1 1 1 1
1 0 1 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1