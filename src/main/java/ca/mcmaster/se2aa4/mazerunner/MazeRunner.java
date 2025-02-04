package ca.mcmaster.se2aa4.mazerunner;

import java.io.*;
import java.util.*;

public class MazeRunner {

    // Maze class
    public static class Maze {
        private char[][] grid;
        private int[] entry;
        private int[] exit;


        public Maze(char[][] grid) {
            this.grid = grid;
            this.entry = findEntry();
            this.exit = findExit();
        }

        public static Maze fromFile(String filePath) throws IOException {
            List<char[]> rows = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    rows.add(line.toCharArray());
                }
            }
            char[][] grid = rows.toArray(new char[0][]);
            return new Maze(grid);
        }

        private int[] findEntry() {
            for (int row = 0; row < grid.length; row++) {
                //System.out.println(grid[row][0]);
                if (grid[row][0] == ' ') {
                    return new int[]{row,0};
                }
            }
            throw new IllegalArgumentException("No entry point found");
        }

        private int[] findExit() {

            for (int row = 0; row < grid[grid.length - 1].length; row++) {
                if (grid[row][grid.length - 1] == ' ') {
                    return new int[]{row, grid.length - 1};
                }
            }
            throw new IllegalArgumentException("No exit point found");
        }

        public boolean isWalkable(int[] pos) {
            int row = pos[0];
            int col = pos[1];
            return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == ' ';
        }

        public int[] getEntry() {
            return entry;
        }

        public int[] getExit() {
            return exit;
        }
    }
}