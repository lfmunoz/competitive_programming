/*


https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=2315
https://www.udebug.com/UVa/11340

0 < N <= 5  : N = Number of tests
O < K <= 100 : K = Number of paid characters

 */

package uva11340;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11340 uva = new UVa11340();
        //uva.runTest();
        uva.run();
    }
}


class UVa11340 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11340_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        int N = Integer.parseInt(scan.nextLine());

        for(int x = 0; x < N; x++) {
            int M = Integer.parseInt(scan.nextLine());
            Map<Character, Integer> valueMap = new HashMap<>();
            for(int y = 0; y < M; y++) {
                String line = scan.nextLine();
                String[] values = line.split(" ");
                valueMap.put(values[0].charAt(0), Integer.parseInt(values[1]));
            }
            int L = Integer.parseInt(scan.nextLine());
            List<String> newsList = new ArrayList<>();
            for(int z = 0; z < L; z++) {
                newsList.add(scan.nextLine());
            }
            String result = compute(String.join("", newsList), valueMap);
            System.out.println(result);
        }
    }

    private String compute(String article, Map<Character, Integer> valueMap) {
        Double sum = 0.0;
        for (int i = 0; i < article.length(); i++){
            char c = article.charAt(i);
            if (valueMap.containsKey(c)) {
                sum += valueMap.get(c);
            }
        }

        DecimalFormat myFormatter = new DecimalFormat("###0.00$");
        return myFormatter.format(sum/100);
    }

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
