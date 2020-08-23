
import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;  // main one

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

    @Test
    public void test_scanSortedArray() {
        int[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 12, 250};

        assertThat(Algorithms.scanSortedArray(intArr, 7, 9, 1))
                .isEqualTo(-1);

        assertThat(Algorithms.scanSortedArray(intArr, 0, intArr.length-1, 10))
                .isEqualTo(-1);

        assertThat(Algorithms.scanSortedArray(intArr, 0, 1, 10))
                .isEqualTo(-1);

        assertThat(Algorithms.scanSortedArray(intArr, 0, 1, 2))
                .isEqualTo(1);
        assertThat(Algorithms.scanSortedArray(intArr, 0, 1, 1))
                .isEqualTo(0);
        assertThat(Algorithms.scanSortedArray(intArr, 0, 0, 1))
                .isEqualTo(0);
        assertThat(Algorithms.scanSortedArray(intArr, 0, intArr.length-1, 4))
                .isEqualTo(3);
        assertThat(Algorithms.scanSortedArray(intArr, 0, intArr.length-1, 1))
                .isEqualTo(0);
        assertThat(Algorithms.scanSortedArray(intArr, 0, intArr.length-1, 6))
                .isEqualTo(5);
        assertThat(Algorithms.scanSortedArray(intArr, 0, intArr.length-1, 7))
                .isEqualTo(6);
        assertThat(Algorithms.scanSortedArray(intArr, 0, intArr.length-2, 6))
                .isEqualTo(5);
        assertThat(Algorithms.scanSortedArray(intArr, 0, intArr.length-2, 5))
                .isEqualTo(4);
    }

    @Test
    public void test_findMiddleIndex() {
        assertThat(Algorithms.findMiddleIndex(4, 5)).isEqualTo(5);
        assertThat(Algorithms.findMiddleIndex(4, 4)).isEqualTo(4);
        assertThat(Algorithms.findMiddleIndex(1, 3)).isEqualTo(2);
        assertThat(Algorithms.findMiddleIndex(1, 4)).isEqualTo(3);
        assertThat(Algorithms.findMiddleIndex(1, 1)).isEqualTo(1);


    }

    @Test
    public void test_findMiddleIndexL() {
        assertThat(Algorithms.findMiddleIndexL(4, 5)).isEqualTo(4);
        assertThat(Algorithms.findMiddleIndexL(4, 4)).isEqualTo(4);
        assertThat(Algorithms.findMiddleIndexL(1, 3)).isEqualTo(2);
        assertThat(Algorithms.findMiddleIndexL(1, 4)).isEqualTo(2);
        assertThat(Algorithms.findMiddleIndexL(1, 1)).isEqualTo(1);


    }
}