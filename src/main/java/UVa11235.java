/*

UVa11235 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11235

range maximum query

*/

package uva11235;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11235 uva = new UVa11235();
        //uva.runTest();
        uva.run();
    }
}


class UVa11235 {
    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11235_in.txt";
    //////////////////////////////////////////////////////////////////////////
    // Inner class data structure
    //////////////////////////////////////////////////////////////////////////
    class Table {

        long[][] tbl;

        Table(List<Integer> in) {

            // initialize tbl
            int length = in.size();
            tbl = new long[length][length];
            for(int x = 0; x < length; x++) {
                for(int y = x; y < length; y++) {
                    long result =  mostCommonItem(in.subList(x, y+1));
                    tbl[x][y] = result;
                }
            }

        }

        long mostCommonItem(List<Integer> in) {
            Map<Integer, Long> x = in.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Optional<Map.Entry<Integer, Long>> result =  x.entrySet().stream().max( Comparator.comparingLong(Map.Entry::getValue));
            // 2147483647 max long
            return result.get().getValue();
        }

        long query(int i, int j) {
            return tbl[i-1][j-1];
        }
    }

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        while (true) {
            String testCase = scan.nextLine();
            if(testCase.equals("0")) break;
            int n = Integer.parseInt(testCase.split(" ")[0]);
            int q = Integer.parseInt(testCase.split(" ")[1]);

            List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Table tbl = new Table(numbers);

            for(int idx = 0; idx < q; idx++) {
                String[] rangeCase = scan.nextLine().split(" ");
                int start = Integer.parseInt(rangeCase[0]);
                int end = Integer.parseInt(rangeCase[1]);

                long result = tbl.query(start, end);
                System.out.println(result);
            }

            //System.out.println("done");
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
