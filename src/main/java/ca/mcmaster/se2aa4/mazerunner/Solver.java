package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ca.mcmaster.se2aa4.mazerunner.MazeRunner.Maze;
public class Solver {
        // Abstract MazeExplorer class
    public static abstract class MazeExplorer {
        protected Maze maze;
        protected int[] position;
        protected char orientation;
        protected List<Character> path;

        // Constructor
        public MazeExplorer(Maze maze) {
            this.maze = maze;
            this.position = maze.getEntry();
            this.orientation = 'S'; // Start facing South
            this.path = new ArrayList<>();
        }

        // Abstract method to define exploration strategy
        public abstract void explore();

        // Helper methods for movement
        public void moveForward() {
            int row = position[0];
            int col = position[1];

            switch (orientation) {
                case 'N': row--; break;
                case 'E': col++; break;
                case 'S': row++; break;
                case 'W': col--; break;
            }

            if (maze.isWalkable(row, col)) {
                position[0] = row;
                position[1] = col;
                path.add('F');
            } else {
                throw new IllegalArgumentException("Cannot move forward into a wall");
            }
        }

        public void turnLeft() {
            orientation = Maze.DIRECTIONS[(getDirectionIndex() + 3) % 4]; // Counterclockwise
            path.add('L');
        }

        public void turnRight() {
            orientation = Maze.DIRECTIONS[(getDirectionIndex() + 1) % 4]; // Clockwise
            path.add('R');
        }

        private int getDirectionIndex() {
            for (int i = 0; i < Maze.DIRECTIONS.length; i++) {
                if (Maze.DIRECTIONS[i] == orientation) {
                    return i;
                }
            }
            throw new IllegalStateException("Invalid orientation");
        }

        public List<Character> getPath() {
            return path;
        }

        public int[] getPosition() {
            return position;
        }
    }  
}
