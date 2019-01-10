/*

UVa00193 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00193

Runtime 

*/

package uva00193;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00193 uva = new UVa00193();
        //uva.runTest();
        uva.run();
    }
}

class UVa00193 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00193_in.txt";


    int count;
    int max;
    Set<Integer> selected;
    List<Set<Integer>> adjList;

    public void run() {
        Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        //Scanner scan =read();

        int testCases = Integer.parseInt(scan.nextLine());

        for(int t = 0; t < testCases ; t++) {
            String[] config = scan.nextLine().split(" ");
            int nodes = Integer.parseInt(config[0]);
            int edges = Integer.parseInt(config[1]);

            adjList = new ArrayList<>();
            for(int n = 0; n < nodes+1; n++) {
                adjList.add(new HashSet<>());
            }

           // System.out.println(nodes);
            //System.out.println(edges);

            for (int e = 0; e < edges; e++) {
                String[] edgeIn = scan.nextLine().split(" ");
                int start = Integer.parseInt(edgeIn[0]);
                int end = Integer.parseInt(edgeIn[1]);

                adjList.get(start).add(end);
                adjList.get(end).add(start);
            }

            count = 0;
            max = 0;
            int[] numbers = IntStream.range(1, nodes+1).toArray();
            String maxResult = "N/A";

         //   for(int i = 1; i < adjList.size(); i++) {
                selected = new HashSet<>();
            //    selected.add(i);
                backtrack(numbers, 0, new ArrayList<>());
           //     if(count > max) {
          //          maxResult = selected.toString();
         //       }
         //   }


            //printAdjList(adjList);
            System.out.println(maxResult);

            if(testCases - 1 != t) System.out.println();
        }

    }

    public void backtrack(int[] myArr, int left, List<Integer> result) {
        //  indent(left);
        //  System.out.println(left + " : "  + listToString(result));
        if(left == myArr.length) {
            System.out.println(listToString(result));
            return;
        }

        // don't include
        backtrack(myArr, left+1,result);
        // include
        result.add(myArr[left]);
        backtrack(myArr, left+1, result);
        result.remove(result.size()-1);
    }


    public void printAdjList(List<Set<Integer>> adjList) {
        for(int i = 1 ; i < adjList.size(); i++) {
            //Set<Integer> list = adjList.get(i).toString();
            String set = adjList.get(i).toString();
            System.out.printf("%d : %s %n", i, set);
        }
    }

    public String listToString(List<Integer> myArr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < myArr.size(); i++) {
            sb.append(myArr.get(i) + " ");
        }
        return sb.toString();
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
