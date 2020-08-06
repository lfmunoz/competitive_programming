/*

UVa 10038 - Jolly Jumpers * (use 1D boolean flags to check [1..n − 1])

20073317

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=979
https://uva.onlinejudge.org/external/100/10038.pdf
https://gist.github.com/marvinnn/9d2ff5408d31106c1a2af5002581133d
https://www.udebug.com/UVa/10038

-------------------------
A sequence of n > 0 integers is called a jolly jumper if the absolute values of the difference between
successive elements take on all the values 1 through n − 1. For instance,

1 4 2 3

is a jolly jumper, because the absolutes differences are 3, 2, and 1 respectively. The definition implies
that any sequence of a single integer is a jolly jumper. You are to write a program to determine whether
or not each of a number of sequences is a jolly jumper.

Input

Each line of input contains an integer n ≤ 3000 followed by n integers representing the sequence.

Output

For each line of input, generate a line of output saying ‘Jolly’ or ‘Not jolly’.

Sample Input
4 1 4 2 3
5 1 4 2 -1 6

Sample Output
Jolly
Not jolly
-------------------------

 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws java.lang.Exception {

        // UVa10038: Jolly Jumpers
        UVa10038 uva = new UVa10038();
        //uva.runTest();
        uva.run();
    }
}


class UVa10038 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva10038_in.txt";

    public void run() {
        //List<String> readData = read();
        List<String> readData = readFile(fileName);

        for(int idx = 0; idx < readData.size(); idx++) {
            String line = readData.get(idx);
            List<Integer> intList = Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            System.out.println(compute(intList));
        }
    }

    private String compute(List<Integer> list) {
      list.remove(0);
      int n = list.size();
      List<Integer> difference = new ArrayList<>();
      for(int i = 0; i < n-1; i++) {
          difference.add(Math.abs(list.get(i+1)-list.get(i)));
      }
      //  System.out.println(difference);
      Collections.sort(difference);
        for(int i = 0; i < n-1; i++) {
            if(difference.get(i) != i+1) {
                return "Not jolly";
            }
        }
        return "Jolly";
    }

    public List<String> read() {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            lines.add(s);
        }
        return lines;
    }

    public static List<String> readFile(String fileName) {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                lines.add(s);
            }
            //scan.close();
            return lines;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
