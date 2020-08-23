/*

UVa11286 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11286

Runtime 

*/

package uva11286;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11286 uva = new UVa11286();
        //uva.runTest();
        uva.run();
    }
}


class UVa11286 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11286_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        while (true) {
            Integer frosh = Integer.parseInt(scan.nextLine());
            if(frosh == 0) {
                break;
            }
            Map<String, Integer> dataMap = new HashMap<>();
            for(int line = 0; line < frosh; line++) {
                String courses = scan.nextLine();
                //String[] coursesList =
                String id = Arrays.stream(courses.split(" ")).sorted().collect(Collectors.joining(" "));

                if(dataMap.containsKey(id)) {
                    dataMap.put(id, dataMap.get(id) + 1);
                } else {
                    dataMap.put(id, 1);
                }


            }
            compute(dataMap, frosh);

        }
    }

    private void compute(Map<String, Integer> dataMap, Integer frosh) {
        List<Integer> temp = dataMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        int max = Collections.max(dataMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
        int result = temp.stream().filter(x -> x == max).reduce(Integer::sum).get();
        System.out.printf("%d%n", result);
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
