package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CanonicalForm {
    @Test
    void testComputeFactorizedForm() {
        FormatPath path = new FormatPath("FFFRRL");
        assertEquals("3F2RL", path.computeFactorizedForm());
    }

}