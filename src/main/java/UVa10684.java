/*

UVa10684 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10684

Runtime 

*/

package uva10684;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10684 uva = new UVa10684();
        //uva.runTest();
        uva.run();
    }
}


class UVa10684 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10684_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (true) {
            int nums = scan.nextInt();
            if(nums == 0 ) break;
            List<Integer> values = new ArrayList<>();
            for(int i = 0; i < nums; i++) {

                int v= scan.nextInt();
                values.add(v);
            }

            int sum = 0;
            int max = -1;
            for(int start = 0; start < nums; start++) {
                sum += values.get(start);
                if (sum > max) {
                    max = sum;
                } else if(sum < 0) {
                    sum = 0;
                }
            }
            if(max > 0) {
               System.out.printf("The maximum winning streak is %d.%n", max);
            } else {
                System.out.printf("Losing streak.%n");
            }

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
