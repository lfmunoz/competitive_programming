/*

UVa11988 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/11988

Runtime 

*/

package uva11988;

// Copy-paste from here...

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


        while (scan.hasNext()) {
            String text = scan.nextLine();
            LinkedList charList = text.chars().mapToObj(c -> (char) c)
                    .collect(Collectors.toCollection(LinkedList::new));

            //String output = Stream.of(charList).map(e -> e.toString()).collect(Collectors.joining("x "));

            //System.out.printf("%s%n", charList.toString());
            //System.out.printf("%s%n", output);
            //System.out.println(output);
            printList(compute(charList));

        }
    }

    private LinkedList<Character> compute(LinkedList<Character> linkedList) {
        // add(E e) - Appends the specified element to the end of this list.
        // addFirst(E e) - Inserts the specified element at the beginning of this list.
        // addLast(E e) - Appends the specified element to the end of this list.
        LinkedList<Character> result = new LinkedList();
        ListIterator<Character> iter = linkedList.listIterator();
        while (iter.hasNext()) {
            Character regularChar = iter.next();
            if (regularChar.equals('[')) {
                append_beiju(linkedList, result, iter);
            } else {
                result.add(regularChar);
            }
        }
        return result;
    }

    private void append_beiju(LinkedList<Character> linkedList,
                              LinkedList<Character> result, ListIterator<Character> iter) {

        //List<Character> arr = new ArrayList();
        Stack<Character> stack = new Stack();
        Character regularChar = iter.next();
        while (regularChar != ']') {
            if (regularChar.equals('[')) {
                append_beiju(linkedList, result, iter);
            } else {
                stack.add(regularChar);
            }
            regularChar = iter.next();
        }
        while(!stack.empty()) {
            result.addFirst(stack.pop());
        }
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
