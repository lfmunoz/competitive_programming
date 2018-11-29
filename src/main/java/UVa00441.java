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
        Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        //Scanner scan =read();

        while (true) {
            String inData = scan.nextLine();
            if(inData.equals("0")) break;
            int[] testCase = Arrays.stream(inData.split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println();

            int max = (1 << testCase.length- 1) - 1;
            for(int x = 0; x < max; x++) {
                if(Integer.bitCount(x) == 6) {
                    System.out.println(outData(testCase, x));
                }
            }

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
