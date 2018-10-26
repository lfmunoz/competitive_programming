/*

UVa11235 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11235

range maximum query

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


class Pair {
    // value, count

    Map<Integer, Integer> countMap = new HashMap<>();

    int maxCount = Integer.MIN_VALUE;

    Pair() {

    }
    Pair(int value, int count) {
        countMap.put(value, count);
        maxCount = count;
    }

    Pair(Pair pair0, Pair pair1) {
        this.countMap.putAll(pair0.countMap);
        pair1.countMap.entrySet().forEach( entry -> {
            int value = entry.getKey();
            int count = entry.getValue();
            if(this.countMap.containsKey(value)) {
                count += this.countMap.get(value);
            }
            this.countMap.put(value, count);

            if(count > maxCount) {
                maxCount = count;
            }

        });
    }

    public void merge(Pair pair) {
        pair.countMap.entrySet().forEach( entry -> {
            int value = entry.getKey();
            int count = entry.getValue();
            if(this.countMap.containsKey(value)) {
                count += this.countMap.get(value);
            }
            this.countMap.put(value, count);
            if(count > maxCount) {
                maxCount = count;
            }
        });
    }

    public int compute() {

        return maxCount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        countMap.entrySet().stream().forEach( entry -> {
           String key = String.valueOf(entry.getKey());
           String value = String.valueOf(entry.getValue());
           sb.append("(" + key + "," + value +  ")");
        });
        return sb.toString();
    }


}

class SparseTableRangeMinimumQuery {

    private final Pair[][] sparse;
    private final int n;
    private final int[] input;

    public SparseTableRangeMinimumQuery(int[] input) {
        this.input = input;
        this.n = input.length;
        this.sparse = preprocess(input, this.n);
    }

    private Pair[][] preprocess(int[] input, int n) {
        Pair[][] sparse = new Pair[n][log2(n) + 1];
        for (int i = 0; i < input.length; i++) {
            sparse[i][0] = new Pair( input[i], 1);
        }

        for (int j = 1; 1 << j <= n; j++) {
            for (int i = 0; i + (1 << j)  <= n; i++) {

                //System.out.printf("%d %d \n", i ,j);
                Pair inst0 =  sparse[i][j - 1];
                Pair inst1 =  sparse[i+ (1 << (j - 1))][j - 1];

                sparse[i][j] = new Pair(inst0, inst1);
                /*
                if(inst0.value == inst1.value) {
                    sparse[i][j] = new Pair(inst0.count + inst1.count, inst0.value);
                } else if(inst1.count >= inst1.count) {
                    sparse[i][j] = new Pair(inst1.count , inst1.value);
                } else {
                    sparse[i][j] = new Pair(inst0.count, inst0.value);
                }
                */

                /*
                if(inst0.count == inst1.count) {
                    if(inst0.value == inst1.value) {
                        sparse[i][j] = new Pair(inst0.count + inst1.count, inst0.value);
                    } else {
                        sparse[i][j] = new Pair(inst1.count, inst1.value);
                    }
                } else if(inst0.count < inst1.count) {
                    sparse[i][j] = new Pair(inst0.count , inst0.value);
                } else {
                    sparse[i][j] = new Pair(inst1.count, inst1.value);
                }
                */



                /*
                if (input[sparse[i][j - 1]] <= input[sparse[i + (1 << (j - 1))][j - 1]]) {
                    sparse[i][j] = sparse[i][j - 1];
                } else {
                    sparse[i][j] = sparse[i + (1 << (j - 1))][j - 1];
                }
                */


            }
        }


        return sparse;


    }

    public String toString() {
      //  if(! (sparse.length > 0)) return "empty";
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x <  sparse[0].length; x++) {
            sb.append("Row: " + x + "\n");
            for (int y = 0; y < sparse.length; y++) {
                Pair pair = sparse[y][x];
                if(pair == null) {
                    sb.append("(X,X)");
                } else {
                    sb.append(pair.toString());
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


/*
    long calcFunc(List<Integer> in) {
        Map<Integer, Long> x = in.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Optional<Map.Entry<Integer, Long>> result =  x.entrySet().stream().max( Comparator.comparingLong(Map.Entry::getValue));
        // 2147483647 max long
        return result.get().getValue();
    }
    */


    public int rangeMinimumQuery(int low, int high) {
        int span = high - low + 1;
        int log2Span = log2(span);
        int chunk  = (1 << log2Span);
        int left = span - chunk;

        Pair pair = new Pair();

        while(true) {
            //System.out.print(new Pair(low,log2Span).toString());
            pair.merge(sparse[low][log2Span]);

            if(left == 0) {
                break;
            }

            low = low + chunk;
            span = high - low + 1;
            log2Span = log2(span);
            chunk  = (1 << log2Span);
            left = span - chunk;
        }

        return pair.compute();
    }


    private static int log2(int n){
        if(n <= 0) throw new IllegalArgumentException();
        return 31 - Integer.numberOfLeadingZeros(n);
    }

}

class UVa11235 {
    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11235_in.txt";
    //////////////////////////////////////////////////////////////////////////
    // Inner class data structure
    //////////////////////////////////////////////////////////////////////////



    public void run() throws Exception {
        //Scanner scan =readFile(fileName);
        //Scanner scan =read();
        BufferedReader scan = readwithBuffer();

        while (true) {
            String testCase = scan.readLine();
            if(testCase.equals("0")) break;
            int n = Integer.parseInt(testCase.split(" ")[0]);
            int q = Integer.parseInt(testCase.split(" ")[1]);

           // List<Integer> numbers =
                    int[] numbers =
                    Arrays.stream(scan.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
                   // .collect(Collectors.toList());

            SparseTableRangeMinimumQuery tbl = new SparseTableRangeMinimumQuery(numbers );
        //    System.out.println(tbl.toString());

            for(int idx = 0; idx < q; idx++) {
                String[] rangeCase = scan.readLine().split(" ");
                int start = Integer.parseInt(rangeCase[0]);
                int end = Integer.parseInt(rangeCase[1]);

                int result = tbl.rangeMinimumQuery(start-1, end-1);
                System.out.println(result);
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
