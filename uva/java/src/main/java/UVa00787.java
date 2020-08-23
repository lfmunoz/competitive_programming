/*

UVa00787 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00787

Runtime 

*/

package uva00787;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00787 uva = new UVa00787();
        //uva.runTest();
        uva.run();
    }
}


class UVa00787 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00787_in.txt";
    List<Integer> seq;
    BigInteger max;

    public void run() {
       // Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (scan.hasNextLine()) {
            seq = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
            seq.remove(seq.size() -1);
           // seqSize = seq.size();
            max = new BigInteger("-100000000");

            //Map<String, Integer> mem = new HashMap<>();
            List<BigInteger> mem = new ArrayList<>();
            int idx = -1;

            for(int length = 1; length <= seq.size() ; length++) {
                for(int start = 0; start+length < seq.size() + 1; start++) {
                    if(length == 1) {
                        BigInteger a  = BigInteger.valueOf(seq.get(start));
                        mem.add(a);
                        if (max.compareTo(a) < 0) {
                           max = a;
                        }

                    } else {
                        int t = length + idx;
                        BigInteger a  = mem.get(t);
                        BigInteger b  = mem.get(start);
                        BigInteger result = a.multiply(b);
                        mem.add(result);
                        if (max.compareTo(result) < 0) {
                            max = result;
                        }
                        idx++;
                    }

                    //System.out.printf("length = %d, start =%d %n", length, start);
                }
            }

           // for(int length = 1; length <= seqSize; length++) {
            //    int productIdx =   length- 1;
            //    backTrack("0", 0, length, productIdx);
           // }
           // return;
            System.out.println(max);
            //System.out.println(solutions);
        }
    }

/*
    void backTrack(String key, int start, int length, int productIdx) {
        if(start == seqSize + 1 - length ) {
          //  System.out.println("solution = " + key);
            System.out.println("done");
            return;
        }

        String nextKey = String.valueOf(start);
        //int product = seq[start];
        for(int i = 0; i < length - 1; i++) {
            nextKey += String.valueOf(start+i+1);
//            product *= seq[start+i+1];

        }

        int product = (productIdx-1)*(seqSize-length+1) + start;

        String a = nextKey.substring(0,nextKey.length() - 1);
        String b = nextKey.substring(nextKey.length() - 1);
        if(a.isEmpty()) {
            System.out.print("**");
            //seq.add()
            System.out.printf("idx %d ", start);
            System.out.printf("value is = %d ", seq.get(start));
        } else {
            int x = seq.get(product+1);
            int y = seq.get(product);
            System.out.printf("idx %d %d ", product, productIdx+length);
            System.out.printf("value is = %d ", x*y);
            seq.add(x*y);
        }

       // int product = seq.get(start + productIdx);


      //  solutions.put(nextKey, product);
        System.out.println("key = " + nextKey + " start = " + String.valueOf(start) + " length " + String.valueOf(length)
        + "   "  + " productIdx is " + String.valueOf(productIdx) + " product is " + String.valueOf(product));

      //   for(int x = length; x < seq.length-1; x++) {
             backTrack(nextKey, start+1, length, productIdx);
           //  start = -1;
       //  }


    }
*/
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
