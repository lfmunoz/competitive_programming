/*

UVa11991 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11991

Runtime 

*/

package uva11991;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11991 uva = new UVa11991();
        //uva.runTest();
        uva.run();
    }
}


class UVa11991 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11991_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        while (scan.hasNext()) {
            String dimensions = scan.nextLine();
            String[] nm = dimensions.split(" ");
            int n = Integer.parseInt(nm[0]); // number of elements in array
            int m = Integer.parseInt(nm[1]); // number of queries

            String[] numArray = scan.nextLine().split(" ");
            Map<Integer, List<Integer>> adjList = new HashMap<>();
           for(int idx = 0; idx < numArray.length; idx++) {
               Integer number = Integer.parseInt(numArray[idx]);
               if( adjList.containsKey(number)) {
                   List<Integer> positionList = adjList.get(number);
                   positionList.add(idx);
               } else {
                   List<Integer> positionList = new ArrayList<>();
                   positionList.add(idx);
                   adjList.put(number, positionList);
               }
           }

            for(int line = 0; line < m; line++) {
                String[] kv = scan.nextLine().split(" ");
                int k = Integer.parseInt(kv[0]); // position
                int v = Integer.parseInt(kv[1]); // value
                List<Integer> positionList = adjList.get(v);
                if(adjList.containsKey(v) && positionList.size() >= k) {
                    System.out.println(positionList.get(k-1) + 1);
                } else {
                    System.out.println("0");

                }
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
