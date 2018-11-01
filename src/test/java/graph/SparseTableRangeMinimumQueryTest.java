package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
////////////////////////////////////////////////////////////////////////////////
// SparseTableRangeMinimumQueryTest
////////////////////////////////////////////////////////////////////////////////
public class SparseTableRangeMinimumQueryTest {
    // uut
    private SparseTableRangeMinimumQuery uut;

    /*
    @Before
    public void setUp() {
        uf = new SparseTableRangeMinimumQuery();
    }
    */
    ////////////////////////////////////////////////////////////////////////////////
    // Tests
    ////////////////////////////////////////////////////////////////////////////////

    @Test
    public void rmqTest() {
        int[] input = {-1, -1, 1, 1, 1, 1, 3, 10, 10, 10 };
        uut = new SparseTableRangeMinimumQuery(input);
        System.out.println(uut);
        assertThat(uut.rangeMinimumQuery(0,9)).isEqualTo(-1); // entire range
        assertThat(uut.rangeMinimumQuery(1,4)).isEqualTo(-1);
        assertThat(uut.rangeMinimumQuery(1,2)).isEqualTo(-1); // -1, 1
        assertThat(uut.rangeMinimumQuery(6,7)).isEqualTo(3); // 3, 10
        assertThat(uut.rangeMinimumQuery(5,7)).isEqualTo(1); // 1,3,10
        assertThat(uut.rangeMinimumQuery(5,6)).isEqualTo(1); //1, 3
        assertThat(uut.rangeMinimumQuery(6,9)).isEqualTo(3); // 3, 10, 10, 10
    }

    /*
     v = { 1, 1, 2, 2, 2, 3, 4, 5, 5 }
count = { 2, 2, 3, 3, 3, 1, 1, 2, 2 }
start = { 0, 0, 2, 2, 2, 5, 6, 7, 7 }
     */
}