/*

UVa11790 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11790

Runtime 

*/

package uva11790;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11790 uva = new UVa11790();
        //uva.runTest();
        uva.run();
    }
}


class UVa11790 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11790_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (true) {
            String dimensions = scan.nextLine();
            String[] values = dimensions.split(" ");
            int N = Integer.parseInt(values[0]);
            int n = Integer.parseInt(values[1]);
            if (N == 0) break;

            char[][] bigSquare = new char[N][N];
            for(int x = 0; x < N; x++) {
                String row = scan.nextLine();
                bigSquare[x] = row.toCharArray();
            }
            char[][] smallSquare = new char[n][n];
            for(int x = 0; x < n; x++) {
                String row = scan.nextLine();
                smallSquare[x] = row.toCharArray();
            }
        //    compute(smallSquare, bigSquare);
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
