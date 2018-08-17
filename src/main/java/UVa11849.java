/*

UVa11849 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11849

Runtime 

*/

package uva11849;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11849 uva = new UVa11849();
        //uva.runTest();
        uva.run();
    }
}


class UVa11849 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11849_in.txt";

    public void run() throws Exception {
        //Scanner scan =readFile(fileName);
        //Scanner scan =read();
        BufferedReader scan = readwithBuffer();
        while (true) {
            String cases = scan.readLine();
            String[] jackJill = cases.split(" ");
            int N = Integer.parseInt(jackJill[0]);
            int M = Integer.parseInt(jackJill[1]);
            if (N == 0 && M == 0) break;
            int total = 0;
            Set<Integer> accounting = new HashSet<>();
            for(int jack = 0; jack < N; jack++) {
                int cd = Integer.parseInt(scan.readLine());
                accounting.add(cd);
            }
            for(int jill = 0; jill < M; jill++) {
                int cd = Integer.parseInt(scan.readLine());
                if(accounting.contains(cd)) {
                    total += 1;
                    accounting.remove(cd);
                }
            }
            System.out.printf("%d%n", total);
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
