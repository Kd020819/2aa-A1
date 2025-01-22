package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

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

            // Process the maze file
            processMaze(inputFilePath);

        } catch (Exception e) {
            System.err.println("/!\\ An unexpected error has occurred: " + e.getMessage());
        }

        System.out.println("**** Computing path");
        System.out.println("PATH NOT COMPUTED");
        System.out.println("** End of Maze Runner");
    }

    private static void processMaze(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                if (line.charAt(0) == ' ') {
                    System.out.print(line.charAt(0));
                    System.out.print("Entrance");
                } 
                
                System.out.print(System.lineSeparator());
                
            }
        } catch (Exception e) {
            System.err.println("/!\\ An error occurred while reading the maze file: " + e.getMessage());
        }
    }
}
