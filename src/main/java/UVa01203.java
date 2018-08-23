/*

UVa01203 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/01203

Runtime 

*/

package uva01203;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa01203 uva = new UVa01203();
        //uva.runTest();
        uva.run();
    }
}


class UVa01203 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva01203_in.txt";

    public static Comparator<Map.Entry<Integer, Integer>> qComparator = (o1, o2) -> {
        if(o1.getKey().equals(o2.getKey())) {
            return (int) o1.getValue() - o2.getValue();
        }
        return (int) (o1.getKey() - o2.getKey());
    };
    public static Comparator<Map.Entry<Integer, Integer>> qComparator2 =
            Comparator.<Map.Entry<Integer, Integer>>comparingInt(entry -> entry.getKey());

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        int k = 0;

        Map<Integer, Integer> lookupTable = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> pQ = new PriorityQueue<>(qComparator);

        while (true) {
            String stdin = scan.nextLine();
            if (stdin.equals("#")) {
                stdin = scan.nextLine();
                k = Integer.parseInt(stdin);
                break;
            }
            String[] values = stdin.split("\\s+");
            int qNum = Integer.parseInt(values[1]);
            int interval = Integer.parseInt(values[2]);
            lookupTable.put(qNum, interval);
            pQ.add(new AbstractMap.SimpleEntry<Integer, Integer>(interval, qNum));
        }

        Map.Entry<Integer, Integer> entry = pQ.poll();
        System.out.println(entry.getValue());
        int interval = lookupTable.get(entry.getValue());
        pQ.add(new AbstractMap.SimpleEntry<Integer, Integer>(entry.getKey()+interval, entry.getValue()));

        for(int i = 1; i < k; i++) {
            entry = pQ.poll();
            System.out.println(entry.getValue());

            interval = lookupTable.get(entry.getValue());
            pQ.add(new AbstractMap.SimpleEntry<Integer, Integer>(entry.getKey()+interval, entry.getValue()));

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
