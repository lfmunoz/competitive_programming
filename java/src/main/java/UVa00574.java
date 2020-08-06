/*

UVa00574 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00574

Runtime 

*/

package uva00574;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00574 uva = new UVa00574();
        //uva.runTest();
        uva.run();
    }
}


class UVa00574 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00574_in.txt";

    int total;

    Set<String> answer;

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();


        while (scan.hasNextLine()) {
            int[] input = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
           if(input[0] == 0) return;

            total = input[0];
            answer = new TreeSet<>( Collections.reverseOrder()  );

            int N = input[1];
            List<Integer> numbers = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                numbers.add(input[i+2]);
            }

            backtrack(numbers, 0, new ArrayList<>());

            System.out.printf("Sums of %d:%n", total);
            if(answer.size() == 0) {
                System.out.println("NONE");
            } else {
                for (String s : answer) {
                    System.out.println(s);
                }
            }

            //return;
        }
    }

    void backtrack(List<Integer> numbers, int idx, List<Integer> result) {
     //   indent(idx);
     //   System.out.printf("state: idx = %d, result  = %s %n", idx, display(result)) ;

        int sum = result.stream().mapToInt(Integer::intValue).sum();
        if(sum == total) {
            //System.out.println();
            answer.add(display(result));
        }
        if(sum > total) return;
        if(idx == numbers.size()) return;

        backtrack(numbers, idx+1, result);
        result.add(numbers.get(idx));
        backtrack(numbers, idx+1, result);
        result.remove(result.size()-1);

    }


    String display(List<Integer> result) {
        StringBuilder sb = new StringBuilder();

        if(result.size() == 1) {
            sb.append(result.get(0));
            return sb.toString();
        }

        for(int i = 0; i < result.size()-1; i++) {
            sb.append(result.get(i));
            sb.append("+");
        }
        sb.append(result.get(result.size()-1));
        return sb.toString();
    }

    void indent(int n) {
        for(int i =0; i < n; i++) {
            System.out.printf(" ");
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
