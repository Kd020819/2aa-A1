package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.MazeRunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.SimpleSolver.SimpleMazeExplorer;

public class MoveForwardTest {
    @Test
    void testMoveForward() {
        Maze maze = new Maze(new char[][]{{' ', ' ', ' '}});
        SimpleMazeExplorer explorer = new SimpleMazeExplorer(maze);
        explorer.moveForward();
        assertArrayEquals(new int[]{0, 1}, explorer.getPosition());
    }
}
