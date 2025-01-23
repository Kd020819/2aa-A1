package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;
import java.util.List;

public class FormatPath {
    private List<Character> path;

    public FormatPath(List<Character> path) {
        this.path = path;
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
