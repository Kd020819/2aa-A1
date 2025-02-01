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
            this.orientation = 'E'; // Start facing East
            this.path = new ArrayList<>();
        }

        // Abstract method to define exploration strategy
        public abstract void explore();
        public abstract Boolean isValidPath(FormatPath path);

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

            if (maze.isWalkable(position)) {
                position[0] = row;
                position[1] = col;
                path.add('F');
                
                
                //System.out.println("Move forward");
            } else {
                //System.out.println("Cannot Move forward");
                throw new IllegalArgumentException("Cannot move forward into a wall");
            }
        }

        public void turnRight() {
            switch (orientation) {
                case 'N' -> {
                    orientation = 'E';
                }
                case 'S' -> {
                    orientation = 'W';
                }
                case 'W' -> {
                    orientation = 'N';
                }
                case 'E' -> {
                    orientation = 'S';
                }
            }
            path.add('R');

        }

        public void turnLeft() {
            
            switch (orientation) {
                case 'N' -> {
                    orientation = 'W';
                }
                case 'S' -> {
                    orientation = 'E';
                }
                case 'W' -> {
                    orientation = 'S';
                }
                case 'E' -> {
                    orientation = 'N';
                }
            }
            path.add('L');

        }
    
        public List<Character> getPath() {
            return path;
        }

        public int[] getPosition() {
            return position;
        }
    }  
}
