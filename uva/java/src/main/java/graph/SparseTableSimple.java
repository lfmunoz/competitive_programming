package graph;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


class SparseTableSimple {

    long[][] tbl;

    SparseTableSimple(List<Integer> in) {

        // pre-process table. Go through each range x to y
        // and compute some function here mostCommonItem
        // Space is n^2.  Time is n^2
        int length = in.size();
        tbl = new long[length][length];
        for(int x = 0; x < length; x++) {
            for(int y = x; y < length; y++) {
                long result =  mostCommonItem(in.subList(x, y+1));
                tbl[x][y] = result;
            }
        }

    }

    // Given a list, group the items and count how many of each item we have.
    // return the number of maximum items
    long mostCommonItem(List<Integer> in) {
        Map<Integer, Long> x = in.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Optional<Map.Entry<Integer, Long>> result =  x.entrySet().stream().max( Comparator.comparingLong(Map.Entry::getValue));
        // 2147483647 max long
        return result.get().getValue();
    }

    // look up the pre-computed value O(1)
    long query(int i, int j) {
        return tbl[i-1][j-1];
    }

}