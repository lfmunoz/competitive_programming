import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberTheory {

   private Map<Integer, Integer> dict = new HashMap<>();

    public static int fibonacci(int num) {
        if (0 == num || 1 == num) return 1;
        return fibonacci(num-1) + fibonacci(num-2);
    }

    public int fibonacciMemoization(int num) {
        if (dict.containsKey(num)) return dict.get(num);
        if (1 >= num) return 1;
        int result = fibonacciMemoization(num-1) + fibonacciMemoization(num-2);
        dict.put(num, result);
        return result;
    }

    public static boolean divides(int a, int b) {
        int result = b % a;
        System.out.printf("%d mod %d = %d %n", b, a, result);
        return result == 0;
    }

    public static int factorial(int num) {
        return 1;
    }

    public int factorialMemoization(int num) {
        return 1;
    }


    public static List<String> permutations(String input) {
        //List<String> unitArr = new ArrayList<>(Arrays.asList(input.split("")));
        //return permutations(unitArr);
       List<String> result = new ArrayList<>();
       permutations(result, input, 0, input.length()-1);
       return result;
    }

    //https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    //https://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
    /*
    public static List<String> permutations(List<String> input) {
        int size = input.size();
        if (size == 2) {
            List<String> newList = new ArrayList<String>();
            newList.add(String.join("", Arrays.asList(input.get(1), input.get(0))));
            newList.add(String.join("", Arrays.asList(input.get(0), input.get(1))));
            return newList;
        }

        //input.remove(size-1);

        return input ;
    }
    */
    public static void permutations(List<String> result, String input, int left, int right) {
        if(left == right) {
           result.add(input);
        } else {
            for(int idx = left; idx <= right; idx++) {
                String temp = swap(input, left, idx);
                permutations(result, temp, left+1, right);
            }

        }
    }

    public static String swap(String str, int x, int  y) {
        char[] c = str.toCharArray();
        char tmp = c[x];
        c[x] = c[y];
        c[y] = tmp;
        return new String(c);
    }


    /**
     *  Generate permutations given a list of Integers
     * @param result
     * @param input
     * @param left - starting index (inclusive)
     * @param right - ending index (inclusive)
     */
    public <T> void permutations(List<List<T>> result, List<T> input, int left, int right) {
        if(left == right) {
            result.add(input);
        } else {
            for(int idx = left; idx <= right; idx++) {
                List<T> temp = swap(input, left, idx);
                permutations(result, temp, left+1, right);
            }

        }
    }

    public <T> List<T> swap(List<T> c, int x, int  y) {
        List<T> temp  = new ArrayList<T>(c);
        Collections.swap(temp, x, y);
        return temp;
    }



    void iterativeNestedLoop(int depth, int max)
    {
        // Initialize the slots to hold the current iteration value for each depth
        //int* slots = (int*)alloca(sizeof(int) * depth);
        int[] slots = new int[depth];

        for (int i = 0; i < depth; i++) {
            slots[i] = 0;
        }

        int index = 0;
        while (true) {
            // TODO: Your inner loop code goes here. You can inspect the values in slots


            System.out.printf("%d %d %n", slots[0], slots[1]);

            // Increment
            slots[0]++;

            // Carry
            while (slots[index] == max) {
                // Overflow, we're done
                if (index == depth - 1) {
                    return;
                }

                slots[index++] = 0;
                slots[index]++;
            }

            index = 0;
        }
    }

}
