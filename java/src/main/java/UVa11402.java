/*

UVa11402 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11402

Runtime 

*/

package uva11402;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11402 uva = new UVa11402();
        //uva.runTest();
        uva.run();
    }
}


class UVa11402 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11402_in.txt";

    public void run() {
        Scanner scan =readFile(fileName);
        //Scanner scan =read();

        int testCases = Integer.parseInt(scan.nextLine());

        for(int testCase = 0; testCase < testCases; testCase++) {
            int M = Integer.parseInt(scan.nextLine()); // M pair lines follow M <= 100
            StringBuilder priatesBuilder = new StringBuilder();
            for (int m = 0; m < M; m++) {
                int multiplier = Integer.parseInt(scan.nextLine());
                String onesZeros  = scan.nextLine();
                while(multiplier-- > 0) {
                    priatesBuilder.append(onesZeros);
                }
            }
            System.out.println(priatesBuilder.toString());
            int Q = Integer.parseInt(scan.nextLine()); // number of queries
            for (int q = 0; q < Q; q++) {
                String[] query = scan.nextLine().split(" ");
                int a = Integer.parseInt(query[1]);
                int b = Integer.parseInt(query[2]);
            }

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
