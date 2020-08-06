/*

UVa00793 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00793



(trivial; application of disjoint sets)
pg88

*/

package uva00793;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00793 uva = new UVa00793();
        //uva.runTest();
        uva.run();
    }
}

class UnionFind {

    public int[] id;
    public int[] sz;
    public UnionFind(int n) {
        sz = new int[n];
        id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        while(p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
   // public
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if( rootP == rootQ ) return;
        id[rootP] = rootQ;
    }
}

class UVa00793 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00793_in.txt";

    public void run() {
       // Scanner scan =readFile(fileName);
        Scanner scan =read();
        //BufferedReader scan =readwithBuffer();

        Integer cases = Integer.parseInt(scan.nextLine());

        // blank line
        scan.nextLine();
        for(int cidx = 0; cidx < cases; cidx++) {
            Integer computers = Integer.parseInt(scan.nextLine());
            UnionFind uf = new UnionFind(computers+1);
            int yesAnswers = 0;
            int noAnswers = 0;
            while(scan.hasNext()) {
                String nextLine = scan.nextLine();
                if(nextLine.trim().isEmpty()) break;
                String[] line = nextLine.split(" ");
                boolean command = (line[0].equals("c")) ? true : false;
                int a = Integer.parseInt(line[1]);
                int b = Integer.parseInt(line[2]);
                if(command) {
                    uf.union(a, b);
                } else {
                    if(uf.connected(a,b)) {
                        yesAnswers++;
                    } else {
                        noAnswers++;
                    }
                }
            }
            System.out.printf("%d,%d%n", yesAnswers, noAnswers);
            if(cidx+1 != cases) {
                System.out.println();
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
