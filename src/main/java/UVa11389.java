/*

UVa11389 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11389

Runtime 

*/

package uva11389;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11389 uva = new UVa11389();
        //uva.runTest();
        uva.run();
    }
}


class UVa11389 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11389_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (true) {
            String[] values = scan.nextLine().split(" ");
            int n = Integer.parseInt(values[0]); // n bus drivers, n morning routes, n afternoon routes
            int d = Integer.parseInt(values[1]); // maximum route length
            int r = Integer.parseInt(values[2]); // rate of overtime
            if(n == 0 && d == 0 && r == 0) break;

            // assume sorted
            int[] morning = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            int[] evening = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

            int total = 0;
            int m = 0;
            int e = n-1;
            for(int i = 0; i < n; i++) {
               int rate =  ( (morning[m] + evening[e]) - d );
               if(rate > 0) {
                   rate *= r;
                   total += rate;
               }
               m++;
               e--;
            }
            System.out.println(total);
           // return;
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
