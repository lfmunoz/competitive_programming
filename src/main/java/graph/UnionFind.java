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

/*

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
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
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

*/


/*
    static class DisjoinSets {

        List<Integer> parent, rank;
        HashMap<String, Integer> map;
        HashMap<Integer, Integer> nMap;
        int total;

        public DisjoinSets() {
            map = new HashMap<String, Integer>();
            nMap = new HashMap<Integer, Integer>();
            parent = new ArrayList<Integer>();
            rank = new ArrayList<Integer>();
            total = 0;
        }

        void makeSet(String s) {
            if (!map.containsKey(s)) {
                map.put(s, total);
                parent.add(total);
                rank.add(0);
                nMap.put(total, 1);
                total++;
            }
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                int totalFriend = nMap.get(px) + nMap.get(py);
                nMap.put(px, totalFriend);
                nMap.put(py, totalFriend);
            }
            if (rank.get(px) > rank.get(py)) {
                parent.set(py, px);
            } else {
                parent.set(px, py);
            }
            if (rank.get(px) == rank.get(py)) {
                rank.set(py, rank.get(py) + 1);
            }
        }

        int find(int x) {
            if (x != parent.get(x)) {
                parent.set(x, find(parent.get(x)));
            }
            return parent.get(x);
        }
    }
 */
