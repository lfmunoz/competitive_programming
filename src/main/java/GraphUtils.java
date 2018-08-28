public class GraphUtils {


    // Class CC - Connected Components
    class CC {
        private boolean marked[];
        private int[] id;
        private int count;

        // Constructor
        public CC(Graph G) {
            id = new int[G.V()];
            for (int v = 0; v < G.V(); v++) {
                if(!marked[v]) {
                    dfs(G,v);
                    count++;
                }
            }
        }

        public int count() {
            return count;
        }

        public int id(int v) {
            return id[v];

        }

        public void dfs(Graph G, int v) {

            id[v] = count;
            for (int w: G.adj(v)) {
                if(!marked[w]) {
                    dfs(G, w);
                }
            }
        }
    } // end of CC class


}
