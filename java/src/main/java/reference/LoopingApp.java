package reference;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LoopingApp{
    public static void main(String[] args) {

        // WHILE-LOOP
        int x = 2;
        while(x == 2) {
            System.out.println(x);
            ++x;
        }
        // Any variables used in the expression of a while loop must be declared before the expression is evaluated.
        // while (int x = 2) { } // not legal

        // DO-LOOP
        // Be sure to note the use of the semicolon at the end of the while expression.
        do {
            System.out.println("Inside loop");
        } while(false);

        // FOR-LOOP
        for (int i = 0; i < 10; i++) {
            System.out.println("i is " + i);
        }
        // The declaration and initialization happens before anything else in a for loop.
        for (int z = 10, y = 3; y > 3; y++) { }
        // The three expressions of the for loop are optional;
        // for ( ; ; ) { } // infinite loop

        // ENHANCED FOR LOOP (Java 6 and up)
        int [] a = {1,2,3,4};
        for(int n : a) System.out.print(n);

        // ITERATORS
        List<String> ls = new ArrayList<String>();
        ls.add("one"); ls.add("Three");
        Iterator it= ls.iterator();
        while(it.hasNext()) {
            String value= (String) it.next();
            System.out.println("Value :"+value);
        }

        // BREAK AND CONTINUE
        // break and continue break out of first loop NOT second loop
        // i=0,j=0
        // i=1,j=0
        // i=2,j=0
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(j == 1) { break; } // break will break out of first loop
                System.out.println("i=" + i + ",j=" + j);
            }
        }
    }
}