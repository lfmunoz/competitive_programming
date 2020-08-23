package graph;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class SegmentTreeTest {
    // uut
    private SegmentTree uut;


    @Test
    public void rmqTest() {
        int[] input = {1,3,5,7,9,11};

        uut = new SegmentTree(input, input.length);
        System.out.println(uut.toString());

    }

}