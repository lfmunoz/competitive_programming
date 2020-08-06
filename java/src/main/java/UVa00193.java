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
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00193 uva = new UVa00193();
        //uva.runTest();
        uva.run();
    }
}

class UVa00193 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00193_in.txt";

    int max;
    String maxResult;
    List<Set<Integer>> adjList;

    int nodes;
    int edges;

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        int testCases = Integer.parseInt(scan.nextLine());

        for(int t = 0; t < testCases ; t++) {
            String[] config = scan.nextLine().split(" ");
            nodes = Integer.parseInt(config[0]);
            edges = Integer.parseInt(config[1]);

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

            max = 0;
            backtrack(1, new TreeSet<>());
            System.out.println(max);
            System.out.println(maxResult);

            if(testCases - 1 != t) scan.nextLine();
        }

    }

    public void backtrack(int idx, Set<Integer> result) {
      //    indent(idx);
      //    System.out.println(idx + " : "  + setToString(result));
        if(idx == nodes+1) {
            if(max < result.size()) {
                max  = result.size();
                maxResult = setToString(result);
            }
         //   System.out.println("result " + setToString(result));
            return;
        }

        // don't include
        backtrack(idx+1,result);
        // include
        if(!intersect(result, adjList.get(idx))) {
            result.add(idx);
            backtrack(idx+1, result);
            result.remove(idx);
        }
    }


    public boolean intersect(Set<Integer> a, Set<Integer> b) {
        long count = a.stream()
                .filter(b::contains).count();
        return (count > 0L);
    }

    public void indent(int N) {
        for(int i = 0; i < N; i++) {
            System.out.printf(" ");
        }
    }

    public String setToString(Set<Integer> mySet) {
        StringBuilder sb = new StringBuilder();
        for(Integer i: mySet) {
            sb.append(i + " ");
        }
        return sb.toString().trim();
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
