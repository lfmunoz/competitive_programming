/*

UVa10616 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10616

https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v106/DivisibleGroupSums_UVa10616.java
https://github.com/cormacpayne/UVA/blob/master/UVA10616/UVA10616.java

https://turing13.wordpress.com/2016/03/11/uva-10616-divisible-group-sums/
https://www.algorithmist.com/index.php/UVa_10616
*/

package uva10616;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10616 uva = new UVa10616();
        //uva.runTest();
        uva.run();
    }
}


class UVa10616 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10616_in.txt";

    List<Integer> numbers;
    int N; // how many numbers there are
    int Q; // total number of queries

    int D;
    int M;

    Map<String, Integer> memo = new HashMap();
    int[][] mTable;

    int total = 0;
    public void run() throws Exception {
      // Scanner scan =readFile(fileName);
        BufferedReader scan =readwithBuffer(); // use readLine()
       // Scanner scan =read();
        int set = 1;
        int query = 1;
        while (true) {
            int[] N_Q= Arrays.stream(scan.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = N_Q[0];
            Q = N_Q[1];
            if(N == 0) break;
            numbers = new ArrayList<>();
            // read numbers
            for(int num = 0; num < N; num++) {
                int n = Integer.parseInt(scan.readLine());
                numbers.add(n);
            }
            System.out.printf("SET %d:%n",set++);
            query = 1;
            // read queries
            for(int num = 0; num < Q; num++) {
                int[] D_M= Arrays.stream(scan.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                D = D_M[0]; // sum divisible by D
                M = D_M[1]; // choose any M of them

                memo.clear();
            //    mTable = new int[][];
                System.out.printf("QUERY %d: %d%n", query++,  val(0, 0, 0 ));
            }
        }
    }


    public int val(int id, int sum, int count) {

     ///   System.out.printf("   %d %d %d  %n", id, sum, count);

        if(count > M) {
            return 0; // we cannot take anything else
        }
        if(id == N) {
            if (sum != 0 && count == M && divides(D, sum)) {
           //     System.out.printf("   %d divides %d  count is %d %n", D, sum, count);
                return 1;
            } else {
                return 0;
            }
        }
        String key = String.valueOf(sum);
        if(memo.containsKey(key)) {
           return memo.get(key);
        } else {
            int result = val(id+1, sum, count) + val(id+1, sum+numbers.get(id), count+1);
           memo.put(key, result);
           return result;
        }
    }

    public boolean divides(int a, int b) {
        int result = b % a;
        return result == 0;
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
