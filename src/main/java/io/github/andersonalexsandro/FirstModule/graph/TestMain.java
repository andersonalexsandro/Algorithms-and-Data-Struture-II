package io.github.andersonalexsandro.FirstModule.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestMain {

    private static int numberOfVertex = 10;
    private static LinkedList<Vertex>[] adjacencyArray = new LinkedList[numberOfVertex];
    private static Graph graph = new Graph(adjacencyArray);

    public static void main(String[] args) {

        for(int i= 0; i< numberOfVertex; i++) adjacencyArray[i] = new LinkedList<>();

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
            adjacencyArray[index].add(new Vertex(neighborNumber));
        }
    }
}
