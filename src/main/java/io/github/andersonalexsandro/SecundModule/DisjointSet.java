package io.github.andersonalexsandro.SecundModule;


public class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        }

        if (rank[yRoot] > rank[xRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }

    public static void main(String[] args) {
        // Cria uma instância de DisjointSet com 5 elementos
        DisjointSet ds = new DisjointSet(9);

        // Une alguns conjuntos
        ds.union(0, 2);
        ds.union(4, 2);
        ds.union(3, 1);
        ds.union(5, 8);
        ds.union(6,2);
        ds.union(3,5);
        ds.union(7,3);

        // Imprime o representante de cada conjunto
        for (int i = 0; i < 9; i++) {
            System.out.println("O representante do elemento " + i + " é: " + ds.find(i));
        }
    }
}
