package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Solver.MazeExplorer;

public class RightCommand implements Command {
    @Override
    public void execute(MazeExplorer explorer) {
        explorer.turnRight();
    }
}
