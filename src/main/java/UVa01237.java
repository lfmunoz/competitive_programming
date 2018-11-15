/*

UVa01237 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/01237

Runtime 

*/

package uva01237;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa01237 uva = new UVa01237();
        //uva.runTest();
        uva.run();
    }
}


class UVa01237 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva01237_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();
        //BufferedReader scan =readwithBuffer();



        int testCases = Integer.parseInt(scan.nextLine());
        for(int c = 0; c < testCases; c++) {
            int dbSize = Integer.parseInt(scan.nextLine()); // D < 10000
            int[] min = new int[dbSize];
            int[] max = new int[dbSize];
            String[] company = new String[dbSize];
            for(int d = 0; d < dbSize; d++) {
               String[] dbEntry = scan.nextLine().split(" ");
               company[d] = dbEntry[0];
               min[d] = Integer.parseInt(dbEntry[1]);
               max[d] = Integer.parseInt(dbEntry[2]);
            }
            int querySize = Integer.parseInt(scan.nextLine()); // D < 10000
            for(int q = 0; q < querySize; q++) {
                int query = Integer.parseInt(scan.nextLine());
                scanDB(max, min, company, query);

            }

            // blank line for next test case
            //scan.nextLine();
            if(c != testCases-1 ) {

                System.out.println();
            }

        }

    }

    private void scanDB(int[] max, int[] min, String[] company, int query) {
        int idx = -1;
        // complete search scan of db
        for(int d = 0; d < max.length; d++) {
            if(query >= min[d] && query <= max[d]) {
                if(idx != -1) {
                    System.out.println("UNDETERMINED");
                    return;
                } else {
                    idx = d;
                }
            }
        }
        if(idx != -1) {
            System.out.println(company[idx]);
        } else {
            System.out.println("UNDETERMINED");

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
