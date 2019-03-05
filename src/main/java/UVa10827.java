/*

UVa10827 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10827

Runtime 

*/

package uva10827;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10827 uva = new UVa10827();
        //uva.runTest();
        uva.run();
    }
}


class UVa10827 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10827_in.txt";

    int[][] matrix;
    int[][] inputMatrix;

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        int testCases = scan.nextInt();
        for(int t = 0; t < testCases; t++) {
            int squareSize = scan.nextInt();
            if(1 == squareSize) {
                System.out.printf("%d%n", scan.nextInt());
                continue;
            }
            int newSize = (squareSize - 2) + squareSize;
            inputMatrix = new int[newSize][newSize];
            matrix = new int[newSize][newSize];

            for(int y = 0; y < squareSize; y++) {
                for(int x = 0; x < squareSize; x++) {
                    int nextValue = scan.nextInt();
                    inputMatrix[y][x] = nextValue;
                }
            }

            for(int y = 0; y < squareSize; y++) {
                for(int x = 0; x < squareSize-2; x++) {
                    inputMatrix[y][squareSize+x] = inputMatrix[y][x];
                }
            }

            for(int y = 0; y < squareSize-2; y++) {
                for(int x = 0; x < squareSize; x++) {
                    inputMatrix[squareSize+y][x] = inputMatrix[y][x];
                }
            }

            for(int y = 0; y < squareSize-2; y++) {
                for(int x = 0; x < squareSize-2; x++) {
                    inputMatrix[squareSize+y][squareSize+x] = inputMatrix[y][x];
                }
            }

            for(int y = 0; y < newSize; y++) {
                for(int x = 0; x < newSize; x++) {
                    int nextValue = inputMatrix[y][x];

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
                    int y0Finish = squareSize;
                    int x0Finish = squareSize;
                    if(y0 > 1) {
                       y0Finish = squareSize  + y0 -1;
                    }
                    if(x0 > 1) {
                        x0Finish = squareSize  + x0 -1;
                    }
                    for(int y1 = y0; y1 < y0Finish; y1++) {
                        for(int x1 = x0; x1 < x0Finish; x1++) {

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




           // System.out.printf("done %n");
           System.out.printf("%d%n", maxSubRect);

        //    return;
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
