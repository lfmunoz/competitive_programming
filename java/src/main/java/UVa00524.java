/*

UVa00524 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00524

Runtime 

*/

package uva00524;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00524 uva = new UVa00524();
        //uva.runTest();
        uva.run();
    }
}


class UVa00524 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00524_in.txt";
    int N;

    Set<Integer> primes = Stream.of(3,5,7,11,13,17,19,23,29,31,37).collect(Collectors.toSet());

    public void run() {
        Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        //Scanner scan =read();

        int caseCount = 1;
        while (scan.hasNextLine()) {
           N = Integer.parseInt(scan.nextLine());
           System.out.printf("Case %d:%n", caseCount);
           int[] result = new int[N];
           for(int i = 0; i < N; i++) {
               result[i] = i+1;
           }
           backtrack(result, 1);

           caseCount++;
           // return;

            if(scan.hasNextLine()) System.out.println();


            //return;
        }
    }

    void backtrack(int[] result, int index) {


      //  System.out.printf("index = %d result =%s %n", index, display(result));
        if(index == result.length-1) {
         //   if(primes.contains(result[0]+result[result.length-1]) &&
           //         primes.contains(result[result.length-2]+result[result.length-1]) )  {
           //     System.out.println(display(result));
         //   }

            if(isValid(result)) {
                System.out.println(display(result));
            }

            return;
        }

       for(int i = index; i < result.length; i++) {
           swap(result, i,index);
       //    if(primes.contains(result[index]+result[index-1])) {
               backtrack(result, index+1);
      //     }
           swap(result, i, index);
       }


    }

    String display(int[] result) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length-1; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }
        sb.append(result[result.length-1]);
        return sb.toString();
    }

    void swap(int[] result, int a, int b) {
        int tmp = result[a];
        result[a] = result[b];
        result[b] = tmp;
    }


    boolean isValid(int[] result) {
       // 1 2 3 10 7 4 9 8 5 6


        if(!primes.contains(result[0]+result[result.length-1])) {
            return false;
        }

        for(int i = 0; i < result.length-1; i++) {
            int a = result[i];
            int b = result[i+1];
            if(!primes.contains(a+b)) {
                return false;
            }
        }

        return true;
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
