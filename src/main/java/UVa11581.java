/*

UVa11581 - Grid Successors
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=2628
https://www.udebug.com/UVa/11581


*/

package uva11581;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11581 uva = new UVa11581();
        //uva.runTest();
        uva.run();
    }
}


class UVa11581 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11581_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();
        Integer gCount = Integer.parseInt(scan.nextLine());

        for(int g = 0; g < gCount; g++) {
            Boolean[][] grid = new Boolean[3][3];
            scan.nextLine();
            for(int j = 0; j < 3; j++) {
                grid[j] = Arrays.stream(scan.nextLine().split("")).map( boolStr -> {
                    return (boolStr.equals("1"));
                }).toArray(Boolean[]::new);
            }
            System.out.println(compute(grid));
        }
    }

    private int compute(Boolean[][] grid) {

        Boolean runFlag= true;
        Boolean[][] h = grid;
        int count = 0;
        runFlag = check(h);

        //System.out.println("initial");
       // printGrid(grid);
       // System.out.println(Integer.toString(count));

        while(runFlag) {
            count += 1;
            h = f(h);
            runFlag = check(h);
            //printGrid(h);
            //System.out.println(Integer.toString(count));
            //System.out.println(Boolean.toString(runFlag));
        }
        /*
        System.out.println("1");
        printGrid(f(grid));
        System.out.println("2");
        printGrid(f(f(grid)));
        System.out.println("3");
        printGrid(f(f(f(grid))));
        System.out.println("4");
        printGrid(f(f(f(f(grid)))));
        */
        return count - 1;
    }

    private void printGrid(Boolean[][] grid) {
        System.out.println(Arrays.toString(grid[0]));
        System.out.println(Arrays.toString(grid[1]));
        System.out.println(Arrays.toString(grid[2]));
    }

    private Boolean check(Boolean[][] grid) {
       return (grid[0][0] | grid[0][1] | grid[0][2] |
              grid[1][0] | grid[1][1] | grid[1][2] |
              grid[2][0] | grid[2][1] | grid[2][2]);
    }

    private Boolean[][] f(Boolean[][] grid) {
        Boolean[][] fOfgrid = new Boolean[3][3];
        fOfgrid[0][0] = grid[0][1] ^ grid[1][0];
        fOfgrid[0][1] = grid[0][0] ^ grid[0][2] ^ grid[1][1];
        fOfgrid[0][2] = grid[0][1] ^ grid[1][2];

        fOfgrid[1][0] = grid[0][0] ^ grid[1][1] ^ grid[2][0];
        fOfgrid[1][1] = grid[1][0] ^ grid[1][2] ^ grid[0][1] ^ grid[2][1];
        fOfgrid[1][2] = grid[1][1] ^ grid[0][2] ^ grid[2][2];

        fOfgrid[2][0] = grid[2][1] ^ grid[1][0];
        fOfgrid[2][1] = grid[2][0] ^ grid[2][2] ^ grid[1][1];
        fOfgrid[2][2] = grid[1][2] ^ grid[2][1];
        return fOfgrid;

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
