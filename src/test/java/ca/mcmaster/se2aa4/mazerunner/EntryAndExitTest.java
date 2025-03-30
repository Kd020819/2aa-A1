package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.MazeRunner.Maze;

class EntryAndExitTest {
    @Test
    void testMazeEntryAndExit(){
        char[][] grid = {
            {' ', '#', '#'},
            {'#', ' ', '#'},
            {'#', ' ', ' '}
        };

        Maze maze = new Maze(grid);
        assertArrayEquals(new int[]{0, 0}, maze.getEntry());
        assertArrayEquals(new int[]{2, 2}, maze.getExit());
    }

}
