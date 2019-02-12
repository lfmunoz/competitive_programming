/*

UVa11157 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11157

Runtime 

*/

package uva11157;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11157 uva = new UVa11157();
        //uva.runTest();
        uva.run();
    }
}

class Rock {

    int size;
    boolean isSmall;

   public Rock(String v) {
       String[] tmp = v.split("-");
       isSmall = tmp[0].equals("S");
       size = Integer.parseInt(tmp[1]);
   }
}


class UVa11157 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11157_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (scan.hasNextLine()) {
            int T = Integer.parseInt(scan.nextLine()); // T - number of test cases
            for(int c = 1; c < T+1; c++) {
                int[] ND = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int N = ND[0]; // N stones
                int D = ND[1]; // distance of bank
                List<Integer> rocks = new ArrayList<>();
                rocks.add(0);
                rocks.add(0);
                String[] itemList = scan.nextLine().split(" ");
                for(String item : itemList) {
                    String[] value = item.split("-");
                    if(value[0].equals("B")) {
                       rocks.add(Integer.parseInt(value[1]));
                    }
                    rocks.add(Integer.parseInt(value[1]));
                }
                rocks.add(D);
                rocks.add(D);
                int max = -100000;
                for(int i = 2; i < rocks.size(); i++) {
                    max = Math.max(max, rocks.get(i) - rocks.get(i-2));
                }


                // output minimized maximum leap.
                System.out.printf("Case %d: %d%n", c, max);
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
