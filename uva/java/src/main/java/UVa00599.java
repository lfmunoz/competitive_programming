/*

UVa00599 -

https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=16&page=show_problem&problem=1796
https://www.udebug.com/UVa/00599

(v−e = number of connected
components, keep a bitset of size 26 to count the number of vertices that
have some edge. Note: Also solvable with Union-Find)

https://www.youtube.com/watch?v=5a8kGBnOqHU
https://www.programcreek.com/2014/05/leetcode-number-of-connected-components-in-an-undirected-graph-java/
https://www.coursera.org/lecture/algorithms-part2/connected-components-Dzl65
*/

package uva00599;

// Copy-paste from here...
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws Exception {
        UVa00599 uva = new UVa00599();
        //uva.runTest();
        uva.run();
    }
}


class CC {
    private Map<String, Boolean> marked;   // marked[v] = has vertex v been marked?
    private Map<String, Integer> id;           // id[v] = id of connected component containing v
    private int[] size;         // size[id] = number of vertices in given component
    private int count;          // number of connected components

    //constructor
    public CC(Graph G) {
        count = 0;
        marked = new HashMap<>(G.V());
        id = new HashMap<>(G.V());
        size = new int[G.V()];


        G.getGraph().entrySet().forEach((entry) -> {
            if(!marked.getOrDefault(entry.getKey(), false)) {
                dfs(G, entry.getKey());
                count++;
            }

        });

    }

    public int[] getSize() {
        return size;
    }

    public void dfs(Graph G, String v) {
        marked.put(v, true);
        id.put(v, count);
        size[count]++;
        for (String w: G.adj(v)) {
            if(!marked.getOrDefault(w, false)) {
                dfs(G, w);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < size.length; idx++) {
            sb.append(idx); sb.append(": ");
           /// sb.append(id[idx]);
          //  sb.append("  ");
            sb.append(size[idx]);
            sb.append("\n");
        }
        return sb.toString();
    }
}


class Graph {

    private int V;

    // Adjacency-list
    private Map<String, Set<String>> adj;

    /**
     * Constructor
     * tinyG.txt
     * 3  # Number of V
     * 3 # Number of E
     * 1 3
     * 1 2
     * 2 1
     */
    // create a graph from input stream
    Graph(List<Map.Entry<String, String>> edges, List<String> vertices) {
        adj = new HashMap<>();
        V = vertices.size();
        vertices.forEach( (v) -> {
            adj.put(v, new HashSet<>());
        });

        for(Map.Entry<String, String> entry: edges) {
           addEdge(entry.getKey(), entry.getValue());
        }
    }

    // add an edge v-w
    void addEdge(String v, String w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    // vertices adjacent to v
    public Iterable<String> adj(String v) {
        return adj.get(v);

    }

    public Map<String, Set<String>> getGraph() {
        return adj;
    }

    // number of vertices
    public int V() {
        return V;
    }

    // String representation
    public String toString() {
        StringBuilder sb = new StringBuilder();
        adj.entrySet().forEach( (entity) -> {
            sb.append(entity.getKey()); sb.append(": ");
            for(String edge: entity.getValue()) {
                sb.append(edge);
                sb.append(" ");
            }
            sb.append("\n");

        });
        return sb.toString();
    }

}


class UVa00599 {

    private String fileName = "/home/luis/projects/competitive_programming/src/main/resources/uva00599_in.txt";

    public void run() {
        //Scanner scan =readFile(fileName);
        Scanner scan =read();

        int problems = Integer.parseInt(scan.nextLine());
        for(int prob = 0; prob < problems; prob++) {
            List<Map.Entry<String, String>> edges = new ArrayList<>();
            List<String> vertices ;
            while (true) {
                String inputLine = scan.nextLine();
                if(inputLine.charAt(0) == '*') {
                    vertices = Arrays.asList(scan.nextLine().split(","))
                            .stream().collect(Collectors.toCollection(ArrayList::new));


                   // scan.nextLine().split(",")
                    break;
                }
                String v = String.valueOf(inputLine.charAt(1));
                String w = String.valueOf(inputLine.charAt(3));
                edges.add(new AbstractMap.SimpleEntry(v, w));
            }
            Graph graph = new Graph(edges, vertices);
            CC cc = new CC(graph);
           // System.out.println(graph.toString());

            int[] size = cc.getSize();
            int trees = 0;
            int acorns = 0;
            for(int idx = 0; idx < size.length; idx++) {
               if (size[idx] == 1) {
                   acorns++;
               } else if(size[idx] > 1) {
                   trees++;
               } else {
                   break;
               }
            }
            //System.out.println(cc.toString());
            System.out.printf("There are %d tree(s) and %d acorn(s).%n", trees, acorns);


        }


    }



    ////////////////////////////////////////////////////////////////////
    // Input/Output Specific Functions
    ////////////////////////////////////////////////////////////////////
    public Scanner read() {
        Scanner scan = new Scanner(System.in);
        return scan;
    }

    public BufferedReader readwithBuffer() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br;
    }

    public static Scanner readFile(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scan = new Scanner(file);
            return  scan;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
