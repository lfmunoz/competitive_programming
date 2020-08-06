/*

UVa10576 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10576

Runtime 

*/

package uva10576;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10576 uva = new UVa10576();
        //uva.runTest();
        uva.run();
    }
}


class UVa10576 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10576_in.txt";

    int s = 0;
    int d = 0;
    int solution = 0;

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();



        while (scan.hasNextLine()) {
            int[] input = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            s = input[0];
            d = input[1];
            solution = 0;

            List<Integer> current = new ArrayList<>();
            backtrack(0, 0,  current);
            if(solution == 0) {
                System.out.println("Deficit");
            } else {
           //     System.out.printf("wtf");
                System.out.printf("%d%n",solution);
            }
           // return;
        }
    }

    public void backtrack(int month, int currentSum, List<Integer> current) {
      // indent(month);
      //  System.out.printf("%d  %d  %s %d %n", month, currentSum, show(current), fiveSum(current));
        //if (solution != 0) return;

        if(fiveSum(current) >= 0) return;

        if(month == 12) {
            if(currentSum > 0 && currentSum > solution ) {
                solution = currentSum;
              //  System.out.printf("%d  %d  %s %n", month, currentSum, show(current));
            }
            return;
        }

      //  int possible = (12-month)*s+currentSum;

        backtrack(month + 1, currentSum + s, addS(current));
        backtrack(month + 1, currentSum - d, addD(current));



    }

    void indent(int n) {
        for(int i = 0; i < n; i++) {
            System.out.printf(" ");
        }
    }

    int fiveSum(List<Integer> arr) {
        if(arr.size() < 5) return -1;
        int fiveMonthSum = 0;
        for(int i = 0; i < 5; i++) {
            fiveMonthSum += arr.get(arr.size()-1 - i);
        }
        return fiveMonthSum;
    }


    String show(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
       for(Integer num: list) {
          sb.append(num +",");
       }
       sb.deleteCharAt(sb.length()-1);
        sb.append("]");
       return sb.toString();
    }

    List<Integer> addS(List<Integer> initial) {
        List<Integer> next = new ArrayList<>(initial);
        next.add(s);
        return next;
    }
    List<Integer> addD(List<Integer> initial) {
        List<Integer> next = new ArrayList<>(initial);
        next.add(-d);
        return next;
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
