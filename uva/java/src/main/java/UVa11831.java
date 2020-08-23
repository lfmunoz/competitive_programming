/*

UVa11831 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11831

Runtime 

*/

package uva11831;

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
        UVa11831 uva = new UVa11831();
        //uva.runTest();
        uva.run();
    }
}


class UVa11831 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11831_in.txt";

    int currentX;
    int currentY;
    String currentDir;
    String[][] arena;
    int stickers;

    int N;
    int M;
    int S;

    public void run() {
       // Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (true) {
            String[] testCase = scan.nextLine().split(" ");
            N = Integer.parseInt(testCase[0]); // 1<= N (rows)
            M = Integer.parseInt(testCase[1]); // M <= 100 (columns)
            S = Integer.parseInt(testCase[2]); // 1 <= S <= 50000 (instructions)
            if (N == 0) break;

            currentX = 0;
            currentY = 0;
            currentDir = null;
            arena = new String[N][M];
            stickers = 0;


            for(int x = 0; x < N; x++) {
                String[] row = scan.nextLine().split("");
                for(int y = 0; y < M; y++) {
                    arena[x][y] = row[y];
                    if(row[y].equals("N") || row[y].equals("S") ||
                            row[y].equals("L") || row[y].equals("O") ) {
                       currentX = x;
                       currentY = y;
                       currentDir  = row[y];
                        arena[x][y] = ".";
                    }
                    /*
                    if(x == 0 && y == 0) {
                        previous = new Node(row[y], null, null, null, null);
                    } else if(x == 0 && y == M-1) {
                        previous = new Node(row[y], null, null, null, previous);
                    } else if(x == N-1 && y == M-1) {
                        previous = new Node(row[y], previous.north.west, previous, null, previous);
                    } else if(x == N-1 && y == 0) {
                        // this would require a loop to go way back
                        // probably a bad idea.
                        // better to put them a table, and then simiply calculate moveD moveE moveF
                        //
                        previous = new Node(row[y], , previous, null, previous);
                    } else if(x == 0) {

                    } else if(y ==0) {

                    } else if(x == N-1) {

                    } else if(y == M-1) {

                    } else {

                    }

                     */
                }

            }

//System.out.println("--------------");
            String[] instructions = scan.nextLine().split("");
            for(int i = 0; i < instructions.length; i++) {
          //      System.out.printf("%s %s  %s %s %s %n", currentX, currentY, instructions[i], stickers, currentDir );
                if(instructions[i].equals("D")) {
                    moveD();
                } else if(instructions[i].equals("E")) {
                    moveE();
                } else {
                    moveF();
                }
            }
           System.out.println(stickers);
//return;
        }
    }

    // 90 to the right
    void moveD() {
        switch(currentDir) {
            case "N":
                currentDir = "L";
                break;
            case "S":
                currentDir = "O";
                break;
            case "L": // east
                currentDir = "S";
                break;
            case "O": // west
                currentDir = "N";
                break;
            default:
                //System.out.println("Invalid Direction");
        }
    }
    // 90 to the left
    void moveE() {
        switch(currentDir) {
            case "N":
                currentDir = "O";
                break;
            case "S":
                currentDir = "L";
                break;
            case "L": // east
                currentDir = "N";
                break;
            case "O": // west
                currentDir = "S";
                break;
            default:
              //  System.out.println("Invalid Direction");
        }
    }

    // forward
    void moveF() {
        switch(currentDir) {
            case "N":
                moveNorth();
                break;
            case "S":
                moveSouth();
                break;
            case "L":
                moveEast();
                break;
            case "O":
                moveWest();
                break;
            default:
            //    System.out.println("Invalid Direction");
        }
    }


    void moveNorth() {
        int tempX = currentX - 1;
        if(tempX < 0) return;
        if(arena[tempX][currentY].equals(".")) {
            currentX = tempX;
        } else if(arena[tempX][currentY].equals("*")) {
            currentX = tempX;
            stickers = stickers + 1;
            arena[tempX][currentY] = ".";
        } else {
            // pillar do nothing
        }
    }

    void moveSouth() {
        int tempX = currentX + 1;
        if(tempX >= N) return;
        if(arena[tempX][currentY].equals(".")) {
            currentX = tempX;
        } else if(arena[tempX][currentY].equals("*")) {
            currentX = tempX;
            stickers = stickers + 1;
            arena[tempX][currentY] = ".";
        } else {
            // pillar do nothing
        }
    }

    void moveEast() {
        int tempY = currentY + 1;
        if(tempY >= M) return;
        if(arena[currentX][tempY].equals(".")) {
            currentY = tempY;
        } else if(arena[currentX][tempY].equals("*")) {
            currentY = tempY;
            stickers = stickers + 1;
            arena[currentX][tempY] = ".";
        } else {
            // pillar do nothing
        }
    }

    void moveWest() {
        int tempY = currentY - 1;
        if(tempY < 0) return;
        if(arena[currentX][tempY].equals(".")) {
            currentY = tempY;
        } else if(arena[currentX][tempY].equals("*")) {
            currentY = tempY;
            stickers = stickers + 1;
            arena[currentX][tempY] = ".";
        } else {
            // pillar do nothing
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
