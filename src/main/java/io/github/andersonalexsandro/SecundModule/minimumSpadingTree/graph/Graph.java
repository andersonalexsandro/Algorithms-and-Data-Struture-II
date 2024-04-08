package io.github.andersonalexsandro.SecundModule.minimumSpadingTree.graph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertexies;
    private ArrayList<Edge> edges;

    public Graph(){
        this.vertexies = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(int value){
        Vertex vertex = new Vertex(value);
        this.vertexies.add(vertex);
    }

    public void addEdge(int weight, int src, int dst){
        Vertex vertxSrc = getVertex(src);
        Vertex vertexDst = getVertex(dst);
        Edge edge = new Edge(weight, vertxSrc, vertexDst);
        vertxSrc.addEdgeOut(edge);
        vertexDst.addEdgeIn(edge);
        edges.add(edge);
    }

    public Vertex getVertex(int value){
        return vertexies.stream().filter(vertex -> vertex.getValue() == value).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        for(int i=0; i<6; i++) graph.addVertex(i);

        //0
        graph.addEdge(2, 0, 1);
        graph.addEdge(2, 1, 0);

        graph.addEdge(4, 0, 2);
        graph.addEdge(4, 2, 0);

        graph.addEdge(6, 0, 3);
        graph.addEdge(6, 3, 0);
        //

        //1
        graph.addEdge(4, 1, 2);
        graph.addEdge(4, 2, 1);

        graph.addEdge(3, 1, 3);
        graph.addEdge(3, 3, 1);

        graph.addEdge(5, 1, 5);
        graph.addEdge(5, 5, 1);

        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 4, 1);
        //

        //2
        graph.addEdge(3, 2, 4);
        graph.addEdge(3, 4, 2);
        //

        //3
        graph.addEdge(6, 3, 5);
        graph.addEdge(6, 5, 3);
        //

        //4
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 5, 4);
        //

    }
}


