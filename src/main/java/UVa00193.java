/*

UVa00193 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00193

Runtime 

*/

package uva00193;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00193 uva = new UVa00193();
        //uva.runTest();
        uva.run();
    }
}


class UVa00193 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00193_in.txt";

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
            compute(smallSquare, bigSquare);
        }
    }

    private void compute(char[][] smallSquare, char[][] bigSquare) {

        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                String submatrix = stringMatrix(bigSquare, y, x, n);
                if (submatrix != null ) {
                    if (submatrix.equals(deg0)) c0++;
                    if (submatrix.equals(deg90)) c90++;
                    if (submatrix.equals(deg180)) c180++;
                    if (submatrix.equals(deg270)) c270++;
                }
            }
        }
        System.out.println(c0 + " " + c90 + " " + c180 + " " + c270);
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
