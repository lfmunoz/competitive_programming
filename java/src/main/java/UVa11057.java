/*

UVa11057 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11057


(sort, for price p[i], check if price (M - p[i]) exists with binary search)

*/

package uva11057;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11057 uva = new UVa11057();
        //uva.runTest();
        uva.run();
    }
}


class UVa11057 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11057_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();

        while (scan.hasNextLine()) {
            String N = scan.nextLine(); // number of available books
            int[] bookPrices = Arrays.stream(scan.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(bookPrices);
            int M = Integer.parseInt(scan.nextLine().trim()); // money peter has
            int[] prices = compute(bookPrices, M);



            System.out.printf("Peter should buy books whose prices are %d and %d.%n", prices[0], prices[1]);
         //   return;

            if(scan.hasNextLine()) {
                scan.nextLine();
                System.out.println();
            } else {
                break;
            }

        }
    }



    public int scanSortedArray(int[] arr, int start, int end, int value) {
        if(start > end) return -1;
        int middle = findMiddleIndex(start, end);
        int diff = Integer.compare(value, arr[middle]);
        if(diff == 0) {
            return middle;
        } else if (diff > 0) {
            return scanSortedArray(arr, middle+1, end, value);
        } else {
            return scanSortedArray(arr, start, middle-1, value);
        }
    }

    public int[] compute(int[] bookPrices, int money) {
        int[] result = new int[2];
        int ijDiff = Integer.MAX_VALUE;
        for(int i = 0; i < bookPrices.length - 1; i++) {
            int price = bookPrices[i];
            int value = money - price;
            int idx = scanSortedArray(bookPrices, i+1, bookPrices.length-1, value);

            if(idx != -1) {
                if(bookPrices[idx] - price < ijDiff) {
                    ijDiff = bookPrices[idx] - price;
                    result[0] = price;
                    result[1] = bookPrices[idx];
                }
            }
        }
        return result;
    }

    public int findMiddleIndex(int startIdx, int endIdx) {
        int difference = (int) Math.ceil( (endIdx - startIdx) / 2.0);
        return  difference + startIdx;
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
