/*

UVa10172 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10172

Runtime 

*/

package uva10172;

// Copy-paste from here...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10172 uva = new UVa10172();
        //uva.runTest();
        uva.run();
    }
}

class UVa10172 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10172_in.txt";

    public void run() {
        Scanner scan = readFile(fileName);
        //Scanner scan = read();

        Integer set = Integer.parseInt(scan.nextLine());
        for (int problem = 0; problem< set; problem++) {
            String NSQinput = scan.nextLine();
            String[] values = NSQinput.split(" ");
            int N = Integer.parseInt(values[0]); // stations in the ring
            int S = Integer.parseInt(values[1]); // capacity of your cargo carrier
            int Q = Integer.parseInt(values[2]); // max number of cargoes the queue can accommodate

            List<Queue<Integer>> queueList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                Queue<Integer> queue = new LinkedList<>();
                String queueAtI = scan.nextLine(); //cargoes queued at station i
                String[] vals = queueAtI.split(" ");
                for(int v = 0; v < vals.length; v++) {
                    queue.add(Integer.parseInt(vals[v]));
                }
                queueList.add(queue);
            }
            compute(queueList, N, S, Q);
            System.out.println();
        }
    }

    private void compute(List<Queue<Integer>> queueList, int N, int S, int Q) {
        int station = 0;
        Queue<Integer> carrier = new LinkedList<>();
        while(true) {
            int currentStation = (station % N) + 1;
            if (!carrier.isEmpty() && station ==carrier.peek()) {

            }

            station++;
            if(station == 10 ) break;
        }

        //System.out.println(queueList);
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
