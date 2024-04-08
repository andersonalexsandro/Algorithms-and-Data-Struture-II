package io.github.andersonalexsandro;

public class FloydWarshall {

    final static int INF = 99999; // Use algum valor grande para representar 'infinito'

    public void floydWarshall(int[][] graph) {
        int vertices = graph.length;
        int[][] distances = new int[vertices][vertices];

        // Inicializa a matriz de distâncias
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                distances[i][j] = graph[i][j];
            }
        }

        // Atualiza as distâncias considerando todos os vértices um por um
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }

        // Imprime a matriz de distâncias
        printSolution(distances);
    }

    public void printSolution(int[][] distances) {
        System.out.println("The following matrix shows the shortest " +
                "distances between every pair of vertices");
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances.length; j++) {
                if (distances[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distances[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };

        FloydWarshall a = new FloydWarshall();
        a.floydWarshall(graph);
    }
}
