package io.github.andersonalexsandro.FirstModule.graph;

import io.github.andersonalexsandro.FirstModule.queue.Queue;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    private int numberOfVertex;

    private LinkedList<Vertex>[] adjacencyArray;
    private HashMap<Integer, Vertex> allVerticies = new HashMap<>();

    public Graph(LinkedList<Vertex>[] adjacencyList) {
        this.adjacencyArray = adjacencyList;
        numberOfVertex = adjacencyList.length;
    }

    public void fillHasMap(){
        for(int i=0; i<adjacencyArray.length; i++){
            for(int j=0; j< adjacencyArray[i].size(); j++){
                Vertex vertex = adjacencyArray[i].get(j);
                if(!allVerticies.containsKey(adjacencyArray[i].get(j).getNumber())) allVerticies.put(adjacencyArray[i].get(j).getNumber(), adjacencyArray[i].get(j));
            }
        }
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

    public void DepthFirstSearch(){
        for(int i=0; i< allVerticies.size(); i++){
            Vertex vertex = allVerticies.get(i);
            vertex.setColor(Color.WHITE);
            vertex.setPredecessor(null);
            vertex.setDistance(0);
            vertex.setSecondVisitDistance(0);
        }
        int time = 0;
        for(int i=0; i<allVerticies.size(); i++){
            Vertex vertex = allVerticies.get(i);
            if(vertex.getColor().equals(Color.WHITE)){
                visitSearch(vertex, time);
            }
        }
    }

    private void visitSearch(Vertex vertex, int time) {
        time++;
        vertex.setDistance(time);
        vertex.setColor(Color.GRAY);
        for(int i =0; i< adjacencyArray[vertex.getNumber()].size(); i++){
            Vertex neighbor = adjacencyArray[vertex.getNumber()].get(i);
            if(neighbor.getColor().equals(Color.WHITE)){
                neighbor.setPredecessor(vertex);
                visitSearch(neighbor, time);
            }
        }
        vertex.setColor(Color.BLACK);
        time++;
        vertex.setSecondVisitDistance(time);
    }

    public void printTravel(Vertex source, Vertex destin){
        if(source.equals(destin)){
            System.out.println(source);
        } else{
            if(destin.getPredecessor() == null){
                System.out.println("There is no way to source vertex");
            }else{
                printTravel(source, destin.getPredecessor());
                System.out.println(destin);
            }
        }
    }



    public void printVertices(){
        for(int i=0; i<adjacencyArray.length; i++){
            System.out.println(i + " is Neighbor of: ");
            for(int j =0; j<adjacencyArray[i].size(); j++){
                System.out.println(adjacencyArray[i].get(j) + " distance of the source: "+ adjacencyArray[i].get(j).getDistance() + " predecessor " + adjacencyArray[i].get(j).getPredecessor());
            }
        }
    }

}
