/*

UVa00978 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00978

Runtime 

*/

package uva00978;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00978 uva = new UVa00978();
        //uva.runTest();
        uva.run();
    }
}


class UVa00978 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00978_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        int N = Integer.parseInt(scan.nextLine()); // N - number of test cases
        for(int idx = 0; idx < N; idx++) {
            String input = scan.nextLine();
            String[] values = input.split(" ");
            int B = Integer.parseInt(values[0]); // number of battle field
            int SG = Integer.parseInt(values[1]); // number of green
            int SB = Integer.parseInt(values[2]); // number of blue

            PriorityQueue<Integer> greenQ = new PriorityQueue(SG, Collections.reverseOrder());
            PriorityQueue<Integer> blueQ = new PriorityQueue(SB, Collections.reverseOrder());
            for(int green = 0; green < SG; green++) {
                int power = Integer.parseInt(scan.nextLine());
               // System.out.printf("%d %n", power);
                greenQ.add(power);
            }
            for(int blue = 0; blue < SB; blue++) {
                int power = Integer.parseInt(scan.nextLine());
                //System.out.printf("%d %n", power);
                blueQ.add(power);
            }
            compute(greenQ, blueQ, B);
            if(idx != N - 1) System.out.println();
        }
    }

    private void compute(PriorityQueue<Integer> greenQ, PriorityQueue<Integer> blueQ, int B) {
        // each have enough to send
        while(greenQ.size() >= B && blueQ.size() >= B) {
                for(int battle = 0; battle < B; battle++) {
                    int result = greenQ.poll() - blueQ.poll();
                    if(result > 0) {
                        greenQ.add(result);
                    } else if(result < 0) {
                        blueQ.add(Math.abs(result));
                    }
                }
        }
        // one doesn't have enough to send
        while(greenQ.size() != 0 ||  blueQ.size() != 0) {
            if(!greenQ.isEmpty() && !blueQ.isEmpty()) {
                int result = greenQ.poll() - blueQ.poll();
                if (result > 0) {
                    greenQ.add(result);
                } else if (result < 0) {
                    blueQ.add(Math.abs(result));
                }
            } else if(!greenQ.isEmpty()) {
                System.out.println("green wins");
                display(greenQ);
                return;
            } else if(!blueQ.isEmpty()) {
                System.out.println("blue wins");
                display(blueQ);
                return;
            } else {
                System.out.println("green and blue died");
                return;
            }
        }
        System.out.println("green and blue died");
    }

    public void display(PriorityQueue<Integer> winQ) {
        while(!winQ.isEmpty()) {

            System.out.println(winQ.poll());
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
