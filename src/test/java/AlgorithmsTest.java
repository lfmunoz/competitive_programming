import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmsTest {

    @Test
    public void quickSort() {
        assertEquals(17, Algorithms.quickSort(17));
    }
}