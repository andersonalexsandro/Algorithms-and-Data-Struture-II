package io.github.andersonalexsandro.SecundModule.minimumSpadingTree.graph;

import java.util.ArrayList;

public class Vertex {

    private ArrayList<Edge> inEdges = new ArrayList<>();
    private ArrayList<Edge> outEdges = new ArrayList<>();

    private int value;

    public Vertex(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addEdgeIn(Edge edge){
        this.inEdges.add(edge);
    }

    public void addEdgeOut(Edge edge){
        this.outEdges.add(edge);
    }
}
