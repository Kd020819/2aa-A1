package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.List;

public class FormatPath {
    private final List<Character> path = new ArrayList<>();

    public FormatPath() {}

    public FormatPath(String pathStr) {
        String expanded = factorizedToCanonical(pathStr);
        for (Character c : expanded.toCharArray()) {
            if (c != ' ') {
                if (c != 'F' && c != 'L' && c != 'R') {
                    throw new IllegalArgumentException("Instruction '" + c + "' is invalid. Must be 'F', 'L', or 'R'.");
                }
                path.add(c);
            }
        }
    }

    public List<Character> getPathSteps() {
        return new ArrayList<>(this.path);
    }

    public String factorizedToCanonical(String factorized) {
        StringBuilder canonical = new StringBuilder();
        StringBuilder currentCommand = new StringBuilder();

        for (int i = 0; i < factorized.length(); i++) {
            char c = factorized.charAt(i);

            if (Character.isDigit(c)) {
                // If it's a digit, accumulate the factor
                currentCommand.append(c);
            } else if (Character.isLetter(c)) {
                // If it's a letter, process the command
                if (currentCommand.length() > 0) {
                    // Repeat the command based on the accumulated factor
                    int repeatCount = Integer.parseInt(currentCommand.toString());
                    canonical.append(String.valueOf(c).repeat(repeatCount));
                    currentCommand.setLength(0); // Reset the command
                } else {
                    // Append the command as-is
                    canonical.append(c);
                }
            }
        }

        return canonical.toString();
    }

    public String computeCanonicalForm() {
        StringBuilder canonical = new StringBuilder();
        for (char step : path) {
            canonical.append(step);
        }
        return canonical.toString();
    }

    public String computeFactorizedForm() {
        StringBuilder factorized = new StringBuilder();
        int count = 1;

        for (int i = 1; i < path.size(); i++) {
            if (path.get(i) == path.get(i - 1)) {
                count++;
            } else {
                factorized.append(count > 1 ? count : "").append(path.get(i - 1));
                count = 1;
            }
        }
        // Append the last sequence
        factorized.append(count > 1 ? count : "").append(path.get(path.size() - 1));

        return factorized.toString();
    }

}
