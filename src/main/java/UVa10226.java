/*

UVa10226 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10226

Runtime 

*/

package uva10226;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10226 uva = new UVa10226();
        //uva.runTest();
        uva.run();
    }
}


class UVa10226 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10226_in.txt";

    // TreeMap is implemented on the principles of red-black trees;
    // search, get, put and remove take logarithmic time O(log n)

    public void run() throws Exception {
            //Scanner scan =readFile(fileName);
            //Scanner scan =read();
            BufferedReader scan = readwithBuffer();

            Integer problems = Integer.parseInt(scan.readLine());
            scan.readLine(); // blank line
            for(int pIndx = 0; pIndx < problems; pIndx++) {
                TreeMap<String, Integer> treeMap = new TreeMap<>();
                Integer total = 0;
                String tree;
                while ((tree = scan.readLine()) != null) {
                    if(tree.isEmpty()) {
                        break;
                    }

                    if(treeMap.containsKey(tree)) {
                        treeMap.put(tree, treeMap.get(tree)+1);
                    } else {
                        treeMap.put(tree, 1);
                    }

                    total += 1;
                }
                for(Map.Entry<String, Integer> result : treeMap.entrySet()) {
                    System.out.printf("%s %.4f%n", result.getKey(), result.getValue() * 100.0 / total);
                }
                if (pIndx != problems-1) System.out.println();
            }
    }


    ////////////////////////////////////////////////////////////////////
    // Input/Output Specific Functions
    ////////////////////////////////////////////////////////////////////
    public Scanner read() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }

    /*
        br.readLine()
         while ((s = br.readLine()) != null) {
                         if (s.equals("")) {
                    break;
                }
     */
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
