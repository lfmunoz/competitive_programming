/*

UVa00624 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00624

Runtime 

*/

package uva00624;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00624 uva = new UVa00624();
        //uva.runTest();
        uva.run();
    }
}


class UVa00624 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00624_in.txt";

    int[] tracks;
    int N;
    String globalResult;
    int globalSum;

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();



        while (scan.hasNextLine()) {
            int[] input = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            N = input[0]; // total length
            tracks = new int[input[1]];
            globalSum = 0;
            globalResult = "";

            for(int t = 0; t < tracks.length; t++) {
                tracks[t] =  input[t+2];
            }
            backtrack(0, "", 0);
            System.out.printf("%ssum:%d%n", globalResult, globalSum);

        }
    }

    public void backtrack(int index, String result, int currentSum) {
      //  System.out.printf("index = %d, currentSum %d %n", index, currentSum);
        if(index == tracks.length) {
            if(currentSum > globalSum) {
                globalResult = result;
                globalSum = currentSum;
            }
            return;
        }

        int nextIndex =  index + 1;
        String nextResult = result + String.format("%d ", tracks[index]);
        int nextSum = currentSum + tracks[index];

        if(nextSum <= N) {
            backtrack(nextIndex, nextResult, nextSum) ;
        }
        backtrack(nextIndex, result, currentSum) ;

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
