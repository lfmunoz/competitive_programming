/*

UVa11034 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11034

Runtime 

*/

package uva11034;

// Copy-paste from here...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11034 uva = new UVa11034();
        //uva.runTest();
        uva.run();
    }
}


class UVa11034 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11034_in.txt";

    public void run() {
        Scanner scan =readFile(fileName);
        //Scanner scan = read();

        Integer set = Integer.parseInt(scan.nextLine());
        for (int problem = 0; problem < set; problem++) {
            String ntmInput = scan.nextLine();
            String[] values = ntmInput.split(" ");
            int l = 100 * Integer.parseInt(values[0]); // l - length of ferry in meters
            int m = Integer.parseInt(values[1]); // m - lines, giving length of car

            Queue<Integer> left = new LinkedList<>();
            Queue<Integer> right = new LinkedList<>();
            for (int car = 0; car < m; car++) {
                String carInput= scan.nextLine();
                String[] carValues = carInput.split(" ");
                if (carValues[1].equals("left")) {
                    left.add(Integer.parseInt(carValues[0]));
                } else {
                    right.add(Integer.parseInt(carValues[0]));
                }
            }

            compute(left, right, l, m);

        }
    }

    private void compute(Queue<Integer> left, Queue<Integer> right, int l, int m) {
        int completed = 0;
        int tripCount = 0;
        boolean leftBank = true;
        while(completed < m) {
            if(leftBank) {
                 completed += unload(left, l);
            }
            if(!leftBank) {
                completed += unload(right, l);
            }
            tripCount++;
            leftBank = !leftBank;

        }
        System.out.println(String.valueOf(tripCount));
    }

    public int unload(Queue<Integer> queue, int l) {
        int ferryLoad = 0;
        int carLoadCount = 0;
        while(!queue.isEmpty() && (queue.peek() + ferryLoad) <= l ) {
            ferryLoad += queue.poll();
            carLoadCount++;
        }
        return carLoadCount;
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
