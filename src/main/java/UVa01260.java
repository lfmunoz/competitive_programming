/*

UVa01260 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/01260

Runtime 

*/

package uva01260;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa01260 uva = new UVa01260();
        //uva.runTest();
        uva.run();
    }
}


class UVa01260 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva01260_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();


        int testCases = Integer.parseInt(scan.nextLine());
        for(int t = 0; t < testCases; t++) {
            scan.nextLine(); // 2 <= n <= 1,000
            int[] a = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int result = doCount(a);

            System.out.printf("%d%n", result);
        }

    }

    public int doCount(int[] a) {
        int total = 0;
        for(int x = 1; x < a.length; x++) {
            for(int y = 0; y < x; y++) {
               if(a[y] <= a[x]) {
                   total += 1;
               }
            }
        }
        return total;

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
