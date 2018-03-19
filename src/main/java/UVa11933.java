/*

UVa11933 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11933

Runtime 

*/

package uva11933;

// Copy-paste from here...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11933 uva = new UVa11933();
        //uva.runTest();
        uva.run();
    }
}


class UVa11933 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11933_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        while (true) {
            String input = scan.nextLine();
            int number = Integer.parseUnsignedInt(input);
            if (number == 0) break;
            boolean[] bitArr = to_binary(number);
            compute(bitArr);
        }
    }

    private void compute(boolean[] arr) {
       int aNum = 0;
       int bNum = 0;
       boolean flag = true;
       for(int i = 0; i < 32; i+=1) {
           if(arr[i]) {
               if (flag) {
                   aNum = (1 << i) + aNum;
               } else {
                   bNum = (1 << i) + bNum;
               }
               flag = !flag;
           }
       }
       System.out.printf("%d %d%n", aNum, bNum);
    }

    public boolean[] to_binary(int num) {
        boolean[] bitArr = new boolean[32];
        for(int i = 0; i < 32; i++) {
            bitArr[i] =  (num & (1 << i)) != 0;
        }
        return bitArr;
    }

    public int to_integer(List<Boolean> arr) {
        int n = 0;
        if (arr.get(0)) {
            n = 1;
        }
        for (int i = 1; i < 32; i++) {
            if (arr.get(i)) {

                n = (1 << i) + n;
            }
        }
        return n;
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
