package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.MazeRunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.SimpleSolver.SimpleMazeExplorer;

class MoveToWallTest {
    @Test
    void testMoveForwardIntoWallThrows() {
        char[][] grid = {
            {'#', ' ', '#'},
            {' ', '#', '#'},
            {'#', '#', ' '}
        };
        Maze maze = new Maze(grid);
        SimpleMazeExplorer explorer = new SimpleMazeExplorer(maze);
        explorer.turnRight();
        assertThrows(IllegalArgumentException.class, explorer::moveForward);
    }
}
