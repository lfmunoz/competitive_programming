/*

UVa11906 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11906

Runtime


Tricky part of this was realizing that when M = N you get double counting
on visited grids. Just wasn't immediately obvious to me.

*/

package uva11906;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11906 uva = new UVa11906();
        //uva.runTest();
        uva.run();
    }
}


class UVa11906 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11906_in.txt";

    final static int WATER = -1;
    final static int NOT_VISITED = 0;
    final static int VISITED = -2;
    final static int CURRENT = -3;

    int R;
    int C;
    int M;
    int N;
    int[][] grid;
    int even;
    int odd;

    public void run() {
        Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        //Scanner scan =read();

        int testCases = Integer.parseInt(scan.nextLine());
        for(int test = 0; test < testCases; test++) {
            int [] RCMN =  Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            R = RCMN[0]; // horizontal
            C = RCMN[1]; // vertical
            M = RCMN[2]; // movement vertically
            N = RCMN[3]; // movement horizontally

            grid = new int[R][C];
            even = 0;
            odd = 0;
            int W = Integer.parseInt(scan.nextLine());
            for(int w = 0; w < W; w++) {
                int [] XY =  Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                grid[XY[0]][XY[1]] = WATER;

            }
            if(M == N) {
                traverseMEqualsN(0, 0);
            } else if( M == 0) {
                traverseMEquals0(0, 0);
            } else if ( N == 0) {
                traverseNEquals0(0, 0);
            } else {
                traverse(0,0);
            }
            System.out.printf("Case %d: %d %d%n", test+1, even, odd);
            return;
        }
    }

    int traverse(int r, int c) {
        if(r >= R || r < 0) return 0;
        if(c >= C || c < 0) return 0;

        int value = grid[r][c];
        if(value == WATER) {
        //    System.out.printf("%d %d = exit %n", r, c );
            return 0;
        }
        if(value == VISITED) {
            return 1;
        }
        grid[r][c] = VISITED;

        int result  = traverse(r+M, c+N) +
                      traverse(r+M, c-N) +
                      traverse(r-M, c+N) +
                      traverse(r-M, c-N) +

                      traverse(r+N, c+M) +
                      traverse(r+N, c-M) +
                      traverse(r-N, c+M) +
                      traverse(r-N, c-M) ;

   //     System.out.printf("%d %d = %d %n", r, c, result);
        if(result % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        return 1;
    }

    int traverseMEqualsN(int r, int c) {
        if(r >= R || r < 0) return 0;
        if(c >= C || c < 0) return 0;

        int value = grid[r][c];
        if(value == WATER) {
            //    System.out.printf("%d %d = exit %n", r, c );
            return 0;
        }
        if(value == VISITED) {
            return 1;
        }
        grid[r][c] = VISITED;

        int result  =
                traverseMEqualsN(r+N, c+M) +
                traverseMEqualsN(r+N, c-M) +
                traverseMEqualsN(r-N, c+M) +
                traverseMEqualsN(r-N, c-M) ;

     //   System.out.printf("%d %d = %d %n", r, c, result);
        if(result % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        return 1;
    }

    int traverseMEquals0(int r, int c) {
        if(r >= R || r < 0) return 0;
        if(c >= C || c < 0) return 0;

        int value = grid[r][c];
        if(value == WATER) {
            //    System.out.printf("%d %d = exit %n", r, c );
            return 0;
        }
        if(value == VISITED) {
            return 1;
        }
        grid[r][c] = VISITED;

        int result  =
                traverseMEquals0(r+N, c) +
                traverseMEquals0(r-N, c);

        //   System.out.printf("%d %d = %d %n", r, c, result);
        if(result % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        return 1;
    }
    int traverseNEquals0(int r, int c) {
        if(r >= R || r < 0) return 0;
        if(c >= C || c < 0) return 0;

        int value = grid[r][c];
        if(value == WATER) {
            //    System.out.printf("%d %d = exit %n", r, c );
            return 0;
        }
        if(value == VISITED) {
            return 1;
        }
        grid[r][c] = VISITED;

        int result  =
                traverseNEquals0(r, c+M) +
                traverseNEquals0(r, c-M) ;

        //   System.out.printf("%d %d = %d %n", r, c, result);
        if(result % 2 == 0) {
            even++;
        } else {
            odd++;
        }
        return 1;
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
