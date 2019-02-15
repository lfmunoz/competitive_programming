/*

UVa00787 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00787

Runtime 

*/

package uva00787;

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
        UVa00787 uva = new UVa00787();
        //uva.runTest();
        uva.run();
    }
}


class UVa00787 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00787_in.txt";
    int[] seq;
    int max;
    List<String> solutions;

    public void run() {
        Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        //Scanner scan =read();

        while (scan.hasNextLine()) {
            seq = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            solutions = new ArrayList<>();

            max = 1;

            for(int x = 1; x < seq.length; x++) {
                backTrack("0", 0, x);
            }
            return;
            //System.out.println(maxSum);
            //System.out.println(solutions);
        }
    }


    void backTrack(String key, int start, int length) {
        if(start == seq.length - length ) {
          //  System.out.println("solution = " + key);
            System.out.println("done");
            return;
        }

        String nextKey = String.valueOf(start);
        //int product = seq[start];
        for(int i = 0; i < length - 1; i++) {
            nextKey += String.valueOf(start+i+1);
//            product *= seq[start+i+1];

        }



        String a = nextKey.substring(0,nextKey.length() - 1);
        String b = nextKey.substring(nextKey.length() - 1);



      //  solutions.put(nextKey, product);
        System.out.println("key = " + nextKey + " start = " + String.valueOf(start) + " length " + String.valueOf(length)
        + "   "  + " product is " + a + "x "  + b);
        backTrack(nextKey, start+1, length);
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
