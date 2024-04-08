package io.github.andersonalexsandro.SecundModule.minimumSpadingTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Prim {
    LinkedList<Edge>[] adjacencyList;
    int nEdges;

    public Prim(int nEdges) {
        this.nEdges = nEdges;
        adjacencyList = new LinkedList[nEdges];
        for(int i = 0; i<nEdges; i++) adjacencyList[i] = new LinkedList<>();
    }

    private static class Edge{
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private void addEdge(int src, int dest, int weight) {
        adjacencyList[src].add(new Edge(src, dest, weight));
    }

    public static void main(String args[]) {
        Prim graph = new Prim(7); // 7 vertices from 0 to 6

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 4, 17);

        graph.addEdge(1, 0, 5);
        graph.addEdge(1, 4, 12);
        graph.addEdge(1, 5, 8);
        graph.addEdge(1, 2, 13);

        graph.addEdge(2, 1, 13);
        graph.addEdge(2, 5, 11);
        graph.addEdge(2, 6, 6);

        graph.addEdge(3, 4, 10);
        graph.addEdge(3, 5, 4);

        graph.addEdge(4, 0, 17);
        graph.addEdge(4, 1, 12);
        graph.addEdge(4, 3, 10);
        graph.addEdge(4, 5, 8);

        graph.addEdge(5, 3, 4);
        graph.addEdge(5, 4, 8);
        graph.addEdge(5, 1, 8);
        graph.addEdge(5, 2, 11);
        graph.addEdge(5, 6, 14);

        graph.addEdge(6, 2, 6);
        graph.addEdge(6, 5, 14);
    }
}
