package competitive;


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


// TODO:
// Learn Unit Testing
// Learn Logging
public class UVa725 {

    public static void main() {

        System.out.println("UVa725");
        // abcde / fghij = N  : 2 <= N <= 79
        //
        int sum = 0;
        for(int fghij = 01234; fghij<= 98765; fghij++ ) {
            for(int N = 2; N <= 72 ; N++) {
                    int result = fghij * N;
                    sum += 1;
            }
        }
        System.out.println("Total " + sum);
    }

    // given two numbers num1, num2 return true if
    // all the digits between 0 and 9 are represented
    public boolean check_digits(int num1, int num2) {
        boolean[] digitVerify = new boolean[10];
        int number = num1*100000 + num2;
        int digit = 0;
        // loop through each digit
        for(int i = 0; i < 10; i++) {
            digit = digit % 10;
            number = number / 10;
            if (digitVerify[digit] == true) {
                return false;
            }
            digitVerify[digit] = true;
        }
        return false;
    }
}
