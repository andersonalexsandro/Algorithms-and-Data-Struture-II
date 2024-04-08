package io.github.andersonalexsandro.SecundModule.minimumSpadingTree.graph;

import io.github.andersonalexsandro.SecundModule.heap.MinHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Graph2 {
    private LinkedList<Edge2>[] adjacencyArray;
    private int nVertex;

    public Graph2(int nVertex) {
        this.nVertex = nVertex;
        this.adjacencyArray = new LinkedList[nVertex];
        instatiateAdjacencyArray();
    }

    private void instatiateAdjacencyArray(){
        for(int i = 0; i< nVertex; i++) adjacencyArray[i] = new LinkedList<>();
    }

    public void addBidirectionalEdge(int weight, int src, int dst){
        adjacencyArray[src].add(new Edge2(src, dst, weight));
        adjacencyArray[dst].add(new Edge2(dst, src,weight));
    }

    public void addDirectionalEdge(int weight, int src, int dst){
        adjacencyArray[src].add(new Edge2(src, dst, weight));
    }

    public Graph2 prim(Graph2 graph, int start){
        boolean[] visited = new boolean[nVertex];
        ArrayList<Integer> priorityQueue = new ArrayList<>();
        MinHeap minHeap = new MinHeap(priorityQueue);
        Graph2 subGraph = new Graph2(nVertex);
        primAlgorithm(graph, subGraph, priorityQueue,visited, start, minHeap);
        return subGraph;
    }

    private ArrayList<Integer> primAlgorithm(Graph2 parentGraph, Graph2 subgraph, ArrayList<Integer> priorityQueue, boolean[] visited, int start, MinHeap minHeap){
        visited[start] = true;
        for(int i=0; i<parentGraph.adjacencyArray[start].size(); i++) minHeap.insert(parentGraph.adjacencyArray[start].get(i).weight);
        int priorityWeight = minHeap.extractMin(priorityQueue);
        Edge2 priorityEdge = getEdge(priorityWeight, start);
        if(priorityEdge == null) return priorityQueue;
        while(visited[priorityEdge.dst]) {
            priorityWeight = minHeap.extractMin(priorityQueue);
            priorityEdge = getEdge(priorityWeight, start);
            if(priorityEdge == null) return priorityQueue;
        }
        subgraph.addBidirectionalEdge(priorityWeight, priorityEdge.src, priorityEdge.dst);
        return primAlgorithm(parentGraph, subgraph, priorityQueue, visited, priorityEdge.dst, minHeap);
    }

    private Edge2 getEdge(int weight, int vertex){
        for(int i=0; i<adjacencyArray[vertex].size(); i++){
            if(adjacencyArray[vertex].get(i).weight == weight) return adjacencyArray[vertex].get(i);
        }
        return null;
    }

    private class Edge2{
        int src;
        int dst;
        int weight;

        public Edge2(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    public void print() {
        for (int i = 0; i < nVertex; i++) {
            System.out.print("Vertex " + i + ":");
            for (Edge2 edge : adjacencyArray[i]) {
                System.out.print(" -> " + edge.dst + " (" + edge.weight + ")");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph2 graph2 = new Graph2(6);
        graph2.addBidirectionalEdge(2, 0, 1);
        graph2.addBidirectionalEdge(4, 0, 2);
        graph2.addBidirectionalEdge(6, 0, 3);

        graph2.addBidirectionalEdge(4, 1, 2);
        graph2.addBidirectionalEdge(3, 1, 3);
        graph2.addBidirectionalEdge(4, 1, 4);
        graph2.addBidirectionalEdge(5, 1, 5);

        graph2.addBidirectionalEdge(3, 2, 4);

        graph2.addBidirectionalEdge(3, 4, 5);

        graph2.addBidirectionalEdge(6, 3, 5);

        graph2.prim(graph2, 0).print();
    }
}
