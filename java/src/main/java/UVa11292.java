/*

UVa11292 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11292

Runtime 

*/

package uva11292;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11292 uva = new UVa11292();
        //uva.runTest();
        uva.run();
    }
}


class UVa11292 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11292_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (true) {
            int[] nm = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int heads = nm[0]; // n
            int knights = nm[1]; // m
            if (heads == 0 && knights == 0) break;
            List<Integer> headSizes = new ArrayList<>(heads);
            List<Integer> knightHeights = new ArrayList<>(knights);
            for(int i = 0; i < heads; i++) {
                int size = Integer.parseInt(scan.nextLine()); // centimeters
                headSizes.add(size);
            }
            for(int i = 0; i < knights; i++) {
                int height = Integer.parseInt(scan.nextLine()); // centimeters
                knightHeights.add(height);
            }

            if(heads > knights) {
                System.out.println("Loowater is doomed!");
                break;
            }

            Collections.sort(headSizes);
            Collections.sort(knightHeights);
            int result = compute(headSizes, knightHeights);
            if(result > 0) {
                System.out.println(result);
            } else {
                System.out.println("Loowater is doomed!");
            }
        }
    }

    private int compute(List<Integer> headSizes, List<Integer> knightHeights) {
        Iterator<Integer> itr = knightHeights.iterator();
        int totalGold = 0;
        for(int i = 0; i < headSizes.size(); i++ ) {
            int head = headSizes.get(i);
            while(true) {
                if(itr.hasNext()) {
                    int height = itr.next();
                    if(height >= head) {
                        totalGold += height;
                        break;
                    }
                } else {
                    return -1;
                }
            }
        }
        return totalGold;
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
