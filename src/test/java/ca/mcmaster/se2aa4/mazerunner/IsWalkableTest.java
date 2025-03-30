package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.MazeRunner.Maze;

class IsWalkableTest {
    @Test

    void testIsWalkable() {
        char[][] grid = {
            {'#', ' ', '#'},
            {' ', '#', '#'},
            {'#', '#', ' '}
        };
        Maze maze = new Maze(grid);
        assertTrue(maze.isWalkable(new int[]{0, 1}));
        assertFalse(maze.isWalkable(new int[]{1, 1}));
    }

    
}
