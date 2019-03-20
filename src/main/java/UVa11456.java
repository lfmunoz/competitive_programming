/*

UVa11456 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11456


http://codingwithsandhu.blogspot.com/2018/05/11456-trainsorting.html

Runtime

https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestIncreasingSubsequence.java

*/

package uva11456;

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
        UVa11456 uva = new UVa11456();
        //uva.runTest();
        uva.run();
    }
}


class UVa11456 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11456_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();
        int testCases = Integer.parseInt(scan.nextLine());
        for(int t = 0; t < testCases; t++) {
            int cars = Integer.parseInt(scan.nextLine());
            if(cars == 0) {
                System.out.printf("%d%n", 0);
                continue;
            }
            int[] weights = new int[cars];
            int max = 1;
            for(int c = 0; c < cars; c++) {
                weights[c] = Integer.parseInt(scan.nextLine());
            }


            /*
            int max = 1;
            int[] weights = new int[cars];
            int[] LIS = new int[cars];
            // base case
            LIS[0] = 1;
            weights[0] = Integer.parseInt(scan.nextLine());
            // normal case
            for(int c = 1; c < cars; c++) {
                weights[c] = Integer.parseInt(scan.nextLine());
                LIS[c] = 1;



                for(int i = c-2; i >= 0; i-- ) {
                    if(weights[c] > weights[i] ) {
                       LIS[c] = LIS[i] + 1;
                       max = Math.max(LIS[c], max);
                       break;
                    }
                }
            }
            */
            System.out.printf("%d%n", LISV2(weights));
          //  return;
        }
    }

    public int LIS_LDS(int[] values) {
        int[] LIS = new int[values.length];
        int[] LDS = new int[values.length];
        int max = 1;
        LIS[0] = 1;
        LDS[0] = 1;
        int index = 0;
        for(int i = 1; i < values.length; i++) {
            LIS[i] = 1;
            LDS[i] = 1;
            for(int j = 0; j < i; j++) {
                if(values[i] > values[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j]+1);
                }
                if(values[i] < values[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j]+1);
                }
                if(LIS[i]+LDS[i]-1 > max ) {
                    max = LIS[i]+LDS[i]-1;
                    index = i;
                }
               // max = Math.max(LIS[i]+LDS[i]-1, max);
            }
        }
        return max;

    }



    public int LISV2(int[] values) {
        int[] LIS = new int[values.length];
        int[] LDS = new int[values.length];
        int max = 1;

        for(int i=values.length-1; i>=0; i--) {
            LIS[i] = 1;
            LDS[i] = 1;
        }
        for(int i = values.length - 2; i >= 0; i--) {
           // LIS[i] = 1;
            for(int j = i+1; j < values.length; j++) {
              //  if(values[j] > values[i]) {
              //      LIS[i] = Math.max(LIS[i], LIS[j]+1);
                    max = Math.max(LIS[i], max);
              //  }


                if(values[i] > values[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j]+1);
                }
                if(values[i] < values[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j]+1);
                }
                if(LIS[i]+LDS[i]-1 > max ) {
                    max = LIS[i]+LDS[i]-1;
                  //  index = i;
                }

            }
        }
        return max;
    }

    public int LIS(int[] values) {
        int[] LIS = new int[values.length];
        int max = 1;
        LIS[0] = 1;
        for(int i = 1; i < values.length; i++) {
            LIS[i] = 1;
            for(int j = 0; j < i; j++) {
                if(values[i] > values[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j]+1);
                    max = Math.max(LIS[i], max);
                }
            }
        }
        return max;
    }

    public int LDS(int[] values) {
        int[] LIS = new int[values.length];
        int max = 1;
        LIS[0] = 1;
        for(int i = 1; i < values.length; i++) {
            LIS[i] = 1;
            for(int j = 0; j < i; j++) {
                if(values[i] < values[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j]+1);
                    max = Math.max(LIS[i], max);
                }
            }
        }
        return max;
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
