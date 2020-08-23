/*

UVa10901 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10901

Runtime 

*/

package uva10901;

// Copy-paste from here...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10901 uva = new UVa10901();
        //uva.runTest();
        uva.run();
    }
}


class UVa10901 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10901_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan = read();

        Integer set = Integer.parseInt(scan.nextLine());
        for (int problem = 0; problem < set; problem++) {
            String ntmInput = scan.nextLine();
            String[] values = ntmInput.split(" ");
            int n = Integer.parseInt(values[0]); // cars that can fit on ferry
            int t = Integer.parseInt(values[1]); // time it takes to cross ferry
            int m = Integer.parseInt(values[2]); // m lines, giving arrival time and bank

            Queue<Map.Entry<Integer, Integer>> left = new LinkedList<>();
            Queue<Map.Entry<Integer, Integer>> right = new LinkedList<>();
            for (int car = 0; car < m; car++) {
                String carInput= scan.nextLine();
                String[] carValues = carInput.split(" ");
                if (carValues[1].equals("left")) {
                    left.add(new AbstractMap.SimpleEntry(car, Integer.parseInt(carValues[0])));
                } else {
                    right.add(new AbstractMap.SimpleEntry(car, Integer.parseInt(carValues[0])));
                }
            }

            compute(left, right, n, t, m);
            if(problem != set-1) System.out.println();

        }
    }

    private void compute(Queue<Map.Entry<Integer, Integer>> left, Queue<Map.Entry<Integer, Integer>> right, int n, int t, int m) {
        Integer[] result = new Integer[m];
        int time = 0;
        int completed = 0;
        boolean leftBank = true;
        while(completed < m) {
            Integer earliest_car  =  Integer.MAX_VALUE;
            if(!left.isEmpty()) {
                earliest_car = left.peek().getValue();
            }
            if(!right.isEmpty()) {
                earliest_car = Integer.min(earliest_car, right.peek().getValue());
            }

            time = Integer.max(time, earliest_car);

            if(leftBank) {
                completed += unload(left, n, t, time, result);
            } else {
                completed += unload(right, n, t, time, result);
            }
            time +=t;
            leftBank = !leftBank;
        }

        for(int i = 0; i < result.length; i++) {
            System.out.printf("%d\n", result[i]);
        }


    }

    public int unload(Queue<Map.Entry<Integer, Integer>> queue, int n, int t, int time, Integer[] result) {
        int cars = 0;
        int completed = 0;
        while(!queue.isEmpty() && queue.peek().getValue() <= time && cars < n) {
            cars++;
            Map.Entry<Integer, Integer> car = queue.poll();
            //System.out.printf("%d\n", time + t);
            result[car.getKey()] = time + t;
            completed++;
        }
        return completed;
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
