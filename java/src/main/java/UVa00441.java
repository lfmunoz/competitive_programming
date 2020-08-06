/*

UVa00441 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00441

Runtime 

*/

package uva00441;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00441 uva = new UVa00441();
        //uva.runTest();
        uva.run();
    }
}


class UVa00441 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00441_in.txt";

    public void run() {
       // Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        String inData = scan.nextLine();
        while (true) {
            int[] testCase = Arrays.stream(inData.split(" ")).mapToInt(Integer::parseInt).toArray();

            int k = testCase.length -1;
            for(int a = 0; a < k - 5; a++) {
                for(int b = a + 1; b < k - 4; b++) {
                    for (int c = b + 1; c < k - 3; c++) {
                        for (int d = c + 1; d < k - 2; d++) {
                            for (int e = d + 1; e < k - 1; e++) {
                                for (int f = e + 1; f < k; f++) {
                                    System.out.printf("%d %d %d %d %d %d%n",
                                            testCase[a+1], testCase[b+1], testCase[c+1], testCase[d+1], testCase[e+1], testCase[f+1]);
                                }
                            }
                        }
                    }
                }
            }

            inData = scan.nextLine();
            if(inData.equals("0")) break;
            System.out.println();

        }
    }


    public String outData(int[] numbers, int mask) {
        StringBuilder result = new StringBuilder();
        for(int x = 0; x < numbers.length - 1; x++) {
            int tmp = 1 << (x) & mask;
            if(tmp != 0) {
                result.append(numbers[x+1]);
                result.append(" ");
            }
        }
        return result.toString().trim();

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
