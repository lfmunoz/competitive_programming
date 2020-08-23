/*

UVa10306 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10306

Runtime 

*/

package uva10306;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10306 uva = new UVa10306();
        //uva.runTest();
        uva.run();
    }
}


class UVa10306 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10306_in.txt";

    //int[][] dp;
    int[][] coins;

    public int [][] dp;
    public boolean [][] flag;

    public void run() {
        Scanner scan =readFile(fileName);
        //BufferedReader scan =readwithBuffer(); // use readLine()
        //Scanner scan =read();

        int n = Integer.parseInt(scan.nextLine());
        for(int testCase= 0; testCase < n; testCase++) {
            scan.nextLine();
            String[] mS= scan.nextLine().split(" ");
            int m = Integer.parseInt(mS[0]); // 1 to 40, e-coin types
            int s = Integer.parseInt(mS[1]); // 1 to 300, value

            coins = new int[2][m];
            for(int y = 0; y < m; y++) {
                String[] conInfo= scan.nextLine().split(" ");
                coins[0][y] = Integer.parseInt(conInfo[0]); // conventional value
                coins[1][y] = Integer.parseInt(conInfo[1]); // InfoTech value
            }

            dp=new int [301][301];
            flag=new boolean [301][301];
            for (int[] dpS : dp) {
                Arrays.fill(dpS, 12345678);
            }

            int ans=Integer.MAX_VALUE;
            for (int i=0;i<=s;i++) {
                for (int i2=0;i2<=s;i2++) {
                    double sqrt=Math.sqrt(i*i+i2*i2);
                    if ((sqrt==(double)(int)sqrt && sqrt==s)) {
                        ans=Math.min(ans, query(coins,i,i2));
                    } else if (sqrt>s) {
                        break;
                    }
                }
            }
            if (ans==12345678) {
                System.out.println("not possible");
            } else {
                System.out.println(ans);
            }

            /*
            for(int cIdx = 1; cIdx < m+1; cIdx++) {
                for(int val = 0; val < s+1; val++) {

                }
            }

             */




         //   print2Dx(coins);
       //     System.out.println("");
     //       System.out.println("");
        }
    }


    void print2Dx(int[][] arr) {
        for(int x = 0; x < arr.length; x++) {
            for(int y = 0; y < arr[x].length; y++) {
                System.out.printf("%d %d = %d, ", x, y, arr[x][y]);
            }
            System.out.printf("%n");
        }
    }


    public int query (int [][] coin, int remA, int remB) {
        if (!flag[remA][remB]) {
            flag[remA][remB]=true;
            if (remA==0 && remB==0) {
                dp[remA][remB]=0;
            } else {
                for (int i=0;i<coin.length;i++) {
                    if (remA>=coin[i][0] && remB>=coin[i][1]) {
                        dp[remA][remB]=Math.min(dp[remA][remB],1+query(coin,remA-coin[i][0],remB-coin[i][1]));
                    }
                }
            }
        }
        return dp[remA][remB];
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
