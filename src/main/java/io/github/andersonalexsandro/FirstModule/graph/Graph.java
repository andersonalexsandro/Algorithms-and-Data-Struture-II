package io.github.andersonalexsandro.FirstModule.graph;

import io.github.andersonalexsandro.FirstModule.queue.Queue;

import java.util.LinkedList;

public class Graph {

    private int numberOfVertex;
    private int numberOfEdges;

    private LinkedList<Vertex>[] adjacencyArray;

    public Graph(LinkedList<Vertex>[] adjacencyList) {
        this.adjacencyArray = adjacencyList;
        numberOfVertex = adjacencyList.length;
    }

    public void breadthFirstSearch(Vertex source){
        for(int i=0; i<adjacencyArray.length; i++){
            for(int j=0; j< adjacencyArray[i].size(); j++){
                Vertex vertex = adjacencyArray[i].get(j);
                vertex.setColor(Color.WHITE);
                vertex.setDistance(0);
                vertex.setPredecessor(null);
            }
        }
        source.setColor(Color.GRAY);
        Queue<Vertex> queue = new Queue<>(10);
        queue.enqueue(source);
        while (!queue.isEmpty()){
            Vertex vertex = queue.dequeue();
            LinkedList<Vertex> currentVertexAdjacencyList = adjacencyArray[vertex.getNumber()];
            for(int i = 0; i < currentVertexAdjacencyList.size(); i++){
                Vertex neighbor = currentVertexAdjacencyList.get(i);
                if(neighbor.getColor() == Color.WHITE){
                    neighbor.setColor(Color.GRAY);
                    neighbor.setDistance(vertex.getDistance() + 1);
                    neighbor.setPredecessor(vertex);
                    queue.enqueue(neighbor);
                }
            }
            vertex.setColor(Color.BLACK);
        }
    }

    public void printVertices(){
        for(int i=0; i<adjacencyArray.length; i++){
            for(int j =0; j<adjacencyArray[i].size(); j++){
                System.out.println(adjacencyArray[i].get(j));
            }
        }
    }

}
