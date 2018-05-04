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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00732 uva = new UVa00732();
        //uva.runTest();
        uva.run();
    }
}


class UVa00732 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00732_in.txt";


    class Tuple {
        public Stack<Character> stack = new Stack<Character>();
        public List<Character> result = new ArrayList<Character>();
        public String destination;
        public String source;

        Tuple(String src, String dst) {
            this.destination = dst;
            this.source = src ;
        }
    }

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        while (scan.hasNext()) {
            String src = scan.nextLine();
            String dst = scan.nextLine();

            System.out.printf("%c\n", '[');
            compute(src.toCharArray(), dst.toCharArray());
            System.out.printf("%c\n", ']');

            //System.out.printf("%s \n %s \n", src, dst);
        }
    }

    private void compute(char[] src, char[] dst) {
        Stack<Character> stack = new Stack<Character>();
        stack.push(src[0]);
        List<Character> result = new ArrayList<Character>();
        result.add('i');
        permutations(stack, result, Arrays.copyOfRange(src, 1, src.length), dst);
    }

    ////////////////////////////////////////////////////////////////////
    // Helper Functions
    ////////////////////////////////////////////////////////////////////
    public static void permutations(Stack<Character> stack , List<Character> result, char[] src, char[] dst) {
        // we've match all characters, so print solution
        if (dst.length == 0) {
            printArray(result);
            return;
        }
        // check if we can simply push the next value (greedy push)
        if (src.length != 0) {
            Stack<Character> stackCopy = (Stack<Character>)stack.clone();
            stackCopy.push(src[0]);
            List<Character> resultCopy = new ArrayList<Character>(result);
            resultCopy.add('i');
            permutations(stackCopy, resultCopy, Arrays.copyOfRange(src, 1, src.length), dst);
        }

        // check if the top stack value matches
        if (!stack.isEmpty() && stack.peek().equals(dst[0])) {
            Stack<Character> stackCopy = (Stack<Character>)stack.clone();
            stackCopy.pop();
            List<Character> resultCopy = new ArrayList<Character>(result);
            resultCopy.add('o');
            permutations(stackCopy, resultCopy, src, Arrays.copyOfRange(dst, 1, dst.length));
        }


    }

    public static void printArray(List<Character> arr) {
        for(int x = 0; x < arr.size(); x++) {
            if(x == arr.size() -1) {
                System.out.printf("%c\n", arr.get(x));
            } else {
                System.out.printf("%c ", arr.get(x));
            }
        }
        //System.out.printf("\n");
    }

    public static String swap(String str, int x, int  y) {
        char[] c = str.toCharArray();
        char tmp = c[x];
        c[x] = c[y];
        c[y] = tmp;
        return new String(c);
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
