/*

UVa00927 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/927

Runtime

*/

package uva00927;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00927 uva = new UVa00927();
        //uva.runTest();
        uva.run();
    }
}


class UVa00927 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00927_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        int testCases = Integer.parseInt(scan.nextLine());
        for(int c = 0; c < testCases; c++) {
            int[] poly = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int d = Integer.parseInt(scan.nextLine());
            int k = Integer.parseInt(scan.nextLine());
            int n = calculateN(k,d);
            System.out.println(funcOfN(poly, n));
        }
    }

    public long funcOfN(int[] polynomial, int n) {
       long result = polynomial[1];
       for(int i = 2 ; i < polynomial.length; i++) {
          result += polynomial[i] * Math.pow(n, i-1);
       }
       return result;
    }



    public int calculateN(int k, int d) {
        int n = 1;
        while(k > d) {
            n++;
            k = k-(d*n);
        }
        return n;
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
