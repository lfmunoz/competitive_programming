package graph;
/**
 * Date 04/28/2016
 * @author Tushar Roy
 *
 * @author Luis F Munoz
 *  - Added support for any function
 *
 * Find range minimum query using sparse table.
 *
 * Preprocessing Time complexity O(nlogn)
 * Query Time complexity O(1)
 * Space complexity O(nlogn)
 *
 * Reference -
 * https://www.topcoder.com/community/data-science/data-science-tutorials/range-minimum-query-and-lowest-common-ancestor/
 */
public class SparseTableRangeMinimumQuery {

    private final int[][] sparse;
    private final int n;
    private final int[] input;

    public SparseTableRangeMinimumQuery(int[] input) {
        this.input = input;
        this.n = input.length;
        this.sparse = preprocess(input, this.n);
    }

    private int[][] preprocess(int[] input, int n) {
        int[][] sparse = new int[n][log2(n) + 1];
        for (int i = 0; i < input.length; i++) {
            sparse[i][0] = i;
        }

        for (int j = 1; 1 << j <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                if (input[sparse[i][j - 1]] < input[sparse[i + (1 << (j - 1))][j - 1]]) {
                    sparse[i][j] = sparse[i][j - 1];
                } else {
                    sparse[i][j] = sparse[i + (1 << (j - 1))][j - 1];
                }
            }
        }
        return sparse;
    }


    // low and high are zero indexed and inclusive
    public int rangeMinimumQuery(int low, int high) {
        if(high >= n) throw new IllegalArgumentException("High index must be less than n = " + n);
        if(low < 0) throw new IllegalArgumentException("Low index can't be less than 0");

        int l = high - low + 1;
        int k = log2(l);
        if (input[sparse[low][k]] <= input[sparse[low + l - (1<<k)][k]]) {
            return input[sparse[low][k]];
        } else {
            return input[sparse[high - (1<<k) + 1][k]];
        }
    }

    private static int log2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }


    public String toString() {
        //  if(! (sparse.length > 0)) return "empty";
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x <  sparse.length; x++) {
           // sb.append("Row: " + x + "\n");
            for (int y = 0; y < sparse[x].length; y++) {
                int num = sparse[x][y];
                if(num == 0) {
                    sb.append("X");
                    sb.append(" ");
                } else {
                    sb.append(String.valueOf(num));
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}

