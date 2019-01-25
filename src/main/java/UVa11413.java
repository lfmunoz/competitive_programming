/*

UVa11413 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11413

Runtime 

*/

package uva11413;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11413 uva = new UVa11413();
        //uva.runTest();
        uva.run();
    }
}


class UVa11413 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11413_in.txt";


    List<Integer> v;
    int n;
    int m;

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (scan.hasNextLine()) {
            int[] NM = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n =  NM[0];  // number of vessels 1 <= n <= 10000
            m =  NM[1]; // number of containers 1 <= m <= 1,000,000
            v = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());

            int hi = v.stream().mapToInt(i -> i.intValue()).sum() + 1;
            //int lo = Math.max(hi/ m, 1);
            int lo = v.stream().mapToInt(i -> i.intValue()).max().getAsInt();
            int mid = lo;
          //  System.out.printf("min = %d, max = %d %n", lo, hi);

            //for(int i = 0; i <50; i++) {
            //    mid = findMiddleIndex(lo, hi);
            //    if(isPossible(mid)) {
            //        = mid;

            //    }

           // }

            // Timelimit exceeded
             for(int i = 0; i < 50; i++) {

                 if(lo+1 == hi) {
                     if(isPossible(lo)) {
                         System.out.println(lo);
                     } else {
                         System.out.println(hi);
                     }
                     break;
                 }
                 if(lo == hi) {
                     System.out.println(lo);
                     break;
                 }

                 mid = findMiddleIndex(lo, hi);
                if(isPossible(mid)) {
                    hi = mid;
                } else {
                    lo = mid;
                }
             }

               // return;
            //System.out.printf("capacity = %d, result = %b %n", i, isPossible(i));

        }
    }

    public int findMiddleIndex(int startIdx, int endIdx) {
        int difference = (int) Math.floor( (endIdx - startIdx) / 2.0);
        return  difference + startIdx;
    }

    public boolean isPossible(int capacity) {
        //List<Integer> bucket = new ArrayList<>();
        Iterator<Integer> itr = v.iterator();
        int vCapacity = capacity;
        int rounds = m -1;
        while(itr.hasNext()) {
            int next = itr.next();
            if(vCapacity - next >= 0) {
                vCapacity -= next;
               // bucket.add(next);
            } else if(rounds > 0) {
               // System.out.println(bucket);
               // bucket = new ArrayList<>();
                rounds--;
                vCapacity = capacity - next;
               // bucket.add(next);
            } else {
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
