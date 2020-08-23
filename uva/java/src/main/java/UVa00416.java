/*

UVa00416 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00416

Runtime 

*/

package uva00416;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00416 uva = new UVa00416(); //uva.runTest();
        uva.run();
    }
}


class UVa00416 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00416_in.txt";

    public Map<Integer, String> led;
    public List<String> set;

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()

        Scanner scan =read();
        led = new HashMap<>();
        led.put(9, "YYYYNYY");
        led.put(8, "YYYYYYY");
        led.put(7, "YYYNNNN");
        led.put(6, "YNYYYYY");
        led.put(5, "YNYYNYY");
        led.put(4, "NYYNNYY");
        led.put(3, "YYYYNNY");
        led.put(2, "YYNYYNY");
        led.put(1, "NYYNNNN");
        led.put(0, "YYYYYYN");


        /*
        while (scan.hasNextLine()) {
            String lines = scan.nextLine().trim();
            if(lines.equals("0")) break;

            set = new ArrayList<>(Integer.parseInt(lines));
            for(int i = 0; i < Integer.parseInt(lines); i++) {
                String value = scan.nextLine();
               // set.add(value);
            }

            System.out.println("MATCH");
        }
        */

        while (scan.hasNextLine()) {
            int lines = Integer.parseInt(scan.nextLine().trim());
            if(lines == 0) break;

            set = new ArrayList<>(lines);
            for(int i = 0; i < lines; i++) {
                String value = scan.nextLine();
                set.add(value);
            }
            if(findFirst()) {
                System.out.println("MATCH");
            } else {
                System.out.println("MISMATCH");
            }
           // return;
        }


    }


    public boolean findFirst() {
        int size = set.size();
        boolean result = false;
        for(int i = 9; i >= size-1; i--) {
            boolean[] burnout = new boolean[7];
            if(isPossible(set.get(0), led.get(i), burnout)) {
                result |= backtrack(i-1, 1, burnout);
            }
           if(result) return true;
        }
        return result;
    }

    public boolean backtrack(int ledIdx, int setIdx, boolean[] burnout) {
        if(setIdx == set.size()) {
            return true;
        }

        if(isPossible(set.get(setIdx), led.get(ledIdx), burnout)) {
            return backtrack( ledIdx-1, setIdx+1, burnout );
        }

        return false;
    }

    public boolean isPossible(String actual, String check, boolean[] burnout) {


            for (int i = 0; i < actual.length(); i++) {
                char a = actual.charAt(i);
                char c = check.charAt(i);

                // if that is a burned out LED we continue
                if (burnout[i]) {
                    if(a == 'Y') return false;
                    continue;
                }
                // if actual is N, but the check is Y, we might have a burnout
                if (a == 'N' && c == 'Y') {
                    burnout[i] = true;
                    continue;
                }

                // if actual is Y but check is No, then this can't be the value
                if (a == 'Y' && c == 'N') {
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
