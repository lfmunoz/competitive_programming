package graph;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Real-wrold graphs tend to be sparse
 *   huge number of vertcies, small average vertex degree
 */
public class Graph {

    private int V;

    //Edge list (inefficient)
    List<Integer> edgeList;

    // Adjacency Matrix
    List<List<Boolean>> adjMatrix;

    // Adjacency-list
    List<Set<Integer>> adj;


    // create an empty graph with V vertices
    Graph (int V) {
        this.V  = V;
        adj = new ArrayList<>();
        for(int v = 0; v < V; v++) {
           Set<Integer> vertices = new HashSet<>();
           adj.add(vertices);
        }
    }
    /**
     * tinyG.txt
     * 3  # Number of V
     * 3 # Number of E
     * 1 3
     * 1 2
     * 2 1
     *
     */
    // create a graph from input stream
    Graph (InputStream in) {}

    // add an edge v-w
    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    // vertices adjacent to v
    Iterable<Integer> adj(int v) {
        return adj.get(v);

    }
    // number of vertices
    int V() {
        return V;
    }

    // number of edges
    int E() {

        return 0;
    }

    // String representation
    public String toString() {
        return "";
    }

    /**
     * Compute the degree of v
     */
    public static int degree(Graph G, int v) {
        int degree = 0;
        for(int w: G.adj(v)) degree++;
        return degree;
    }

    /**
     * compute the maximum degree
     */
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if(degree(G, v) > max)
                max = degree(G,v);
        }
        return max;
    }

    /**
     * compute average degree
     */
    public static double averageDegreeGraph(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    /**
     * count self-loops
     */
    public static int numberOfSelfLoops(Graph G) {
       int count = 0;
       for(int v = 0; v < G.V(); v++) {
           for(int w: G.adj(v)) {
               if (v == w) count++;
           }
       }
       return count / 2;
    }
}
