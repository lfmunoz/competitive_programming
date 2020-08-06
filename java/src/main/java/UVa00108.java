/*

UVa00108 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00108

Runtime 

*/

package uva00108;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00108 uva = new UVa00108();
        //uva.runTest();
        uva.run();
    }
}


class UVa00108 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00108_in.txt";

    int[][] matrix;

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (scan.hasNext()) {
            int squareSize = scan.nextInt();

            matrix = new int[squareSize][squareSize];
            for(int y = 0; y < squareSize; y++) {
                for(int x = 0; x < squareSize; x++) {
                    int nextValue = scan.nextInt();

                    if(x == 0 && y == 0) {
                        matrix[y][x] = nextValue;
                    } else if(x > 0 && y == 0) {
                        matrix[y][x] = matrix[y][x-1] + nextValue;
                    } else if(x == 0 && y > 0) {
                        matrix[y][x] = matrix[y-1][x] + nextValue;
                    } else if(x > 0 && y > 0) {
                        matrix[y][x] = matrix[y][x-1] + matrix[y-1][x] - matrix[y-1][x-1] + nextValue;
                    } else {
                        System.out.println("error!");
                    }


                }
            }

            int maxSubRect = -127*100*100;
            for(int y0 = 0; y0 < squareSize; y0++) {
                for(int x0 = 0; x0 < squareSize; x0++) {
                    for(int y1 = y0; y1 < squareSize; y1++) {
                        for(int x1 = x0; x1 < squareSize; x1++) {

                           // System.out.printf("x0= %d y0= %d, x1=%d y1=%d ", x0, y0, x1, y1);

                            int result = 0;
                            if(x0==0 && y0==0) {
                                result = matrix[y1][x1];
                                maxSubRect = Math.max(maxSubRect, result);
                            } else if (x0 == 0 && y0 > 0 ) {
                                result = matrix[y1][x1] - matrix[y0-1][x1];
                                maxSubRect = Math.max(maxSubRect, result);
                            } else if ( x0 > 0 && y0 == 0) {
                                result = matrix[y1][x1] - matrix[y1][x0-1];
                                maxSubRect = Math.max(maxSubRect, result);
                            } else if (x0 > 0 && y0 > 0) {
                                result = matrix[y1][x1] - matrix[y0-1][x1] - matrix[y1][x0-1] + matrix[y0-1][x0-1];
                                maxSubRect = Math.max(maxSubRect, result);
                            } else {
                                System.out.println("ERROR invalid condition");
                            }
                          //  System.out.printf( "result = %d %n", result);


                        }
                    }
                }
            }


            System.out.printf("%d%n", maxSubRect);

            //return;
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
