package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SparseTableTest {


    ////////////////////////////////////////////////////////////////////////////////
    // Tests
    ////////////////////////////////////////////////////////////////////////////////
    @Test
    public void collectionsTest() {

        List<Integer> in = Arrays.asList(1,2,2,3,3,3,4,4,4,4, 10);
        Map<Integer, Long> x = in.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<Map.Entry<Integer, Long>> y =  x.entrySet().stream().max( Comparator.comparingLong(Map.Entry::getValue));




        assertThat(true).isTrue();

    }
}