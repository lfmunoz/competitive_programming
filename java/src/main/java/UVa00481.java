/*

UVa00481 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00481

Runtime 

*/

package uva00481;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00481 uva = new UVa00481();
        //uva.runTest();
        uva.run();
    }
}


class UVa00481 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00481_in.txt";

    public void run() throws Exception {
        //Scanner scan =readFile(fileName);
        BufferedReader scan =readwithBuffer(); // use readLine()
       // Scanner scan =read();

        List<Integer> numbers = new ArrayList<>();
        // read in values
        while (true) {
            String line = scan.readLine();
            if(line == null) break;
            int number = Integer.parseInt(line);
            numbers.add(number);
        }

        int[] LIS = new int[numbers.size()];
        int maxIndex = 0;

        LIS[0] = 1;
        for(int i = 1; i < numbers.size(); i++) {
            int lis = 1;
            int localMax = 1;
            for(int j = i-1; j >= 0; j--) {
                if(numbers.get(i) > numbers.get(j)) {
                    lis = LIS[j] + 1;
                    localMax = Math.max(localMax, lis);
                    //break; // break out of inner loop
                }
            }
            LIS[i] = localMax;
            if (LIS[maxIndex] < LIS[i]) {
                maxIndex = i;
            }
        }

        System.out.printf("%d%n", LIS[maxIndex]);
        System.out.printf("-%n");
        int seq = LIS[maxIndex];
        int[] result = new int[seq];
        for(int i = LIS.length - 1; i >= 0; i--){
            if(LIS[i] == seq) {
                result[seq-1] = numbers.get(i);

                seq -= 1;
            }
        }

        for(int i = 0; i < result.length; i++) {
        System.out.println(result[i]);
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
