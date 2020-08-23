/*

UVa11553 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11553

Runtime 

*/

package uva11553;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11553 uva = new UVa11553();
        //uva.runTest();
        uva.run();
    }
}


class UVa11553 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11553_in.txt";

    int[][] matrix;



    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        int testCases = Integer.parseInt(scan.nextLine());
        for(int t  = 0; t < testCases; t++) {
            int n = Integer.parseInt(scan.nextLine()); // n by n matrix
            matrix = new int[n][n];
            for(int r = 0; r< n; r++) {
                String[] row = scan.nextLine().split(" ");
                for(int c = 0; c< n; c++) {
                    matrix[r][c] = Integer.parseInt(row[c]);
                }
            }

            List<List<Integer>> result = new ArrayList<>();
            permutations(result, IntStream.range(0, n).boxed().collect(Collectors.toList()), 0, n-1);
            int max = Integer.MAX_VALUE;
            for(int i = 0; i < result.size(); i++) {
                int sum = 0;
                for(int j =0; j < n; j++) {
                    int idx = result.get(i).get(j);
                    int value = matrix[j][idx];
                    sum += value;
                }
                max = Math.min(max, sum);
            }
            System.out.println(max);

        }

    }

    /**
     *  Generate permutations given a list of Integers
     * @param result
     * @param input
     * @param left - starting index (inclusive)
     * @param right - ending index (inclusive)
     */
    public <T> void permutations(List<List<T>> result, List<T> input, int left, int right) {
        if(left == right) {
            result.add(input);
        } else {
            for(int idx = left; idx <= right; idx++) {
                List<T> temp = swap(input, left, idx);
                permutations(result, temp, left+1, right);
            }

        }
    }

    public <T> List<T> swap(List<T> c, int x, int  y) {
        List<T> temp  = new ArrayList<T>(c);
        Collections.swap(temp, x, y);
        return temp;
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
