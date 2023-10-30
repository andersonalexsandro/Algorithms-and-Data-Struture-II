package io.github.andersonalexsandro.FirstModule.graph;

import io.github.andersonalexsandro.FirstModule.queue.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private int numberOfVertices;
    private LinkedList<Integer>[] adjacencyArray;

    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyArray = new LinkedList[numberOfVertices];
        instantiateAdjacencyArray();
    }


    public List<Vertex> breadthFirstSearch(Integer source){
        List<Vertex> vertices = new ArrayList<>();
        for(int i=0; i<numberOfVertices; i++) vertices.add(i, new Vertex(i));
        Vertex sourceVertx = vertices.get(source);
        sourceVertx.setColor(Color.GRAY);
        sourceVertx.setDistanceFromSource(0);
        Queue<Vertex> queue = new Queue<>(numberOfVertices);
        queue.enqueue(sourceVertx);
        while (!queue.isEmpty()){
            Vertex current = queue.dequeue();
            LinkedList<Integer> neighborhood = adjacencyArray[current.getNumber()];
            neighborhood.forEach(neighborhoodNumber -> {
                Vertex neighbor = vertices.get(neighborhoodNumber);
                if(neighbor.getColor().equals(Color.WHITE)){
                    neighbor.setColor(Color.GRAY);
                    neighbor.setPredecessor(current);
                    neighbor.setDistanceFromSource(current.getDistanceFromSource() + 1);
                    queue.enqueue(neighbor);
                }
            });
            current.setColor(Color.BLACK);
        }
        return vertices;
    }

    public List<Vertex> depthFirstSearch(){
        List<Vertex> vertices = new ArrayList<>(numberOfVertices);
        for(int i=0; i<numberOfVertices; i++) vertices.add(new Vertex(i));
        int time = 0;
        vertices.forEach(vertex -> {
            if(vertex.getColor().equals(Color.WHITE)) searchVisit(vertices, vertex, time);
        });
        return vertices;
    }

    private void searchVisit(List<Vertex> vertices, Vertex current, int time){
        int distance = ++time;
        current.setDistanceFromSource(time);
        current.setColor(Color.GRAY);
        LinkedList<Integer> neighborhoodNumbers = adjacencyArray[current.getNumber()];
        neighborhoodNumbers.forEach(neighborhoodNumber ->{
            Vertex neighbor = vertices.get(neighborhoodNumber);
            if(neighbor.getColor().equals(Color.WHITE)){
                neighbor.setPredecessor(current);
                searchVisit(vertices, neighbor, distance);
            }
        });
        current.setColor(Color.BLACK);
        ++time;
        current.setSecondVisit(time);
    }


    public List<Vertex> sourceToDestinInOrder(int sourceNumber, int destinNumber, List<Vertex> vertices){
        ArrayList<Vertex> result = new ArrayList<>();
        Vertex source = vertices.get(sourceNumber);
        Vertex destin = vertices.get(destinNumber);
        inOrderTraversal(result, source, destin);
        return result;
    }

    private void inOrderTraversal(List<Vertex> result, Vertex source, Vertex destin){
        if(source.equals(destin)) result.add(destin);
        else {
            if(destin.getPredecessor() == null) throw new IllegalArgumentException("There is no way to source");
            else{
                inOrderTraversal(result, source, destin.getPredecessor());
                result.add(destin);
            }
        }
    }

    private void instantiateAdjacencyArray(){
        for(int i = 0; i< numberOfVertices; i++) adjacencyArray[i] = new LinkedList<>();
    }

    public void addNeighbors(int vertexNumber, List<Integer> neighborsNumbers){
        neighborsNumbers.forEach(numberOfVertices -> adjacencyArray[vertexNumber].add(numberOfVertices));
    }

    public LinkedList<Integer>[] getAdjacencyArray() {
        return adjacencyArray;
    }

    public void setAdjacencyArray(LinkedList<Integer>[] adjacencyArray) {
        this.adjacencyArray = adjacencyArray;
    }

}
