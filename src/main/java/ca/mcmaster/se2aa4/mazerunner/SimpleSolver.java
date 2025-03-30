package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import ca.mcmaster.se2aa4.mazerunner.MazeRunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.Solver.MazeExplorer;

public class SimpleSolver {
     public static class SimpleMazeExplorer extends MazeExplorer {

        public SimpleMazeExplorer(Maze maze) {
            super(maze);
        }

        @Override
        protected void makeNextMove() {
            turnRight();
            if (maze.isWalkable(nextPosition())) {
                moveForward();
            } else {
                turnLeft(); // undo right
                if (maze.isWalkable(nextPosition())) {
                    moveForward();
                } else {
                    turnLeft();
                    if (maze.isWalkable(nextPosition())) {
                        moveForward();
                    } else {
                        // 180-degree turn
                        turnRight(); // undo left
                        turnRight();
                        turnRight();
                    }
                }
            }
        }


        public Boolean isValidPath(FormatPath path){
            // Reset position and orientation
            this.position = maze.getEntry().clone();
            this.orientation = 'E';
            this.path.clear();  // Clear any previous path history

            try {
                PathExecutor.execute(path, this);
                return Arrays.equals(this.position, maze.getExit());
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        
        private int[] nextPosition() {
            int row = position[0];
            int col = position[1];
            switch (orientation) {
                case 'N': row--; break;
                case 'E': col++; break;
                case 'S': row++; break;
                case 'W': col--; break;
            }
            return new int[]{row, col};
        }
        
    }
}
