/*

UVa11503 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11503

Runtime 

*/

package uva11503;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11503 uva = new UVa11503();
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
    public int size (int p) {
        int root = find(p);
        return sz[root];
    }



    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
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


}

class UVa11503 {
    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11503_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        int numberTestCases = Integer.parseInt(scan.nextLine());

        for(int testCase = 0; testCase < numberTestCases; testCase++) {
            int F = Integer.parseInt(scan.nextLine()); // number of friendships formed (max 100,000)

            UnionFind uf = new UnionFind(100000);
            int symbolCount = 0;
            Map<String, Integer> symbolTable = new HashMap<>();

            for(int conn = 0; conn < F; conn++) {
                String[] friends = scan.nextLine().split(" ");
                int friend0 = 0;
                int friend1 = 0;

                if(symbolTable.containsKey(friends[0])) {
                   friend0 = symbolTable.get(friends[0]);
                } else {
                    friend0 = symbolCount++;
                   symbolTable.put(friends[0], friend0);
                }

                if(symbolTable.containsKey(friends[1])) {
                    friend1 = symbolTable.get(friends[1]);
                } else {
                    friend1 = symbolCount++;
                    symbolTable.put(friends[1], friend1);
                }

                uf.union(friend0, friend1);
                System.out.println(uf.size(friend0));
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
