/*

UVa11085 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11085

Runtime 

*/

package uva11085;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11085 uva = new UVa11085();
        //uva.runTest();
        uva.run();
    }
}


class UVa11085 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11085_in.txt";
    static final int N = 8;

    int minMoves;

    public void run() {
       // Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();


        int caseNumber = 1;
        while (scan.hasNextLine()) {
            int[] qPos = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int board[][] = new int[N][N];
            for(int i = 0; i < N; i++) {
                board[qPos[i]-1][i] = 1;
            }

            minMoves =  Integer.MAX_VALUE;

       //     printSolution(board);
        //    System.out.println();

            // find minimum number of moves
            solveNQUtil(board, 0, 0);
            System.out.printf("Case %d: %d%n", caseNumber, minMoves);
            caseNumber++;
        //    return;
            //

        }
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }


    boolean solveNQUtil(int board[][], int col, int moves) {

      //  if (col == 1) {
       //     System.out.printf("col = %d, moves= %d %n", col, moves);
      //  printSolution(board);
       // System.out.println();
   // }
        /* base case: If all queens are placed
           then return true */
        if (col >= N) {
           // System.out.printf("DONE col = %d, moves= %d %n", col, moves);
            if(minMoves > moves) {
                minMoves = moves;
            }
            return true;
        }

        /* Consider this column and try placing
           this queen in all rows one by one */

        int row = findQ(board, col);
        board[row][col] = 0;
        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if(row != i) {
                    moves++;
                }
                solveNQUtil(board, col + 1, moves);
                board[i][col] = 0; // BACKTRACK
                if(row != i) {
                    moves--;
                }
            }
        }
        board[row][col] = 1;
        return false;
    }

    int findQ(int board[][], int col) {
        for(int x = 0; x < N; x++) {
            if(board[x][col] == 1) {
                return x;
            }
        }
        return -1;
    }


    /* A utility function to print solution */
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
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
