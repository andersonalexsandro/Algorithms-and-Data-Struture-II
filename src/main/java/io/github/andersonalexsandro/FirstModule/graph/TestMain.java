package io.github.andersonalexsandro.FirstModule.graph;

import java.util.*;

public class TestMain {

    private static int NumberOfVertices = 10;
    private static LinkedList<Vertex>[] adjacencyList = new LinkedList[NumberOfVertices];
    private static Graph graph = new Graph(adjacencyList);
    private static HashMap<Integer, Vertex> allVertices = new HashMap<>();

    public static void main(String[] args) {

        fillHasMap();
        instantiateLinkedLists();

        addToAdjacencyList(0, Arrays.asList(1, 4, 5));
        addToAdjacencyList(1, Arrays.asList(0, 2, 6));
        addToAdjacencyList(2, Arrays.asList(1, 3, 7));
        addToAdjacencyList(3, Arrays.asList(2, 4, 8));
        addToAdjacencyList(4, Arrays.asList(0, 3, 9));
        addToAdjacencyList(5, Arrays.asList(0, 7, 8));
        addToAdjacencyList(6, Arrays.asList(1, 8, 9));
        addToAdjacencyList(7, Arrays.asList(2, 5, 9));
        addToAdjacencyList(8, Arrays.asList(3, 5, 6));
        addToAdjacencyList(9, Arrays.asList(4, 6, 7));
        graph.breadthFirstSearch(new Vertex(0));
        graph.printVertices();
    }

    private static void addToAdjacencyList(int index, List<Integer> neighbors){
        for(int i=0; i< neighbors.size(); i++){
            int neighborNumber = neighbors.get(i);
            Vertex vertex = allVertices.get(neighborNumber);
            adjacencyList[index].add(vertex);
        }
    }

    private static void instantiateLinkedLists(){
        for(int i = 0; i< NumberOfVertices; i++) adjacencyList[i] = new LinkedList<>();
    }

    private static void fillHasMap(){
        for(int i = 0; i< NumberOfVertices; i++) allVertices.put(i, new Vertex(i));
    }

}
