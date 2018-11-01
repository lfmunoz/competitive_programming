/*

UVa11235 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11235

range maximum query


https://github.com/andrewphamvk/UVa/blob/master/11235%20-%20Frequent%20values/Main.java

*/

package uva11235;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11235 uva = new UVa11235();
        //uva.runTest();
        uva.run();
    }
}



class SparseTableRangeMinimumQuery {

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
                if (input[sparse[i][j - 1]] >= input[sparse[i + (1 << (j - 1))][j - 1]]) {
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
        if (input[sparse[low][k]] > input[sparse[low + l - (1<<k)][k]]) {
            return input[sparse[low][k]];
        } else {
            return input[sparse[high - (1<<k) + 1][k]];
        }
    }

    private static int log2(int n){
        if(n <= 0) throw new IllegalArgumentException("Failed condition: 0 < " + n);
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

class UVa11235 {
    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11235_in.txt";
    //////////////////////////////////////////////////////////////////////////
    // Inner class data structure
    //////////////////////////////////////////////////////////////////////////



    public void run() throws Exception {
       // Scanner scan =readFile(fileName);
        //Scanner scan =read();
        BufferedReader scan = readwithBuffer();

        while (true) {
            String testCase = scan.readLine();
            //String testCase = scan.nextLine();
            if(testCase.equals("0")) break;
            int n = Integer.parseInt(testCase.split(" ")[0]);
            int q = Integer.parseInt(testCase.split(" ")[1]);

           // List<Integer> numbers =
            int[] numbers =           Arrays.stream(scan.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] count = new int[n];
            int[] start = new int[n];

            int currentNumber = numbers[0];
            int currentCount = 1;
            start[0] = 0;
            for(int idx = 1; idx < n; idx++) {
                if(currentNumber == numbers[idx]) {
                    start[idx] = start[idx-1];
                    currentCount++;
                } else {
                    start[idx] = idx;
                    for(int y = 0; y < currentCount; y++) {

                        count[idx-y-1] = currentCount;
                    }
                    currentCount=1;
                    currentNumber = numbers[idx];
                }

            }
            for(int y = 0; y < currentCount; y++) {
                count[n-y-1] = currentCount;
            }


                   // .collect(Collectors.toList());

            SparseTableRangeMinimumQuery tbl = new SparseTableRangeMinimumQuery(count );
            //System.out.println(tbl.toString());

            for(int idx = 0; idx < q; idx++) {
                String[] rangeCase = scan.readLine().split(" ");
                int first = Integer.parseInt(rangeCase[0]) - 1;
                int second = Integer.parseInt(rangeCase[1]) - 1;

                if(numbers[first] == numbers[second]) {
                    System.out.println(second - first  + 1);
                } else {
                    int cnt1 = count[first] - (first - start[first]);
                    int cnt2 = second - start[second] + 1;

                    int k1 = first + cnt1;
                    int k2 = second - cnt2;
                    if( k1 == k2+1) {

                        System.out.println(Math.max(cnt1,cnt2));
                    } else {

                        int cnt3 = tbl.rangeMinimumQuery(k1, k2);
                        int result = Math.max(cnt3, Math.max(cnt1, cnt2));
                        System.out.println(result);
                    }

                }

                //int result = tbl.rangeMinimumQuery(first-1, second-1);
                //System.out.println(result);
            }

            //System.out.println("done");
        }
    }

    ////////////////////////////////////////////////////////////////////
    // Input/Output Specific Functions
    ////////////////////////////////////////////////////////////////////
    public Scanner read() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }

    public BufferedReader readwithBuffer() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br;
    }

    public static Scanner readFile(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scan = new Scanner(file);
            return  scan;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
