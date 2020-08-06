/*

UVa10954 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10954

Runtime 

*/

package uva10954;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10954 uva = new UVa10954();
        //uva.runTest();
        uva.run();
    }
}


class UVa10954 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10954_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan = read();

        while (true) {
            int numCount = scan.nextInt();
            if (numCount == 0) {
                break;
            }
            PriorityQueue<Long> pq = new PriorityQueue<Long>();
            for(int i = 0; i < numCount; i++) {
                pq.offer(scan.nextLong());
            }
            // The magic is that the summation happens in a given order.
            // We always sum the least numbers first, which gives the least sum amount
            long cost = 0;
            while(!pq.isEmpty() && numCount > 1) {
                long sum = pq.poll() + pq.poll();
                cost += sum;
                pq.offer(sum);
                numCount--;
            }
            System.out.println(cost);
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
