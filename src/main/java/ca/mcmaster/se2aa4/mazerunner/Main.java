package ca.mcmaster.se2aa4.mazerunner;

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

        // Parse command-line arguments
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);

            // Get the file path from the -i flag
            String inputFilePath = cmd.getOptionValue("i");
            System.out.println("**** Reading the maze from file " + inputFilePath);
            Maze maze = Maze.fromFile(inputFilePath);

            // Process the maze file
            MazeExplorer explorer = new SimpleMazeExplorer(maze);
            explorer.explore();
            List<Character> path = explorer.getPath();
            FormatPath formatter = new FormatPath(path);

            System.out.println("Path found(canonical form): " + formatter.computeCanonicalForm());
            System.out.println("Path found(factorized form): " + formatter.computeFactorizedForm());

        } catch (Exception e) {
            System.err.println("/!\\ An unexpected error has occurred: " + e.getMessage());
        }
        System.out.println("** End of Maze Runner");
    }

    
}
