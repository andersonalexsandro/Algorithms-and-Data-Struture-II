package io.github.andersonalexsandro.FirstModule.graph;

import io.github.andersonalexsandro.FirstModule.graph.Color;

import java.util.Objects;

public class Vertex {

    private int number;
    private Color color;
    private Vertex predecessor;
    private int distance;
    private int secondVisit;

    public Vertex(int number) {
        this.number = number;
        this.color = Color.WHITE;
    }


    public int getNumber() {
        return number;
    }


    public Color getColor() {
        return color;
    }


    public int getDistanceFromSource() {
        return distance;
    }


    public Vertex getPredecessor() {
        return predecessor;
    }


    public void setNumber(int number) {
        this.number = number;
    }


    public void setColor(Color color) {
        this.color = color;
    }


    public void setDistanceFromSource(int distance) {
        this.distance = distance;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getSecondVisit() {
        return secondVisit;
    }

    public void setSecondVisit(int secondVisit) {
        this.secondVisit = secondVisit;
    }

    private Integer getPredecessorNumber(){
        if(predecessor != null) return predecessor.number;
        return null;
    }

    @Override
    public String toString() {
        return "{vrtx:"+ number+ " d:" + distance + " pred:" + getPredecessorNumber() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex vertex)) return false;
        return getNumber() == vertex.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
