package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FactorizedFormTest {
    @Test
    void testComputeFactorizedForm() {
        FormatPath path = new FormatPath("FFFRRL");
        assertEquals("3F2RL", path.computeFactorizedForm());
    }

}
