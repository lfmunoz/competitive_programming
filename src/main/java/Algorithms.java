import java.util.Arrays;

public class Algorithms {



    static public int[] quickSort(int[] arr) {
        int pivot = arr[arr.length-1]; //pivot is last number


            return arr;


    }

    /* Input:
        X (an array),
        left (the left boundary)
        right (the right boundary)
       Output:
        X (mutated in place)
        Middle such that X[i] <= X [Middle] for all i <= Middle and
        X[j] > X[Middle] for all j > Middle


     */
    static public int partition (int[] X, int left, int right) {
        int pivot = X[left]; // select first element as pivot
        int L = left;
        int R = right;
        while ( L < R ) {
            while ( X[L] <= pivot && L < right) {
                L = L + 1;
            }
            while ( X[R] > pivot && R >= left) {
                R = R - 1;
            }
            if (L < R) {
                swap(X, L, R);
            }

        }
        swap(X, left, R);
        return R;
    }



    static public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /*
        order statistics or selection - Finding the kth-Smallest Element
        Given a sequence S = x_1, x_2, \dots, x_n of elements, and
        an integer k such that 1 <= k <= n, find the kth-smallest
        element in S.

        Input:
            X (an array in the range of 1 to n), and k (an integer)
        Output:
            S (the kth smallest element; the array X is changed)
     */
    static public int selection(int[] X, int left, int right, int k) {
        System.out.println("right is " + Integer.toString(right));
        if (left == right) {
            return X[left];
        }
        int middle = partition(X, left, right);
        System.out.println("middle is " + Integer.toString(middle));
        System.out.println(Arrays.toString(X));
        if (middle - left + 1 >= k) {
            return selection(X, left, middle, k);
        } else {
            return selection(X, middle+1, right, k-(middle-left+1));
        }
    }


    static public int scanSortedArray(int[] arr, int start, int end, int value) {
        if(start > end) return -1;
        int middle = findMiddleIndex(start, end);
        int diff = Integer.compare(value, arr[middle]);
        if(diff == 0) {
            return middle;
        } else if (diff > 0) {
            return scanSortedArray(arr, middle+1, end, value);
        } else {
            return scanSortedArray(arr, start, middle-1, value);
        }
    }

    static public boolean scanSortedArrayHelper(int[] arr, int idx, int value) {
        return false;
    }


    static public int findMiddleIndex(int startIdx, int endIdx) {
        int difference = (int) Math.ceil( (endIdx - startIdx) / 2.0);
        return  difference + startIdx;
    }

}
