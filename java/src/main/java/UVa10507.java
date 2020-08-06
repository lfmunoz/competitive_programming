/*

UVa10507 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/10507

Runtime 

*/

package uva10507;

// Copy-paste from here...

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws Exception {
        UVa10507 uva = new UVa10507();
        //uva.runTest();
        uva.run();
    }
}


class UVa10507 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10507_in.txt";

    public void run() {
        //Scanner scan = readFile(fileName);
        Scanner scan =read();

        while (true) {
            Integer N = Integer.parseInt(scan.nextLine()); // number of slept areas
            Integer M = Integer.parseInt(scan.nextLine()); // connections

            String[] wakeUpAreas = scan.nextLine().split("");

            //Map<String, List<String>> awake = new HashMap<>();

            Set<String> awakeSet = new HashSet<>();

            Map<String, Set<String>> adjList = new HashMap<>();

            Arrays.stream(wakeUpAreas).forEach(strVal -> {
             //   Set<String> connected = new HashSet<>();
             //   adjList.put(strVal, connected);
                awakeSet.add(strVal);
                //System.out.println(strVal);
            });


            for (int i = 0; i < M; i++) {
                String[] connections = scan.nextLine().split("");

                if(!adjList.containsKey(connections[1]) && !awakeSet.contains(connections[1])) {
                    Set<String> connected = new HashSet<>();
                    adjList.put(connections[1], connected);
                }
                if(!adjList.containsKey(connections[0]) && !awakeSet.contains(connections[0])) {
                    Set<String> connected = new HashSet<>();
                    adjList.put(connections[0], connected);
                }

                if(!awakeSet.contains(connections[0])) {
                    adjList.get(connections[0]).add(connections[1]);
                }
                if(!awakeSet.contains(connections[1])) {
                    adjList.get(connections[1]).add(connections[0]);
                }

            }

            int years = 0;
            boolean goFlag = true;
            while(goFlag) {
                goFlag = false;

                Set<String> union = new HashSet<>();
                List<Map.Entry<String, Set<String>>> entryList = new ArrayList(adjList.entrySet());

                for (Map.Entry<String, Set<String>> entry : entryList) {
                    String node = entry.getKey();
                    Set<String> connArray = entry.getValue();

                    int count = 0;
                    for (String conn : connArray) {
                        if (awakeSet.contains(conn)) {
                            count++;
                        }
                    }

                    if (count > 2) {
                        //awakeSet.add(node);
                        adjList.remove(node);
                        goFlag = true;
                        union.add(node);
                    }

                }
                if(goFlag) {
                    years++;
                    awakeSet.addAll(union);
                }
            }



            if(N == awakeSet.size()) {
                System.out.println("WAKE UP IN, " + String.valueOf(years) + ", YEARS");
            } else {
                System.out.println("THIS BRAIN NEVER WAKES UP");
            }

            if(scan.hasNext()) {
                scan.nextLine();
            } else {
                break;
            }



        }

    }

    public int stringToInt(String c) {
        return Character.getNumericValue(c.charAt(0)) - 10;
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
            return scan;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
