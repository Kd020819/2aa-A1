package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

import ca.mcmaster.se2aa4.mazerunner.MazeRunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Solver.MazeExplorer;

public class SimpleSolver {
     public static class SimpleMazeExplorer extends MazeExplorer {

        public SimpleMazeExplorer(Maze maze) {
            super(maze);
        }

        @Override
        public void explore() {
            // Simple strategy: Keep moving forward and turn right if blocked
            while (!Arrays.equals(position, maze.getExit())) {
                try {
                    moveForward();
                } catch (IllegalArgumentException e) {
                    turnRight();
                }
            }
        }
    }
}
