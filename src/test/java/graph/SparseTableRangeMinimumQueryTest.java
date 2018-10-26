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
    public void zeroIndexedAndInclusive() {
        int[] input = {2, 1, 0 };
        uut = new SparseTableRangeMinimumQuery(input);
        assertThat(uut.rangeMinimumQuery(0, 0)).isEqualTo(2);
        assertThat(uut.rangeMinimumQuery(0, 1)).isEqualTo(1);
        assertThat(uut.rangeMinimumQuery(0, 2)).isEqualTo(0);

        assertThatThrownBy(() -> {
            uut.rangeMinimumQuery(0, 3);
        }).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    public void understandingTheLoops() {
        int n = 10;
        for (int j = 1; 1 << j <= n; j++) {
            for (int i = 0; i + (1 << j)  <= n; i++) {
                System.out.printf("%d %d \n", i ,j);
            }
        }
    }

    class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public String toString() {

            return  String.format("(%d, %d)", left, right);
        }
    }

    private static int log2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    public void rangeMinimumQuery(int low, int high) {


        int span = high - low + 1;
        int log2Span = log2(span);
        int chunk  = (1 << log2Span);
        int left = span - chunk;

        while(true) {
            System.out.print(new Pair(low,log2Span).toString());
            if(left == 0) {
                break;
            }

            low = low + chunk;
            span = high - low + 1;
            log2Span = log2(span);
            chunk  = (1 << log2Span);
            left = span - chunk;
        }
        System.out.println();
    }

    @Test
    public void rmqTest() {

        rangeMinimumQuery(1,1);
        rangeMinimumQuery(1,2);
        rangeMinimumQuery(1,3);
        rangeMinimumQuery(1,4);
        rangeMinimumQuery(1,5);
        rangeMinimumQuery(1,6);
        rangeMinimumQuery(1,7);

    }

}