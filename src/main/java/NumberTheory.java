import java.util.HashMap;
import java.util.Map;

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
}
