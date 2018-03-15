/*

UVa11926 - Multitasking
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=3077
https://www.udebug.com/UVa/11926


*/

package uva11926;

// Copy-paste from here...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.BitSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11926 uva = new UVa11926();
        //uva.runTest();
        uva.run();
    }
}


class UVa11926 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11926_in.txt";

    private final int MAX_BIT = 1000001;

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();


        while (true) {
            boolean doneFlag = false;
            String nmStr= scan.nextLine();
            String[] nmArr = nmStr.split(" ");
            int n = Integer.parseInt(nmArr[0]);
            int m = Integer.parseInt(nmArr[1]);
            if (n == 0 && m == 0) break;
            //System.out.printf("----------------------%n");

            BitSet calendar = new BitSet(MAX_BIT);
            for(int oneTime = 0; oneTime < n; oneTime++) {
                String taskStr = scan.nextLine();
                if (doneFlag == true) {
                    continue;
                }
                String[] taskArr = taskStr.split(" ");
                int start = Integer.parseInt(taskArr[0]);
                int end = Integer.parseInt(taskArr[1]);
                //System.out.printf("%d %d%n", start, end);
                if (check(calendar, start, end)) {
                    calendar.set(start, end);
                } else {
                    System.out.println("CONFLICT");
                    doneFlag = true;
                }
            }

            for(int repeatTask = 0; repeatTask < m; repeatTask++) {
                String taskStr = scan.nextLine();
                if (doneFlag == true) {
                    continue;
                }
                String[] taskArr = taskStr.split(" ");
                int start = Integer.parseInt(taskArr[0]);
                int end = Integer.parseInt(taskArr[1]);
                int interval = Integer.parseInt(taskArr[2]);
                //System.out.printf("%d %d %d%n", start, end, interval);
                for(int i = 0; i+start < (MAX_BIT); i += interval) {
                    //System.out.printf("%d < %d %n", i, MAX_BIT - start);
                    //System.out.printf("%d %d %n", start+i, end+i);
                    int cap = i + end;
                    if (cap > MAX_BIT) {
                        cap = MAX_BIT;
                    }
                    if (check(calendar, i+start, cap)) {
                        calendar.set(i+start, cap);
                    } else {
                        System.out.println("CONFLICT");
                        doneFlag = true;
                        break;
                    }
                }
            }
            if (!doneFlag) {
                System.out.println("NO CONFLICT");
            }

        }
    }

    private boolean check(BitSet calendar, int start, int end) {
        //System.out.printf("start %d to end %d %n", start, end);
        BitSet subset = calendar.get(start, end);
        if (0 == subset.cardinality() ){
        //if (0 == subset.cardinality() || "{0}".equals(subset.toString())) {
            return true;
        } else {
            return false;
        }
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
