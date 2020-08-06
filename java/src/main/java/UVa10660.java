/*

UVa10660 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10660

Runtime 

*/

package uva10660;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10660 uva = new UVa10660();
        //uva.runTest();
        uva.run();
    }
}


class UVa10660 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10660_in.txt";

    int[][] matrix;

    public void run() {
        //Scanner scan = readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        //System.out.printf("%d %d %d %n", row(4), row(7), row(24));
       // System.out.printf("%d %d %d %n", col(4), col(7), col(24));


        //permutations();
        int testCases = Integer.parseInt(scan.nextLine());
        for(int t = 0; t < testCases; t++) {
            matrix = new int[5][5];
            int rows = Integer.parseInt(scan.nextLine());
            for(int r = 0; r < rows; r++) {
                int[] row = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();
                matrix[row[0]][row[1]] = row[2];
            }

            double min = Double.MAX_VALUE;
            String output = "";
            for(int a = 0; a < 25; a++) {
                for(int b = a+1; b < 25; b++) {
                    for (int c = b+1; c < 25; c++) {
                        for (int d = c+1; d < 25; d++) {
                            for (int e = d+1; e < 25; e++) {
                                int total = 0;
                                for(int x = 0; x < 25; x++) {
                                    int minDistance = Integer.MAX_VALUE;
                                    minDistance = (minDistance > distance(x, a)) ? distance(x, a) : minDistance;
                                    minDistance = (minDistance > distance(x, b)) ? distance(x, b) : minDistance;
                                    minDistance = (minDistance > distance(x, c)) ? distance(x, c) : minDistance;
                                    minDistance = (minDistance > distance(x, d)) ? distance(x, d) : minDistance;
                                    minDistance = (minDistance > distance(x, e)) ? distance(x, e) : minDistance;
                                    int xstart = x / 5;
                                    int ystart = x % 5;
                                    total += minDistance * matrix[xstart][ystart];
                                }
                                if(total < min) {
                                    min = total;
                                    output = String.format("%d %d %d %d %d", a, b, c, d, e);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(output);

        }

    }

    public void permutations() {
        for(int a = 0; a < 5; a++) {
            for (int b = a + 1; b < 5; b++) {
                for (int c = b + 1; c < 5; c++) {

                    System.out.printf("%d %d %d %n", a, b, c);
                }

            }
        }
    }

    public int distance(int start, int office) {
        int xstart = start / 5;
        int ystart = start % 5;
        int xoffice = office / 5;
        int yoffice = office % 5;
        return Math.abs(xoffice-xstart) + Math.abs(yoffice-ystart);
    }

    public int value(int start, int office) {
        int xstart = start % 5;
        int ystart = start / 5;
        if(start == office) {
            return matrix[xstart][ystart];
        }
        int xoffice = office % 5;
        int yoffice = office / 5;
        int distance = Math.abs(xoffice-xstart) + Math.abs(yoffice-ystart);
        return matrix[xstart][ystart] * distance;
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
