package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Solver.MazeExplorer;

public interface Command {
    void execute(MazeExplorer explorer);
}

