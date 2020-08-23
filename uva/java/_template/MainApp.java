
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Comparator.*;

class MainApp {
    public static void main(String[] args) {


    }

}


// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
        import java.util.ArrayList;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    int TOTAL_HOUSES = 8;

    List<Integer> solution = new ArrayList(TOTAL_HOUSES);
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {



        return solution;
        // WRITE YOUR CODE HERE
    }

    private updateSolution() {
        List<Integer> tempSolution = new ArrayList(TOTAL_HOUSES);

        for(int house = 0; house < TOTAL_HOUSES; house++ ) {
            if(house == 0 ) {
                solution
            }
        }

    }

    // METHOD SIGNATURE ENDS
}









// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.stream.Collectors;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    int TOTAL_HOUSES = 8;

    List<Boolean> solution = new ArrayList<Boolean>(TOTAL_HOUSES);
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        for(int i = 0; i < TOTAL_HOUSES; i++) {
            solution.add(states[i] == 1 );
        }
        for(int day = 0; day < days; day++) {
            updateSolution();
        }

        return solution.stream().map(i ->  i ? 1 : 0 ).collect(Collectors.toList());

        // WRITE YOUR CODE HERE
    }

    private void updateSolution() {
        List<Boolean> tempSolution = new ArrayList<Boolean>(TOTAL_HOUSES);

        for(int idx = 0; idx < TOTAL_HOUSES; idx++ ) {
            if(idx == 0 ) {
                tempSolution.add( XOR(false, solution.get(idx + 1))  );
            } else if(idx == TOTAL_HOUSES - 1) {
                tempSolution.add( XOR(solution.get(idx - 1 ), false) );
            } else {
                tempSolution.add( XOR(solution.get(idx -1), solution.get(idx + 1)) );
            }
        }
        solution = tempSolution;
    }

    private Boolean XOR(boolean A, boolean B) {
        if(A && B) return false;
        if(!A && !B) return false;
        return true;
    }




    // METHOD SIGNATURE ENDS
}


