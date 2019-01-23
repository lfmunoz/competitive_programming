/*

UVa10341 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10341

Runtime 

*/

package uva10341;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10341 uva = new UVa10341();
        //uva.runTest();
        uva.run();
    }
}


class UVa10341 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10341_in.txt";
    int p = 0;
    int q = 0;
    int r = 0;
    int s = 0;
    int t = 0;
    int u = 0;




    public void run() throws Exception {
       // Scanner scan =readFile(fileName);
        BufferedReader scan =readwithBuffer(); // use readLine()
       // Scanner scan =read();

        String line = scan.readLine();
        while (null != line) {
           int[] in = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
           p = in[0];
           q = in[1];
           r = in[2];
           s = in[3];
           t = in[4];
           u = in[5];

           double a = 0;
           double b = 1;
           double c = 0;
           double fx = 0;

           double min = f(0);
           double max = f(1);

           if(min * max > 0) {
               System.out.printf("No solution%n");
               line = scan.readLine();
               continue;
           } else if(min == 0) {
               System.out.println("0.0000");
               line = scan.readLine();
               continue;
           } else if(max == 0) {
               System.out.println("1.0000");
               line = scan.readLine();
               continue;
           }


           for(int i = 0; i < 70; i++) {
               c = (a + b) / 2;
               fx = f(c);
          //     System.out.printf("    %.4f%n", c);
             //  if(Math.abs(fx) < .0001) {
             //      break;
             //  }

               if( f(a) * fx < 0) {
                   b = c;
               } else {
                   a = c;
               }
           }
            System.out.printf("%.4f%n", c);
            line = scan.readLine();

        }
    }



    public double f(double x) {
        return (p * Math.exp(-x)) + (q * Math.sin(x)) + (r * Math.cos(x))
                + (s * Math.tan(x)) + (t * x*x) + u;
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
