
import java.util.List;

import org.junit.Test;

// http://joel-costigliola.github.io/assertj/assertj-core-quick-start.html
import static org.assertj.core.api.Assertions.assertThat;  // main one

public class NumberTheoryTest {

    final private long N_MAX = 10;


    @Test
    public void divides_test() {
       // assertThat(NumberTheory.divides(0, 0)).isFalse();
        assertThat(NumberTheory.divides(6, 0)).isTrue();
        assertThat(NumberTheory.divides(5, 10)).isTrue();
        assertThat(NumberTheory.divides(2, 10)).isTrue();
        assertThat(NumberTheory.divides(1, 10)).isTrue();
        assertThat(NumberTheory.divides(3, 10)).isFalse();
    }

    @Test
    public void fibonacci_test() {
        assertThat(NumberTheory.fibonacci(0)).isEqualTo(1);
        assertThat(NumberTheory.fibonacci(1)).isEqualTo(1);
        assertThat(NumberTheory.fibonacci(2)).isEqualTo(2);
        assertThat(NumberTheory.fibonacci(3)).isEqualTo(3);
        assertThat(NumberTheory.fibonacci(4)).isEqualTo(5);
        assertThat(NumberTheory.fibonacci(5)).isEqualTo(8);
        assertThat(NumberTheory.fibonacci(6)).isEqualTo(13);
        assertThat(NumberTheory.fibonacci(7)).isEqualTo(21);
        assertThat(NumberTheory.fibonacci(8)).isEqualTo(34);
        assertThat(NumberTheory.fibonacci(9)).isEqualTo(55);
        assertThat(NumberTheory.fibonacci(10)).isEqualTo(89);
        assertThat(NumberTheory.fibonacci(11)).isEqualTo(144);
    }

    @Test
    public void fibonacciMemoization_test() {
        NumberTheory util = new NumberTheory();
        assertThat(util.fibonacciMemoization(0)).isEqualTo(1);
        assertThat(util.fibonacciMemoization(1)).isEqualTo(1);
        assertThat(util.fibonacciMemoization(2)).isEqualTo(2);
        assertThat(util.fibonacciMemoization(3)).isEqualTo(3);
        assertThat(util.fibonacciMemoization(4)).isEqualTo(5);
        assertThat(util.fibonacciMemoization(5)).isEqualTo(8);
        assertThat(util.fibonacciMemoization(6)).isEqualTo(13);
        assertThat(util.fibonacciMemoization(7)).isEqualTo(21);
        assertThat(util.fibonacciMemoization(8)).isEqualTo(34);
        assertThat(util.fibonacciMemoization(9)).isEqualTo(55);
        assertThat(util.fibonacciMemoization(10)).isEqualTo(89);
        assertThat(util.fibonacciMemoization(11)).isEqualTo(144);


    }

    @Test
    public void fibonacci_performance_test() {
        long startTime;
        long endTime;
        long duration;
        // function fibonacciMemoization()
        startTime = System.nanoTime();
        NumberTheory util = new NumberTheory();
        for(int x = 0; x < N_MAX; x++) {
            util.fibonacciMemoization(x);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.printf("fibonacciMemoization() duration (nanoseconds): %d \n", duration);
        // function fibonacci()
        startTime = System.nanoTime();
        for(int x = 0; x < N_MAX; x++) {
            NumberTheory.fibonacci(x);
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.printf("fibonacci() duration (nanoseconds): %d \n", duration);

    }

    @Test
    public void permutations_test() {
        //List<String> result = NumberTheory.permutations("ab");
        assertThat(NumberTheory.permutations("abc")).hasSize(6);
        assertThat(NumberTheory.permutations("abcd")).hasSize(24);
        assertThat(NumberTheory.permutations("abcde")).hasSize(120);

    }



}
