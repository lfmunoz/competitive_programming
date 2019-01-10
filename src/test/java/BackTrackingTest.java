
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


import static org.junit.Assert.*;

public class BackTrackingTest {

    @Test
    public void permutate_N_Integers() {
        int[] numbers =IntStream.range(0, 3).toArray();
        //System.out.println(arrayToString(numbers));
        permutate_N(numbers, 0);
    }

    @Test
    public void permutate_N_Strings() {
         String str = "ABC";
         int n = str.length();
         permute(str, 0, n-1);
    }

    @Test
    public void include_Not_include() {
        int[] numbers =IntStream.range(0, 3).toArray();
        include(numbers, 0, new ArrayList<>());
    }

    ////////////////////////////////////////////////////////////////////////////////
    // include or not include int array
    ////////////////////////////////////////////////////////////////////////////////
    public void include(int[] myArr, int left, List<Integer> result) {
       //  indent(left);
       //  System.out.println(left + " : "  + listToString(result));
       if(left == myArr.length) {
            System.out.println(listToString(result));
            return;
       }

       // don't include
        include(myArr, left+1,result);
        // include
        result.add(myArr[left]);
        include(myArr, left+1, result);
        result.remove(result.size()-1);
    }

   ////////////////////////////////////////////////////////////////////////////////
    // int array permutation
   ////////////////////////////////////////////////////////////////////////////////
    public void permutate_N(int[] myArr, int left) {
       // indent(left);
       // System.out.println(left + " : "  + arrayToString(myArr));
       if(left == myArr.length-1) {
           System.out.println(arrayToString(myArr));
           return;
       }


       for(int i = left; i <= myArr.length - 1; i++) {
           swap(myArr, left, i);
           permutate_N(myArr, left+1);
           swap(myArr, left, i);
       }

    }

    public void swap(int[] myArr, int a, int b) {
        int tmp = myArr[a];
        myArr[a] = myArr[b];
        myArr[b] = tmp;
    }

    public void indent(int N) {
       for(int i = 0; i < N; i++) {
           System.out.printf(" ");
       }
    }


    public String arrayToString(int[] myArr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < myArr.length; i++) {
            sb.append(myArr[i] + " ");
        }
        return sb.toString();
    }

    public String listToString(List<Integer> myArr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < myArr.size(); i++) {
            sb.append(myArr.get(i) + " ");
        }
        return sb.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////
    // string
    ////////////////////////////////////////////////////////////////////////////////

    /*
0 : ABC
 1 : ABC
  2 : ABC
ABC
  2 : ACB
ACB
 1 : BAC
  2 : BAC
BAC
  2 : BCA
BCA
 1 : CBA
  2 : CBA
CBA
  2 : CAB
CAB
     */
    private void permute(String str, int l, int r)
    {
       // indent(l);
       // System.out.println(l + " : "  + str);

        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}