/*

UVa10656 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10656

Runtime 

*/

package uva10656;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10656 uva = new UVa10656();
        //uva.runTest();
        uva.run();
    }
}

/**
 * Overly complicated problem statement. Should have actually been worded
 * remove all the zeros. Or print 0 if there is nothing but 0s.
 */
class UVa10656 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10656_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (true) {
            int n = Integer.parseInt(scan.nextLine());
            if (n == 0) break;
           // List<Integer> seq = new ArrayList<>();
            int total = 0;
            for(int i = 0; i < n; i++) {
                int value = Integer.parseInt(scan.nextLine());

                if(value > 0) {
                    if(total > 0) {
                        System.out.print(" ");
                    }
                        total++;
                        System.out.print(value);
                }

            }

            if(total == 0) System.out.print(0);
            System.out.println();



        //    return;
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
