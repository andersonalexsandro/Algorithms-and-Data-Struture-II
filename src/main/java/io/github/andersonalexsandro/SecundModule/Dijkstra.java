package io.github.andersonalexsandro.SecundModule;

import java.util.*;

public class Dijkstra {

    public static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class Graph {
        int vertices;
        List<List<Edge>> adjacencyList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjacencyList.add(new LinkedList<>());
            }
        }

        public void addEdge(int src, int dest, int weight) {
            adjacencyList.get(src).add(new Edge(src, dest, weight));
        }

        public int[] dijkstra(int startVertex) {
            boolean[] visited = new boolean[vertices];
            int[] distances = new int[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startVertex] = 0;
            PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(e -> e.weight));

            pq.add(new Edge(startVertex, startVertex, 0));

            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                int vertex = edge.dest;
                if (visited[vertex]) {
                    continue;
                }
                visited[vertex] = true;

                List<Edge> edgesList = adjacencyList.get(vertex);
                for (Edge e : edgesList) {
                    int destination = e.dest;
                    int currentWeight = e.weight;

                    if (!visited[destination] && distances[vertex] + currentWeight < distances[destination]) {
                        distances[destination] = distances[vertex] + currentWeight;
                        pq.add(new Edge(vertex, destination, distances[destination]));
                    }
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.addEdge(2, 5, 7);

        int[] distances = graph.dijkstra(0);

        System.out.println("The shortest paths from node 0 are:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("To node " + i + " the shortest path is " + distances[i]);
        }
    }
}