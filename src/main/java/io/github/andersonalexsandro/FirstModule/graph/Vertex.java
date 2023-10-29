package io.github.andersonalexsandro.FirstModule.graph;

import java.util.Objects;

public class Vertex {
    private Color color;
    private Integer number;
    private Vertex predecessor;
    private int distance;
    private int secondVisitDistance;

    public Vertex(Integer number) {
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getSecondVisitDistance() {
        return secondVisitDistance;
    }

    public void setSecondVisitDistance(int secondVisitDistance) {
        this.secondVisitDistance = secondVisitDistance;
    }

    @Override
    public String toString() {
        return "{Vertex " + number + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(number, vertex.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
