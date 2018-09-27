package graph;

class UnionFind {
    private int[] parent;  // parent[i] = parent of i
    private int[] sz; // array to count number of objects in the tree rooted at i
    private int count;     // number of components


    public UnionFind(int n) {
        parent = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }


    public int count() {
        return count;
    }


    public int find(int p) {
        while (p != parent[p])
            p = parent[p];
        return p;
    }


    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if(sz[rootP] < sz[rootQ]) {
            parent[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            parent[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
        count--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("idx  parent  sz \n");
       for(int i = 0; i < parent.length; i++) {
           sb.append(String.valueOf(i) + "    " +
                   String.valueOf(parent[i]) + "       " +
                   String.valueOf(sz[i]) + "\n");
       }
       return sb.toString();
    }
}
