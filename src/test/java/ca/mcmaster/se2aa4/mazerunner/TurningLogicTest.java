package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.MazeRunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.SimpleSolver.SimpleMazeExplorer;

class TurningLogicTest {
    @Test
    void testTurningRightAndLeft() {
        Maze maze = new Maze(new char[][]{{' ', ' ', ' '}});
        SimpleMazeExplorer explorer = new SimpleMazeExplorer(maze);
        explorer.turnRight(); // E -> S
        explorer.turnLeft();  // S -> E
        assertEquals('E', explorer.orientation);
    }    
}
