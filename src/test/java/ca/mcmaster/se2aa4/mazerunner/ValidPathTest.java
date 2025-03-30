package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.MazeRunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.SimpleSolver.SimpleMazeExplorer;

class ValidPathTest {
    @Test
    void testValidPath() {
        Maze maze = new Maze(new char[][]{
            {' ', ' ', ' '},
            {'#', '#', ' '},
            {'#', '#', ' '}
        });
        FormatPath path = new FormatPath("FF");
        SimpleMazeExplorer explorer = new SimpleMazeExplorer(maze);
        assertTrue(explorer.isValidPath(path));
    }    
}
