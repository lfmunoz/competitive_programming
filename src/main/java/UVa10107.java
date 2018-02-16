/*

UVa10107 - What is the Median?

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1048
https://www.udebug.com/UVa/10107


https://stackoverflow.com/questions/7019872/whats-the-equivalent-nth-element-function-in-java
https://en.wikipedia.org/wiki/Selection_algorithm
https://stackoverflow.com/questions/251781/how-to-find-the-kth-largest-element-in-an-unsorted-array-of-length-n-in-on
http://cs.indstate.edu/~spitla/abstract2.pdf
*/

package uva10107;

// Copy-paste from here...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10107 uva = new UVa10107();
        //uva.runTest();
        uva.run();
    }
}


class UVa10107 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10107_in.txt";

    public void run() {
        Scanner scan =readFile(fileName);
        //Scanner scan =read();

        while (scan.hasNext()) {
            int num = scan.nextInt();
            compute(num);
        }
    }

    private void compute(int num)
    {
        System.out.println(num);
    }

    ////////////////////////////////////////////////////////////////////
    // Input/Output Specific Functions
    ////////////////////////////////////////////////////////////////////
    public Scanner read() {
        Scanner scan = new Scanner(System.in);
        return scan;
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
