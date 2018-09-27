/*

UVa10507 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10507

Runtime 

*/

package uva10507;

// Copy-paste from here...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10507 uva = new UVa10507();
        //uva.runTest();
        uva.run();
    }
}

class UnionFind {
    private int[] parent;  // parent[i] = parent of i
    private int[] sz; // array to count number of objects in the tree rooted at i
    private int count;     // number of components


    public UnionFind(int n) {
        parent = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }


    public int count() {
        return count;
    }


    public int find(int p) {
        while (p != parent[p])
            p = parent[p];
        return p;
    }


    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if(sz[rootP] < sz[rootQ]) {
            parent[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            parent[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
        count--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("idx  parent  sz \n");
        for(int i = 0; i < parent.length; i++) {
            sb.append(String.valueOf(i) + "    " +
                    String.valueOf(parent[i]) + "       " +
                    String.valueOf(sz[i]) + "\n");
        }
        return sb.toString();
    }
}

class UVa10507 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10507_in.txt";

    public void run() {
        Scanner scan = readFile(fileName);
        //Scanner scan =read();

        while (true) {
            Integer N = Integer.parseInt(scan.nextLine()); // number of slept areas
            Integer M = Integer.parseInt(scan.nextLine()); // connections

            UnionFind uf = new UnionFind(26);
            String[] wakeUpAreas = scan.nextLine().split("");

            IntStream.range(0, wakeUpAreas.length-1).forEach( intVal -> {
                uf.union(stringToInt(wakeUpAreas[intVal]), stringToInt(wakeUpAreas[intVal+1]));
                System.out.println(stringToInt(wakeUpAreas[intVal]) + " " + stringToInt(wakeUpAreas[intVal+1]));
            });


            for (int i = 0; i < M; i++) {
                String[] connections = scan.nextLine().split("");
              //  uf.union(stringToInt(connections[0]), stringToInt(connections[1]));
            }

           // uf.finish();

            if(scan.hasNext()) {
                scan.nextLine();
            } else {
                break;
            }


        }

    }

    public int stringToInt(String c) {
        return Character.getNumericValue(c.charAt(0)) - 10;
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
            return scan;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
