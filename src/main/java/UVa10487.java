/*

UVa10487 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10487

Runtime 

*/

package uva10487;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10487 uva = new UVa10487();
        //uva.runTest();
        uva.run();
    }
}


class UVa10487 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10487_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        int idxCase = 0;

        while (true) {
            int n = Integer.parseInt(scan.nextLine());
            if(n == 0) break;
            idxCase++;
            System.out.printf("Case %d:%n", idxCase);

            List<Integer> numArr = new ArrayList();
            for(int i = 0; i < n; i++) {
                int num = Integer.parseInt(scan.nextLine());
                numArr.add(num);
            }
            Collections.sort(numArr);
            int m = Integer.parseInt(scan.nextLine());
            for(int i = 0; i < m; i++) {
                int num = Integer.parseInt(scan.nextLine());
                doQuery(numArr, num);
            }
        }
    }

    public void doQuery(List<Integer> numArr, int query) {
        int sumClosest = numArr.get(0) + numArr.get(1);
        for(int x = 0; x < numArr.size()-1; x++) {
            for(int y = x+1; y < numArr.size(); y++) {
               int sum = numArr.get(x) + numArr.get(y);
               if(Math.abs(sum - query) < Math.abs(sumClosest - query)) {
                   sumClosest = sum;
               }
            }
        }
        System.out.printf("Closest sum to %d is %d.%n", query, sumClosest);
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
