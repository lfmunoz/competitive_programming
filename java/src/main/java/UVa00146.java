/*

UVa00146 - ID Codes
https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=82
https://www.udebug.com/UVa/00146

https://leetcode.com/problems/next-permutation/description/

Runtime 

*/

package uva00146;

// Copy-paste from here
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00146 uva = new UVa00146();
        //uva.runTest();
        uva.run();
    }
}


class UVa00146 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00146_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();
        while (true) {
            String permutation = scan.nextLine();
            if(permutation.charAt(0) == '#') {
                System.exit(0);
            }
            String[] values = permutation.split("");
            compute(values);
        }
    }

    private void compute(String[] perm) {
        int i = perm.length - 2;
        while(i >= 0 && perm[i+1].compareTo(perm[i]) <= 0) {
            i--;
        }
        if( i >= 0) {
            int j = perm.length - 1;
            while(j >= 0 && perm[j].compareTo(perm[i]) <= 0) {
                j--;
            }
            swap(perm, i, j);
            reverse(perm, i+1);
            System.out.println(String.join("", perm));
        } else {
            System.out.println("No Successor");
        }

    }

    private void reverse(String[] arr, int start) {
        int i = start;
        int j = arr.length - 1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private void swap(String[] arr, int a, int b) {
        String tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
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
