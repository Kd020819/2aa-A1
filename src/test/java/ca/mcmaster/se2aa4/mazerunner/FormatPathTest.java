package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class FormatPathTest {
    @Test
    void testFactorizedToCanonical() {
        FormatPath path = new FormatPath("3F2L");
        List<Character> expected = List.of('F', 'F', 'F', 'L', 'L');
        assertEquals(expected, path.getSteps());
    }   
}
