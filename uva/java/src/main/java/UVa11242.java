/*

UVa11242 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11242

Runtime 

*/

package uva11242;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11242 uva = new UVa11242();
        //uva.runTest();
        uva.run();
    }
}


class UVa11242 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11242_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (true) {
            String rearFront = scan.nextLine().trim(); // read front
            if(rearFront.equals("0")) {
                break;
            }
            int[] front = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] rear = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Double> driveRatios = new ArrayList<>();
            for(int x = 0;  x < front.length; x++) {
                for(int y = 0; y < rear.length; y++) {
                    double ratio = (double) rear[y] / front[x];
                    driveRatios.add(ratio);
                }
            }

            Collections.sort(driveRatios);

            double spread = 0;
            for(int x = 0; x < driveRatios.size() - 1; x++) {
                double d1 = driveRatios.get(x);
                double d2 = driveRatios.get(x+1);
                double tmpSpread = d2 / d1;
                if(tmpSpread > spread) {
                    spread = tmpSpread;
                }
            }
            System.out.printf("%.2f%n", spread);
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
