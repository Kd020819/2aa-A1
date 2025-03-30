package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.MazeRunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.SimpleSolver.SimpleMazeExplorer;
import ca.mcmaster.se2aa4.mazerunner.Solver.MazeExplorer;


    
public class Main {

    public static void main(String[] args) {
        System.out.println("** Starting Maze Runner");
        Options options = new Options();
        options.addOption("i", true, "Input file for the maze");
        options.addOption("p", true, "Validating path for the maze");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);

            // Get the file path from the -i flag
            String inputFilePath = cmd.getOptionValue("i");
            System.out.println("**** Reading the maze from file " + inputFilePath);
            Maze maze_validator = Maze.fromFile(inputFilePath);
            MazeExplorer validator = new SimpleMazeExplorer(maze_validator);

            // Get the file path from the -p flag
            if (cmd.getOptionValue("p") != null) {
                List<Character> ValidatePath = new ArrayList<>();
                String path = cmd.getOptionValue("p");

                System.out.println("**** Validating path ");

                for (char c : path.toCharArray()) {
                    ValidatePath.add(c);
                }
                FormatPath Path = new FormatPath(path);
                

                if (validator.isValidPath(Path)){
                    System.out.println("correct path");
                }else{
                    System.out.println("incorrect path");
                }
            }else{

            // Process the maze file
            //System.out.println("================== Finding paths ===============");
            Maze maze_solver = Maze.fromFile(inputFilePath);
            MazeExplorer explorer = new SimpleMazeExplorer(maze_solver);
            explorer.explore();
            String path = explorer.getPath().toString();
            FormatPath formatter = new FormatPath(path);

            System.out.println("Path found(canonical form): " + formatter.computeCanonicalForm());
            System.out.println("Path found(factorized form): " + formatter.computeFactorizedForm());
            }

        } catch (Exception e) {
            System.err.println("/!\\ An unexpected error has occurred: " + e.getMessage());
        }
        System.out.println("** End of Maze Runner");
    }

    
}
