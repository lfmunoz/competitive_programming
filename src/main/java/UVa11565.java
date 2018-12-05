/*

UVa11565 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11565

Runtime 

*/

package uva11565;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11565 uva = new UVa11565();
        //uva.runTest();
        uva.run();
    }
}


class UVa11565 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11565_in.txt";

    int MAX = 1000;

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        int testCases = Integer.parseInt(scan.nextLine());
        for(int t = 0; t < testCases; t++) {
            String[] abc = scan.nextLine().split(" ");
            int A  = Integer.parseInt(abc[0]);
            int B  = Integer.parseInt(abc[1]);
            int C  = Integer.parseInt(abc[2]);
            calculate(A, B, C);
        }
    }

    public void calculate2(final int A, final int B, final int C) {
        boolean found=false;
        for (int x=-22;x<=22 && !found;x++) {
            for (int y=-100;y<=100 && !found;y++) {
                if (x!=y && x*x+y*y<=C) {
                    int z=A-x-y;
                    if (x!=z && y!=z && x*y*z==B && x*x+y*y+z*z==C) {
                        System.out.println(x+" "+y+" "+z);
                        found=true;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("No solution.");
        }
    }

    public void calculate(final int A, final int B, final int C) {
        boolean xIsPos = false;
        boolean yIsPos = false;

        // +++ case
        for(int x = 0; x < MAX; x++) {
            if(x > A) break;
            if(x*x > C) break;
            for (int y = 0; y < MAX; y++) {
                if(x + y > A) break;
                if(x * y > B) break;
                if(x*x + y*y > C) break;
                for (int z = 0; z < MAX; z++) {
                    if(x + y + z > A) break;
                    if(z*z + x*x + y*y > C) break;
                    if(x * y * z > B) break;
                    if( x == y) continue;
                    if( x == z) continue;
                    if( z == y) continue;
                    if( x + y + z == A) {
                        if( x * y * z == B) {
                            if( x*x + y*y + z*z == C) {
                                System.out.printf("%d %d %d%n", x, y, z);
                                return;
                            }
                        }
                    }

                }
            }
        }

        // + - - case
        for(int x = 0; x < MAX; x++){
            if(x*x > C) break;
            for(int y = -1; y > -MAX; y--) {
                if(x*x + y*y > C) break;
                for(int z = -1; z > -MAX; z--){
                    if(z*z + x*x + y*y > C) break;
                    if( x == y) continue;
                    if( x == z) continue;
                    if( z == y) continue;
                    if( x + y + z == A) {
                        if( x * y * z == B) {
                            if( x*x + y*y + z*z == C) {
                                System.out.printf("%d %d %d%n", Math.min(z,y), Math.max(z,y), x);
                                return;
                            }
                        }
                    }
                }
            }
        }



        System.out.println("No solution.");
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
