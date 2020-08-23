package reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgorithmPatternsApp {

    public static void main(String[] args) {
        System.out.println("________________________________________________________________________________");
        System.out.println("  O(n!)");
        System.out.println("________________________________________________________________________________");
        List<Integer> ourList = Arrays.asList(1,2,3);
        permutations(ourList, 0);

        System.out.println("________________________________________________________________________________");
        System.out.println("  O(n)");
        System.out.println("________________________________________________________________________________");
        int SIZE = 3;
        int[] arr = new int[]{1,2,3};
        arrLoop(arr, SIZE);

        System.out.println("________________________________________________________________________________");
        System.out.println("  O(n^2)");
        System.out.println("________________________________________________________________________________");
        int ROWS = 3, COLS = 3;
        int[][] matrix = new int[][]{
                {0, 1, 2},
                {5, 6, 7},
                {0, 1, 2}
        };
        matrixLoop(matrix, ROWS, COLS);
    }

    //________________________________________________________________________________
    // O(n)
    //________________________________________________________________________________
    static private void arrLoop(int[] arr, int SIZE) {
        System.out.print("[");
        for(int x = 0; x < SIZE; x++) {
            System.out.print(x) ;
            if(x != SIZE-1) System.out.print(",");
        }
        System.out.print("]");
        System.out.println();
    }
    //________________________________________________________________________________
    // O(n^2)
    //________________________________________________________________________________
    static private void matrixLoop(int[][] matrix, int ROWS, int COLS) {
        for(int x = 0; x < ROWS ; x++) {
            for(int y = 0; y < COLS; y++) {
                System.out.print("(" + x + "," + y +")");
            }
            System.out.println();
        }
    }
    //________________________________________________________________________________
    // O(n!)
    //________________________________________________________________________________
    static private void permutations(List<Integer> aList, int idx) {
        if(idx == aList.size()) {
           System.out.println(aList);
           return;
        }
        for(int i = idx; i < aList.size() ; i++) {
            permutations(copyAndSwap(aList, idx, i), idx + 1);
        }
    }

    static private List<Integer> copyAndSwap(List<Integer> aList, int idxA, int idxB) {
        List<Integer> clonedList = new ArrayList(aList);
        Integer tmp = clonedList.get(idxA);
        clonedList.set(idxA, clonedList.get(idxB));
        clonedList.set(idxB, tmp);
        return clonedList;
    }

}
