
import org.junit.Test;


import java.util.Arrays;



import static org.junit.Assert.*;

public class AlgorithmsTest {

    @Test
    public void quickSort() {
        int[] arr0 = {1,2,3,0};
        assertArrayEquals(new int[]{0,1,2,3}, Algorithms.quickSort(arr0));
    }

    @Test
    public void test_partition() {
        int middleIndex;
        int[] evenArr = {3,6,1,4};
        System.out.println("Before: " + Arrays.toString(evenArr));
        middleIndex = Algorithms.partition(evenArr, 1, evenArr.length-1);
        System.out.println(Integer.toString(middleIndex) + " After: " + Arrays.toString(evenArr));

        evenArr = new int[]{5, 1,2,3, 6,7,8};
        System.out.println("Before: " + Arrays.toString(evenArr));
        middleIndex = Algorithms.partition(evenArr, 1, evenArr.length-1);
        System.out.println(Integer.toString(middleIndex) + " After: " + Arrays.toString(evenArr));

        evenArr = new int[]{5, 10,2,55, 16,1,4};
        System.out.println("Before: " + Arrays.toString(evenArr));
        middleIndex = Algorithms.partition(evenArr, 1, evenArr.length-1);
        System.out.println(Integer.toString(middleIndex) + " After: " + Arrays.toString(evenArr));

    }

    @Test
    public void test_selection() {
        int[] intArr = {4, 444, 0, 10, 20, 9, 3};
        int result;
        result = Algorithms.selection(intArr, 0, intArr.length-1, 3);
        System.out.println("Result: " + Integer.toString(result));
    }
}