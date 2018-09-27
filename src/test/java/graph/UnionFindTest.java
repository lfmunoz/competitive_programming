package graph;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class UnionFindTest {

    // uut
    private UnionFind uf;
    private int count = 5;

    @Before
    public void setUp() {
        uf = new UnionFind(count);
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Tests
    ////////////////////////////////////////////////////////////////////////////////
    @Test
    public void simpleInputSet() {
        System.out.println(uf.toString());
        uf.union(0, 1);
        System.out.println(uf.toString());
        uf.union(2, 3);
        uf.union(4, 3);
        System.out.println(uf.toString());

    }

}