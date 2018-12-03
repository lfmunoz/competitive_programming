/*

UVa10102 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10102

Runtime 

*/

package uva10102;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10102 uva = new UVa10102();
        //uva.runTest();
        uva.run();
    }
}


class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



class UVa10102 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10102_in.txt";



    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (scan.hasNextLine()) {
            int M = Integer.parseInt(scan.nextLine());
            int[][] matrix = new int[M][M];

            List<Pair> onePosition = new ArrayList<>();
            List<Pair> threePosition = new ArrayList<>();

            for(int x = 0; x < M; x++) {
               int[] row = Arrays.stream(scan.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
               for(int y = 0; y < M; y++) {
                   matrix[x][y] = row[y];
                   if(row[y] == 1) {
                       onePosition.add(new Pair(x,y));
                   }
                   if(row[y] == 3) {
                       threePosition.add(new Pair(x,y));

                   }
               }
            }

            int globalMax = 0;
            for(Pair start: onePosition) {
                int localMin = Integer.MAX_VALUE;
                for(Pair end: threePosition) {
                    int result = manhattanDistance(start, end);
                    localMin = Math.min(localMin, result);
                }
                globalMax = Math.max(globalMax, localMin);
            }
            System.out.printf("%d%n", globalMax);
        }
    }

    public int manhattanDistance(Pair start, Pair end) {
        int xdiff = Math.abs(end.x - start.x);
        int ydiff = Math.abs(end.y - start.y);

        return xdiff + ydiff;
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
