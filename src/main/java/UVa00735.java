/*

UVa00735 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00735

Runtime 

*/

package uva00735;

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
        UVa00735 uva = new UVa00735();
        //uva.runTest();
        uva.run();
    }
}


class UVa00735 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00735_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        List<Integer> possibleScores = new ArrayList<>();
        possibleScores.add(0);
        possibleScores.add(50);
        for(int x = 1; x <= 20; x++) {
            for(int y = 1; y <= 3; y++) {
                if(!possibleScores.contains(x*y)) {
                    possibleScores.add(x*y);
                }
            }
        }

        while (true) {
            int score = Integer.parseInt(scan.nextLine());
            if(score <= 0) break;

            int permutations = 0, combinations = 0;
            for(int d1 = 0; d1 < possibleScores.size(); d1++) {
                for(int d2 = 0; d2 < possibleScores.size(); d2++) {
                    for(int d3 = 0; d3 < possibleScores.size(); d3++) {
                        int subtract = possibleScores.get(d1) + possibleScores.get(d2) + possibleScores.get(d3);
                        int result = score - subtract;
                        if(result == 0) {
                            permutations += 1;
                            if(possibleScores.get(d1) <= possibleScores.get(d2) && possibleScores.get(d2) <= possibleScores.get(d3)) {
                                combinations +=1;
                            }
                            //System.out.printf("%d %d %d%n", d1, d2, d3);
                        }

                    }
                }
            }

            if(permutations == 0) {
                System.out.printf("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.%n", score);
                System.out.printf("**********************************************************************%n");
            } else {
                System.out.printf("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.%n", score, combinations);
                System.out.printf("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.%n", score, permutations);
                System.out.printf("**********************************************************************%n");
            }
        }
        System.out.println("END OF OUTPUT");
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
