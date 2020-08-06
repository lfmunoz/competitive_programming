/*

UVa10819 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10819

Runtime 

*/

package uva10819;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10819 uva = new UVa10819();
        //uva.runTest();
        uva.run();
    }
}


class UVa10819 {
    static void print2D(int[][] arr) {
        for(int x = 0; x < arr.length; x++) {
            for(int y = 0; y < arr[x].length; y++) {
                System.out.printf("%d %d = %d %n", x, y, arr[x][y]);
            }
        }
    }

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10819_in.txt";

    int m = 0; // 0 to 10_000
    int n = 0; // 0 to 100
    int O[][] = new int[101][11000];
    int v[] = new int[101]; // value
    int w[] = new int[101]; // weight

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (scan.hasNext()) {
            String[] values = scan.nextLine().split(" ");
            m = Integer.parseInt(values[0]); // money
            n = Integer.parseInt(values[1]); // items

            for (int[] row: O)
                Arrays.fill(row, -1);

            for(int idx = 0; idx < n; idx++) {
                String[] item = scan.nextLine().split(" ");
                int p = Integer.parseInt(item[0]); // price of item
                int f = Integer.parseInt(item[1]); // favour index
                w[idx] = p; // 1 to 4000
                v[idx] = f; // 1 to 5
            }
            System.out.println(val(0, 0));
        }
    }

    int val(int i, int wt) {
       // weight is more than our capacity, and our capacity is less than 1800
        //  this means we cannot take anything else
       if(wt > m && m < 1800) return -100;
       // weight is more than anything we could ever take, even with the extra 200
       if(wt > m + 200) return -100;

       // we are at the last item
       if(i == n) {
           // weight is more than we can carry, and wt doesn't allow extra 200
           if( wt > m && wt <= 2000) return -100;
           return 0; // we have considered all items
       }
       if (O[i][wt] != -1) {
        return O[i][wt];
       }
       O[i][wt] = Math.max(val(i+1, wt), v[i] + val(i+1, wt + w[i]));
       return O[i][wt];
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
