/*

UVa00514 - Rails

https://www.udebug.com/UVa/514


*/

package uva00514;

// Copy-paste from here...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00514 uva = new UVa00514();
        //uva.runTest();
        uva.run();
    }
}


class UVa00514 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00514_in.txt";

    public void run() {
        //Scanner scan = readFile(fileName);
        Scanner scan =read();

        while (true) {
            int number = Integer.parseInt(scan.nextLine());
            if (0 == number) {
                break;
            }
            //List<Integer> range = IntStream.rangeClosed(1, number)
                   // .boxed().collect(Collectors.toList());

            while(true) { // loop through test cases
                String input = scan.nextLine();
                int[] intArray = Arrays.stream(input.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if(0 == intArray[0]) {
                    System.out.println();
                    break;
                } else {
                   compute(intArray, number);
                }
            }

        }
        //compute(intArray);
    }

    private void compute(int[] intArray, int seq){
        Stack<Integer> q = new Stack();

        int idx = 0;
        for(int x = 1; x <= seq; x++) {
            if (intArray[idx] == x) {
                idx++;
                continue;
            }
            if (!q.empty() && q.peek() == intArray[idx] ) {
                idx++;
                q.pop();
                x--;
                continue;
            }
            q.push(x);

        }

        for(; idx < seq; idx++) {
            if (!q.empty() && q.pop() == intArray[idx] ) {
                continue;
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
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
