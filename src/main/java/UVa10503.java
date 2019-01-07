/*

UVa10503 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10503

Runtime 

*/

package uva10503;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10503 uva = new UVa10503();
        //uva.runTest();
        uva.run();
    }
}


class UVa10503 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10503_in.txt";


    class Pair {
        int left;
        int right;
        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }


       // Pair flip() {
     //       return new Pair(right, left);
     //   }


        Pair flip() {
            int tmp = this.left;
            this.left = this.right;
            this.right = tmp;
            return this;
        }


        public String toString() {
           return "(" + left + "," + right + ")";
        }
    }

    int m;
    int n;
    Pair last = null;
   // List<Pair> pieces;
   Pair[] pieces;
    //int[] pieces;

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (scan.hasNextLine()) {
            n = Integer.parseInt(scan.nextLine()); // number of spaces
            if(n == 0) return;
            m = Integer.parseInt(scan.nextLine()); // number of pieces



            pieces = new Pair[m+2];
            //pieces = new int[m];


            for(int i = 0; i < m+2; i++) {

               String[] input = scan.nextLine().split(" ");
               Pair pair = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

               if( i == 1) {
                   last = pair;
               } else if(i == 0) {
                   pieces[0] = pair;
               } else {
                   pieces[i-1] = pair;
               }
            }
            pieces[m+1] = last;




            boolean answer0 = backtrack( pieces, 1); // 0
         //   boolean answer0 = false;
          //  pieces[0] = pieces[0].flip();
          //  boolean answer1 = backtrack(pieces, 1); // 10



        //     if(answer0 || answer1 ) {
            if(answer0 ) {
                System.out.println("YES");
            } else {
                System.out.println("NO");

            }



           // enumerate( pieces, 1);
          //  return;
        }
    }

    public void enumerate(Pair[] result, int left) {
       // indent(left);
     //   System.out.printf("left = %d, result ={ %s }%n", left, displayAll(result, n+1));
        if(left == n+1) {

            if(result[n].right == last.left || result[n].right == last.right) {
                System.out.println(displayAll(result, n + 1));
            }
            //    System.out.printf("left = %d, result ={ %s }%n", left, displayAll(result, n+1));
        }

        for(int i = left; i < m+1; i++) {
            swap(result, left, i);
            enumerate(result, left+1);
            swap(result, i, left);
        }


    }

    public boolean backtrack(Pair[] result, int left) {
     //   indent(left);
      //  System.out.printf("left = %d, result ={ %s }%n", left, displayAll(result, n+1));
        if(left == n+1) {
            if(result[n].right == last.left ) {
      //      if(result[n].right == last.left || result[n].right == last.right) {
             //   System.out.println(displayAll(result, n+1));
                return true;
            }
            return false;
        }


        for(int i = left; i < m+1; i++) {
            swap(result, left, i);
          //     System.out.println(displayAll(result, n+1));
            if(validate(result, left)) {
                if(backtrack(result, left+1)) {
                    return true;
                }
            }
            swap(result, i, left);


            flip(result, i);
            swap(result, left, i);

        //    System.out.println(displayAll(result, n+1));

            if(validate(result, left)) {
                if(backtrack(result, left+1)) {
                    return true;
                }
            }
            swap(result, i,left);
            flip(result, i);



        }

        return false;
    }


    /*

    public boolean backtrack(int tries, int fills, Pair[] result) {
        indent(tries);
        System.out.printf("tries = %d, result ={ %s }%n", tries, display(result));
        if(fills == n) { // all spaces have been filled
          //  System.out.println("result: " + display(result));
            return true;
        }
        if(tries == m) { // ran out of pieces to try
            return false;
        }

        if(backtrack(tries+1, fills, result)) {
            return true;
        }
        if(validate(result, pieces.get(tries), fills+1)) {
            result[fills+1] = pieces.get(tries);
            if(backtrack(tries + 1, fills+1, result)) {
                return true;
            }
            result[fills+1] = null;
        }

        if(validate(result, pieces.get(tries).flip(), fills+1)) {
            result[fills+1] = pieces.get(tries).flip();
            if(backtrack(tries + 1, fills+1, result)) {
                return true;
            }
            result[fills+1] = null;
        }


        return false;
    }
    */

    boolean validate(Pair[] result, int index) {
        if(result[index-1].right == result[index].left) {
           return true;
        }
        return false;
    }




    boolean validateAll(Pair[] result, int index) {
        for(int i = 0; i < index-1; i++) {
            if(result[i].right == result[i+1].left) {
                return false;
            }
        }
        return true;
    }


    // idx is how many
    String display(Pair[] result, int idx) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < idx; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }
        sb.append(result[idx]);
        return sb.toString();
    }

    String displayAll(Pair[] result, int idx) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }
       // sb.append(result[idx]);
        return sb.toString();
    }


    void swap(Pair[] result, int a, int b) {
        Pair tmp = result[a];
        result[a] = result[b];
        result[b] = tmp;
    }

    void flip(Pair[] result, int a) {
        result[a].flip();
    }

    void swapFlip(Pair[] result, int a, int b) {
        Pair tmp = result[a];
        result[a] = result[b].flip();
        result[b] = tmp;
    }


    void indent(int n) {
        for(int i =0; i < n; i++) {
            System.out.printf("   ");
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
