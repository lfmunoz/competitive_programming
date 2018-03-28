/*

UVa11988 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11988

Runtime 

*/

package uva11988;

// Copy-paste from here...

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        UVa11988 uva = new UVa11988();
        //uva.runTest();
        uva.run();
    }
}


class UVa11988 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva11988_in.txt";

    public void run() {
        //Scanner scan = readFile(fileName);
        Scanner scan =read();



        LinkedList<Character> result = new LinkedList();
        ListIterator<Character> iter = result.listIterator(0);
       scan.useDelimiter("");
       while(scan.hasNext()) {
           Character c =  scan.next().charAt(0);
           if (c.equals('[')) {
               iter = result.listIterator(0);
               continue;
           } else if (c.equals(']')) {
               iter = result.listIterator(result.size());
               continue;
           }

           if(c.equals('\n')) {
               printList(result);
               result = new LinkedList();
               iter = result.listIterator(0);
               continue;
           }

           iter.add(c);
       }


       /*
        while (scan.hasNext()) {
            compute(scan.nextLine().toCharArray());
        }
        */

    }

    private void compute(char[] chars) {
        LinkedList<Character> result = new LinkedList();
        ListIterator<Character> iter = result.listIterator(0);
        for (Character regularChar : chars) {
            if (regularChar.equals('[')) {
                iter = result.listIterator(0);
                continue;
            } else if (regularChar.equals(']')) {
                iter = result.listIterator(result.size());
                continue;
            }
            iter.add(regularChar);
        }
        printList(result);
    }

    private void printList(LinkedList<Character> linkedList) {

        for (Character x : linkedList) {
            System.out.print(x);
        }
        System.out.println();
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
            return scan;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }



}
