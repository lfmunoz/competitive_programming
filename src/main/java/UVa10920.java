/*

UVa10920 - Spiral Trap

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1861
https://www.udebug.com/UVa/10920

Runtime 

Input:
  SZ - size of the border of grid (odd number less than 100,000)
  P - spiral position of a cell in this grid

*/

package uva10920;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10920 uva = new UVa10920();
        //uva.runTest();
        uva.run();
    }
}

class UVa10920 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10920_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan = read();

        while (true) {
            String line = scan.nextLine();
            String[] lineArr = line.split(" ");
            Long SZ = Long.parseLong(lineArr[0]);
            Long P = Long.parseLong(lineArr[1]);
            if (SZ == 0 && P == 0) break;
            compute(SZ, P);
        }
    }

    private void compute(Long SZ, Long P) {
        final int LEFT = 0;
        final int RIGHT = 1;
        final int UP = 2;
        final int DOWN = 3;

        int state = UP;
        Long n = 1L;
        int X = (int) ( Math.ceil((double)SZ /2));
        int Y =  (int) (Math.ceil((double)SZ /2));

        int x = jumpSpiral(P);
        n = (long)4*x*x - 5 *x +2;
        Y += (x-1);


        int up = 1 + ((x-1)*2);
        int left =1 + ((x-1)*2);
        int right =2 + ((x-1)*2);
        int down = 2  + ((x-1)*2);

        int movement = up/2;
        while( !n.equals(P)){
            movement++;
            if (state == UP) {
                X += 1;
                if (movement == up) {
                    up += 2;
                    state = LEFT;
                    movement = 0;
                }
            } else if (state == DOWN) {
                X -= 1;
                if (movement == down ) {
                    state = RIGHT;
                    down += 2;
                    movement = 0;
                }
            } else if (state == LEFT) {
                Y -= 1;
                if (movement == left ) {
                    state = DOWN;
                    left += 2;
                    movement = 0;
                }
            } else if (state == RIGHT) {
                Y += 1;
                if (movement == right ) {
                    state = UP;
                    right += 2;
                    movement = 0;
                }
            }
            n++;
        }
        System.out.println("Line = " + X + ", column = " + Y + ".");
    }

    private int jumpSpiral(Long P) {
        int i = 1;
        Long n = 1L;

        while( n <= P ) {
            i++;
            n = (long) 4 * i * i - 5 * i + 2;
        }
        return i-1;
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
