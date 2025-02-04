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
        public void explore() {
            // System.out.print(position[0]);
            // System.out.print(position[1]);
            // System.out.println(orientation);
            while (!Arrays.equals(position, maze.getExit())) {
                // Check if turning right is possible
                turnRight();
                //path.add('R');
                if (maze.isWalkable(nextPosition())) {
                    moveForward();
                    //path.add('F');
                } else {
                    // Restore orientation and try moving forward
                    turnLeft(); // Undo the turnRight

                    if (maze.isWalkable(nextPosition())) {
                        moveForward();

                    } else {
                        // Check if turning left is possible
                        turnLeft();
                        if (maze.isWalkable(nextPosition())) {
                            moveForward();
                        } else {
                            // Turn around (180 degrees) if no other options
                            turnRight(); //undo turnleft 
                            turnRight();
                            turnRight();
                        }
                    }
                }
                // System.out.print(position[0]);
                // System.out.print(position[1]);
                // System.out.println(orientation);
                // try {
                //     Thread.sleep(1000);
                //   } catch (InterruptedException e) {
                //     Thread.currentThread().interrupt();
                // }

            }
        }

        public Boolean isValidPath(FormatPath path){
            int[] pos = maze.getEntry();
            if (pos == null) {
                throw new IllegalArgumentException("Maze must have a start position");
            }

            for (char c : path.getSteps()){
                switch(c){
                    case 'F' ->{
                        moveForward();
                        if (!maze.isWalkable(pos)){
                            return false;
                        }
                    }
                    case 'R' ->{
                 
                        turnRight();
                    }
                    case 'L' ->{
             
                        turnLeft();
                    }
                }
                // System.out.print(position[0]);
                // System.out.print(position[1]);
                // System.out.println(orientation);
            }

            return Arrays.equals(pos,maze.getExit());
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
