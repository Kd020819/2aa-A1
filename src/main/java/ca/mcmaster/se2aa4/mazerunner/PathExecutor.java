package ca.mcmaster.se2aa4.mazerunner;
import java.util.Map;
import ca.mcmaster.se2aa4.mazerunner.Solver.MazeExplorer;
import ca.mcmaster.se2aa4.mazerunner.FormatPath;

public class PathExecutor {

    private static final Map<Character, Command> commandMap = Map.of(
        'F', new ForwardCommand(),
        'L', new LeftCommand(),
        'R', new RightCommand()
    );

    public static void execute(FormatPath path, MazeExplorer explorer) {
        for (char step : path.getSteps()) {
            Command command = commandMap.get(step);
            if (command == null) {
                throw new IllegalArgumentException("Invalid step: " + step);
            }
            command.execute(explorer);
        }
    }
}
