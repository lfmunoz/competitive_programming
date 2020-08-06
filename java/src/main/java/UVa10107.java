/*

UVa10107 - What is the Median?

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1048
https://www.udebug.com/UVa/10107


https://stackoverflow.com/questions/7019872/whats-the-equivalent-nth-element-function-in-java
https://en.wikipedia.org/wiki/Selection_algorithm
https://stackoverflow.com/questions/251781/how-to-find-the-kth-largest-element-in-an-unsorted-array-of-length-n-in-on
http://cs.indstate.edu/~spitla/abstract2.pdf
*/

package uva10107;

// Copy-paste from here...
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10107 uva = new UVa10107();
        //uva.runTest();
        uva.run();
    }
}


class UVa10107 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10107_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();
        Boolean evenFlag = false;

        List<Integer> intArr = new ArrayList<Integer>();
        while (scan.hasNext()) {
            Integer num = scan.nextInt();
            intArr.add(num);
            Collections.sort(intArr);
            if (evenFlag) {
                int mediumIndex = (int) Math.floor(intArr.size() / 2);
                int medium = (int) Math.floor( (intArr.get(mediumIndex) + intArr.get(mediumIndex-1) ) / 2);
                System.out.println(Integer.toString(medium));

            } else {
                int mediumIndex = (int) Math.floor(intArr.size() / 2);
                System.out.println(Integer.toString(intArr.get(mediumIndex)));
            }
            evenFlag = !evenFlag;
            //compute(num);

        }
    }

    private void compute(int num)
    {
        System.out.println(num);
    }



    static public int selection(int[] X, int left, int right, int k) {
        System.out.println("right is " + Integer.toString(right));
        if (left == right) {
            return X[left];
        }
        int middle = partition(X, left, right);
        System.out.println("middle is " + Integer.toString(middle));
        System.out.println(Arrays.toString(X));
        if (middle - left + 1 >= k) {
            return selection(X, left, middle, k);
        } else {
            return selection(X, middle+1, right, k-(middle-left+1));
        }
    }

    static public int partition (int[] X, int left, int right) {
        int pivot = X[left]; // select first element as pivot
        int L = left;
        int R = right;
        while ( L < R ) {
            while ( X[L] <= pivot && L < right) {
                L = L + 1;
            }
            while ( X[R] > pivot && R >= left) {
                R = R - 1;
            }
            if (L < R) {
                swap(X, L, R);
            }

        }
        swap(X, left, R);
        return R;
    }



    static public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
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
