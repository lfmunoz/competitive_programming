/*

UVa00599 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00599

(v−e = number of connected
components, keep a bitset of size 26 to count the number of vertices that
have some edge. Note: Also solvable with Union-Find)

https://www.youtube.com/watch?v=5a8kGBnOqHU
https://www.programcreek.com/2014/05/leetcode-number-of-connected-components-in-an-undirected-graph-java/
https://www.coursera.org/lecture/algorithms-part2/connected-components-Dzl65
*/

package uva00599;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00599 uva = new UVa00599();
        //uva.runTest();
        uva.run();
    }
}


class UVa00599 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00599_in.txt";

    public void run() {
        Scanner scan =readFile(fileName);
        //Scanner scan =read();

        int problems = Integer.parseInt(scan.nextLine());
        for(int prob = 0; prob < problems; prob++) {
            while (true) {
                String inputLine = scan.nextLine();
                if(inputLine.charAt(0) == '*') break;
                System.out.println(inputLine);


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
