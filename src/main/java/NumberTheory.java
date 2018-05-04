import java.util.ArrayList;
import java.util.Arrays;
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
}
