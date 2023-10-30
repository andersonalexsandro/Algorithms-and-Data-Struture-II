package io.github.andersonalexsandro.FirstModule.graph;

import java.util.Arrays;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        int sourceNumber = 0;
        graph.addNeighbors(0, Arrays.asList(1, 4, 5));
        graph.addNeighbors(1, Arrays.asList(0, 2, 6));
        graph.addNeighbors(2, Arrays.asList(1, 3, 7));
        graph.addNeighbors(3, Arrays.asList(2, 4, 8));
        graph.addNeighbors(4, Arrays.asList(0, 3, 9));
        graph.addNeighbors(5, Arrays.asList(0, 7, 8));
        graph.addNeighbors(6, Arrays.asList(1, 8, 9));
        graph.addNeighbors(7, Arrays.asList(2, 5, 9));
        graph.addNeighbors(8, Arrays.asList(3, 5, 6));
        graph.addNeighbors(9, Arrays.asList(4, 6, 7));

        List<Vertex> result = graph.breadthFirstSearch(sourceNumber);
        System.out.println("Result from Breadth-First Search");
        result.forEach(System.out::println);
        System.out.println();
        for(int i=1; i<result.size(); i++){
            System.out.println( sourceNumber +" to " + i);
            List<Vertex> inOrderTraversalResult = graph.sourceToDestinInOrder(sourceNumber, i, result);
            inOrderTraversalResult.forEach(System.out::println);
        }

        List<Vertex> resultDepth = graph.depthFirstSearch();
        System.out.println();
        System.out.println("Result from Depth-First Search");
        result.forEach(System.out::println);
        System.out.println();
        for(int i=0; i<result.size(); i++){
            System.out.println( sourceNumber +" to " + i);
            List<Vertex> inOrderTraversalResult = graph.sourceToDestinInOrder(sourceNumber, i, result);
            inOrderTraversalResult.forEach(System.out::println);
        }
    }
}
