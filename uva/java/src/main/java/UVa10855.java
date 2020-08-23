/*

UVa10855 - Rotated Square

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10855

Runtime 0.130

 */

package uva10855;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10855 uva = new UVa10855();
        //uva.runTest();
        uva.run();
    }
}


class UVa10855 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10855_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
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
        int n = smallSquare.length;
        int N = bigSquare.length;
        String deg0 = stringMatrix(smallSquare, 0, 0, n);
        rotate(smallSquare);
        String deg90 = stringMatrix(smallSquare, 0, 0, n);
        rotate(smallSquare);
        String deg180 = stringMatrix(smallSquare, 0, 0, n);
        rotate(smallSquare);
        String deg270 = stringMatrix(smallSquare, 0, 0, n);

        int c0 = 0;
        int c90 = 0;
        int c180 = 0;
        int c270 = 0;

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

    // inplace 90 degree rotation
    private void rotate(char[][] matrix) {
       transpose(matrix);
       for (int x = 0; x < matrix.length; x++) {
           reverseArray(matrix[x]);
       }
    }

    // only works for square matrices
    private void transpose(char[][] matrix) {
        int start = 1;
        for (int x = 0; x < matrix.length-1; x++){
            for (int y = start; y < matrix[x].length; y++){
                char tmp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = tmp;
            }
            start++;
        }
    }

    private void reverseArray(char[] list) {
        for (int x = 0; x < list.length/2; x++) {
            char temp = list[x];
            list[x] = list[list.length-1-x];
            list[list.length-1-x] = temp;
        }
    }

    private void print(char[][] matrix) {
        for (int x = 0; x < matrix.length; x++){
            for (int y = 0; y < matrix[x].length; y++){
                System.out.print(matrix[x][y]);
            }
            System.out.println("");
        }
    }

    private String stringMatrix(char[][] matrix, int xp, int yp, int size) {
        int max = matrix.length;

        char[] char_list = new char[size*size];

        if (xp+size > max || yp+size > max) {
            return null;
        }
        int i = 0;
        for(int x = xp; x < xp+size; x++) {
            for (int y = yp; y < yp+size; y++) {
                char_list[i] = matrix[x][y];
                i += 1;
            }
        }

        return new String(char_list);
    }

    ////////////////////////////////////////////////////////////////////
    // Input/Output Specific Functions
    ////////////////////////////////////////////////////////////////////
    public Scanner read() {
        Scanner scan = new Scanner(System.in);
        return scan;
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
