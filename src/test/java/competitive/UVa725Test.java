package competitive;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luis on 8/4/17.
 */
public class UVa725Test {
    @Test
    public void check_digits() throws Exception {
        UVa725 uva = new UVa725();
        assertEquals(uva.check_digits(100,100), false);
        assertEquals(uva.check_digits(100,100), true);
    }

}