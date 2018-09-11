/*

UVa10895 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10895

transpose adjacency list

*/

package uva10895;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10895 uva = new UVa10895();
        //uva.runTest();
        uva.run();
    }
}


class UVa10895 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10895_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();
        while(scan.hasNextLine()) {
            String[] matrix = scan.nextLine().split(" ");
            int m = Integer.parseInt(matrix[0]);
            int n = Integer.parseInt(matrix[1]);

            List<List<Map.Entry<Integer, Integer>>> adj = new ArrayList<>();

            for (int row = 0; row < m; row++) {
                String[] idxList = scan.nextLine().split(" ");
                String[] valueList = scan.nextLine().split(" ");
                int nonZeroCol = Integer.parseInt(idxList[0]);
                List<Map.Entry<Integer, Integer>> rowList = new ArrayList<>();
                adj.add(rowList);

                for (int idx = 0; idx < nonZeroCol; idx++) {
                    int col = Integer.parseInt(idxList[idx + 1]);
                    int val = Integer.parseInt(valueList[idx]);
                    rowList.add(new AbstractMap.SimpleEntry<>(col, val));
                }
            }


            List<List<Map.Entry<Integer, Integer>>> transpose = new ArrayList<>();

            // the transpose
            for (int col = 0; col < n; col++) {
                List<Map.Entry<Integer, Integer>> colList = new ArrayList<>();
                transpose.add(colList);

                for (int row = 0; row < m; row++) {
                    List<Map.Entry<Integer, Integer>> items = adj.get(row);
                    for (int item = 0; item < items.size(); item++) {
                        Map.Entry<Integer, Integer> entry = items.get(item);
                        if (entry.getKey() - 1 == col) {
                            colList.add(new AbstractMap.SimpleEntry<>(row, entry.getValue()));
                            break;
                        }

                        if (entry.getKey() - 1 > col) {
                            break;
                        }
                    }
                }

            }

            System.out.printf("%d %d%n", n, m);
            for (int col = 0; col < n; col++) {

                List<Map.Entry<Integer, Integer>> rowList = transpose.get(col);
                StringBuilder row1 = new StringBuilder(String.valueOf(rowList.size()));
                StringBuilder row2 = new StringBuilder();
                row1.append(" ");
                for (int idx = 0; idx < rowList.size(); idx++) {
                    Map.Entry<Integer, Integer> entry = rowList.get(idx);
                    row1.append(entry.getKey()+1);
                    row2.append(entry.getValue());
                    if (idx + 1 != rowList.size()) {
                        row1.append(" ");
                        row2.append(" ");
                    }
                }
                System.out.println(row1.toString().trim());
                System.out.println(row2);

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
