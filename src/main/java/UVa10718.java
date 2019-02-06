/*

UVa10718 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10718

Runtime 

*/

package uva10718;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10718 uva = new UVa10718();
        //uva.runTest();
        uva.run();
    }
}


class UVa10718 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10718_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (scan.hasNextLine()) {
            long[] NLU = Arrays.stream(scan.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long N = NLU[0]; // given integer
            long L = NLU[1]; // lower limit
            long U = NLU[2]; // upper limit

            //boolean[] M = new boolean[32];

            //boolean[] NBinary = intToboolean(N);
            long M = 0;

            int i = 31;
            for(; i >= 0; i--) {
                long value = (long) 1 << i;
                long tmp = value | M;
                if( tmp <= U) {
                  //  M = tmp;
                    break;
                }
            }
            for(; i >= 0; i--) {
                long value = (long) 1 << i;
                long tmp = value | M;
                if( (N & value) != 0 && tmp > L) {
                    continue;
                }
                if( tmp <= U) {
                    M = tmp;
                }
            }

            System.out.println(M);
        }


    }

    boolean isBitSet(int value, int bit) {
        return (((value >>> bit) & 1) != 0);
    }


    boolean[] intToboolean(int number) {
        boolean[] bits = new boolean[32];
        /*
        for (int i = 31; i >= 0; i--) {
            bits[i] = (number & (1 << i)) != 0;
        }
        */
        for (int i = 0; i < 32; i++) {
            bits[i] = (number & (1 << i)) != 0;
        }
        return bits;
    }



    int booleansToInt(boolean[] arr){
        int n = 0;
        for (boolean b : arr)
            n = (n << 1) | (b ? 1 : 0);
        return n;
    }

    void printBooleanArray(boolean[] arr) {
        for (int i = 31; i >= 0; i--) {
            int value = (arr[i] ? 1 : 0);
            System.out.print(value);
        }
        System.out.println();

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
