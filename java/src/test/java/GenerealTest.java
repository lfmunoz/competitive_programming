import graph.SparseTableRangeMinimumQuery;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

////////////////////////////////////////////////////////////////////////////////
// SparseTableRangeMinimumQueryTest
////////////////////////////////////////////////////////////////////////////////
public class GenerealTest {
    ////////////////////////////////////////////////////////////////////////////////
    // Tests
    ////////////////////////////////////////////////////////////////////////////////
    @Test
    public void zeroIndexedAndInclusive() throws Exception {

        int threads = 10;
        System.out.println("Start " + Thread.currentThread().getName());

        Thread[] tArr = new Thread[threads];

        for(int i = 0; i < threads; i++) {
            final int iFinal = i;
            tArr[iFinal] = new Thread(() -> {

                int count = 0;
                while(count < 1000) {
                    System.out.printf("%d", iFinal);
                    count++;
                    if(count % 10 == 0) {
                        //Thread.yield();
                        try {

                            Thread.sleep(100L);
                        } catch( Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                //String name = "t" + String.valueOf(iFinal) + " ";
                //System.out.println(name + Thread.currentThread().getName());

            });
            tArr[iFinal].start();
        }


        for(int i = 0; i < threads; i++) {
            tArr[i].join();
        }

    }




}