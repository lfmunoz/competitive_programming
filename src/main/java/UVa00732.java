/*

UVa00732 - Anagram by Stack

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/732

Runtime 

*/

package uva00732;

// Copy-paste from here...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00732 uva = new UVa00732();
        //uva.runTest();
        uva.run();
    }
}


class UVa00732 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00732_in.txt";

    String src;
    String dst;
    public void run() {
        //Scanner scan = readFile(fileName);
        Scanner scan =read();

        while (scan.hasNext()) {
            src = scan.nextLine();
            dst = scan.nextLine();

            System.out.printf("%c\n", '[');
            if ( src.length() == dst.length()) {
                dfs(src, "", "", "", 0);
            }
            System.out.printf("%c\n", ']');
        }
    }

    private void dfs(String a, String b, String stack, String path, int n) {
        if(n == src.length() * 2) {
            if(b.equals(dst)) {
                System.out.println(path);
            }
            return;
        }

        // push
        if(a.length() > 0) {
            dfs(a.substring(1), b, stack + a.charAt(0), path + (n == 0 ? "i" : " i"), n + 1);
        }
        // pop
        if(stack.length() > 0 && stack.charAt(stack.length()-1) == dst.charAt(b.length())) {
            dfs(a, b + stack.charAt(stack.length()-1), stack.substring(0, stack.length()-1), path + " o", n + 1);
        }
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
