package io.github.andersonalexsandro.SecundModule.minimumSpadingTree.graph;

public class Edge {
    private int weight;
    private Vertex src;
    private Vertex dst;

    public Edge(int weight, Vertex src, Vertex dst) {
        this.weight = weight;
        this.src = src;
        this.dst = dst;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getSrc() {
        return src;
    }

    public void setSrc(Vertex src) {
        this.src = src;
    }

    public Vertex getDst() {
        return dst;
    }

    public void setDst(Vertex dst) {
        this.dst = dst;
    }
}
