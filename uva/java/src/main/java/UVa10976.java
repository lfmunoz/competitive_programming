/*

UVa10976 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10976

Runtime 

*/

package uva10976;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10976 uva = new UVa10976();
        //uva.runTest();
        uva.run();
    }
}


class UVa10976 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10976_in.txt";

    public void run() throws Exception {
        //Scanner scan =readFile(fileName);
        BufferedReader scan =readwithBuffer(); // use readLine()
        //Scanner scan =read();

        String line = scan.readLine();
        while (line != null) {
            int z = Integer.parseInt(line);
            List<String> results = new ArrayList<>();
            for(int y = z+1; y <= z*2; y++) {
                double numerator = z * y;
                double denominator = y - z;
                if( numerator % denominator == 0) {
                    int solution = (int) numerator / (int) denominator;
                    results.add(String.format("1/%d = 1/%d + 1/%d", z, solution, y));
                }
            }
            System.out.println(results.size());
            results.forEach(item -> {
                System.out.println(item);
            });
            line = scan.readLine();
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
