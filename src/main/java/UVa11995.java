/*

UVa11995 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11995

stack, queue, and priority_queue

UVa 11995 - I Can Guess ... * (stack, queue, and priority queue)
Also see the usage of priority queue for topological sorts (see Section 4.2.1),
Kruskal’s 19 (see Section 4.3.2), Prim’s (see Section 4.3.3), Dijkstra’s (see
Section 4.4.3), and the A* Search algorithms (see Section 8.2.5)

*/

package uva11995;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11995 uva = new UVa11995();
        //uva.runTest();
        uva.run();
    }
}


class UVa11995 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11995_in.txt";

    public void run() throws Exception {
        //Scanner scan =readFile(fileName);
        //Scanner scan =read();
        BufferedReader scan = readwithBuffer();

        Deque<Integer> q;
        Deque<Integer> s;
        PriorityQueue<Integer> pQ;

        boolean queue;
        boolean stack;
        boolean priorityQueue;

        while (true) {
            String line =  scan.readLine();
            if (line == null) break;
            int cases =  Integer.parseInt(line);

            q = new ArrayDeque(cases);
            s = new ArrayDeque<>(cases);
            pQ = new PriorityQueue<>(cases, Collections.reverseOrder());

            queue = true;
            stack = true;
            priorityQueue = true;

            for(int idx = 0; idx < cases; idx++) {

                String inputLine = scan.readLine();
                String[] inputLineList = inputLine.split(" ");
                final int operation = Integer.parseInt(inputLineList[0]);
                final int value = Integer.parseInt(inputLineList[1]);
                //assume it is queue
                if (operation == 1) {
                    q.add(value);
                } else {
                    int i = q.remove();
                    if(i != value) {
                        queue = false;

                    }
                }

                //assume it is stack
                if (operation == 1) {
                    s.push(value);
                } else {
                   int stackValue = s.pop();
                   if ( stackValue != value) {
                       stack = false;
                   }
                }

                //assume it is a priority queue
                if (operation == 1) {
                    pQ.add(value);
                } else {
                    int pQValue = pQ.poll();
                    if ( pQValue != value) {
                        priorityQueue = false;
                    }
                }

            }
            printResult(queue, stack, priorityQueue);
        }
    }

    void printResult(boolean queue, boolean stack, boolean pQ) {
        int result = 0;
        if (queue) {
            result +=1;
        }
        if(stack) {
            result +=1;
        }
        if(pQ) {
            result += 1;
        }
        if(result == 1) {
            if (queue) System.out.println("queue");
            if (stack) System.out.println("stack");
            if (pQ) System.out.println("priority queue");
            return;
        }
        if(result == 0) {
            System.out.println("impossible");
            return;
        }
        System.out.println("not sure");
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
