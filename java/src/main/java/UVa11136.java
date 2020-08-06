/*

UVa11136 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11136

Runtime 
https://github.com/izharishaksa/UVa-Solution/blob/master/src/datastructures/builtin/Problem11136YES.java

https://github.com/PuzzlesLab/UVA/blob/master/King/11136%20Hoax%20or%20What.java
*/

package uva11136;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11136 uva = new UVa11136();
        //uva.runTest();
        uva.run();
    }
}


class UVa11136 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11136_in.txt";

    public void run() throws Exception {
        //Scanner scan =readFile(fileName);
        //Scanner scan =read();
        BufferedReader scan =readwithBuffer();

        while (true) {
            int days = Integer.parseInt(scan.readLine());
            if(days == 0) {
                break;
            }

            TreeMap<Integer, Integer> billSortedMap = new TreeMap<>();
            long payout = 0;
            int largest = 0;
            int smallest = 0;
            for(int day = 0; day < days; day++) {
                String bills = scan.readLine();
                String[] billsList = bills.split(" ");
                int total = Integer.parseInt(billsList[0]);
                for(int idx = 1; idx < total + 1; idx++) {
                    int bill = Integer.parseInt(billsList[idx]);
                    if(billSortedMap.containsKey(bill)) {
                        billSortedMap.put(bill, billSortedMap.get(bill) + 1);
                    } else {
                        billSortedMap.put(bill, 1);
                    }
                }
                largest = billSortedMap.lastKey();
                if(billSortedMap.get(largest) == 1) {
                    billSortedMap.remove(largest);
                } else {
                    billSortedMap.replace(largest, billSortedMap.get(largest) - 1);
                }
                smallest = billSortedMap.firstKey();
                if(billSortedMap.get(smallest) == 1) {
                    billSortedMap.remove(smallest);
                } else {
                    billSortedMap.replace(smallest, billSortedMap.get(smallest) - 1);
                }


                payout += largest - smallest;
            }

            System.out.printf("%d%n", payout);
            //compute(smallSquare, bigSquare);
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
