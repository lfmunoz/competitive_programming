/*

UVa00357 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00357

Runtime

notice the order of the for loops: each time a new coin is considered, all of the subsums are updated with the new possibilities opened by it

int changePossibilities(const int N, std::vector<int> coins) {
  vector<int> dp(N + 1, 0);
  dp[0] = 1; // Initialize - only one way to make 0 (with no coins)

  for (const auto c : coins) { // For each coin
    for (int i = c; i <= N; ++i) // For each subsum
      dp[i] += dp[i - c]; // Add new ways to make i
  }

  return dp[N];
}


*/

package uva00357;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00357 uva = new UVa00357();
        //uva.runTest();
        uva.run();
    }
}


class UVa00357 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00357_in.txt";


    int[] coins = new int[]{0, 1, 5, 10, 25, 50};
    long[][] dp = new long[6][30001];

    public void run() {
        //Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        Scanner scan =read();
        dp[0][0] = 1;

        while (scan.hasNext()) {
            int total = Integer.parseInt(scan.nextLine());
            long result = change(total);
            if(result == 1) {
                System.out.printf("There is only 1 way to produce %d cents change.%n", total);
            } else {
                System.out.printf("There are %d ways to produce %d cents change.%n", result, total);
            }
           // display();
          //  System.out.println();
        }
    }


    long change(int ask) {
        if(dp[dp.length-1][ask] != 0) return dp[dp.length-1][ask];
        // bottom-up
        for(int c = 1; c < dp.length; c++) {
            for(int value = 0; value < ask+1; value++) {
                if(value - coins[c] >= 0) {
                    dp[c][value] = dp[c-1][value] + dp[c][value-coins[c]];
                } else {
                    dp[c][value] = dp[c-1][value];
                }
            }
        }
        return dp[dp.length-1][ask];
    }

    void display() {
        System.out.printf("%d | ", coins[0]);
        for(int value = 0; value < dp[0].length; value++) {
            System.out.printf("%d ", dp[0][value]);
        }
        for(int c = 1; c < dp.length; c++) {
            System.out.printf("%d | ", coins[c]);
            for(int value = 0; value < dp[0].length; value++) {
                System.out.printf("%d ", dp[c][value]);
            }
            System.out.printf("%n");
        }
    }

    // top-down
    /*
    int change(int idx, int value) {
        if(value == 0) return 1; // one way, use nothing
        if(value < 0) return 0; // no way, we cannot reach negative value
        if(5 == idx) return 0; // no way, we have considered all coin types
        //if(dp[value] != 0) return dp[value];
        //if(type == values.length ) return 0; // we have considered all types


        return change(idx+1, value) + change(idx, value-values[idx]);

    }
*/

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
