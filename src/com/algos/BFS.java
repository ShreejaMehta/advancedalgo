package com.algos;
import java.util.*;
public class BFS {

    // Helper function to perform BFS traversal
    private static void bfsUtil(int start, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            // Visit all the adjacent vertices
            for (int adj : adjList.get(v)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }
    }

    // Main BFS function
    public static void bfs(int start, Map<Integer, List<Integer>> adjList) {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[adjList.size()];

        // Perform BFS traversal
        bfsUtil(start, adjList, visited);
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        // Create the adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Enter the number of adjacent vertices for vertex " + i + ": ");
            int numAdjacentVertices = scanner.nextInt();

            List<Integer> adjacentVertices = new ArrayList<>();
            System.out.print("Enter the adjacent vertices for vertex " + i + ": ");
            for (int j = 0; j < numAdjacentVertices; j++) {
                adjacentVertices.add(scanner.nextInt());
            }

            adjList.put(i, adjacentVertices);
        }

        // Get the starting vertex
        System.out.print("Enter the starting vertex: ");
        int startVertex = scanner.nextInt();

        // Perform BFS traversal starting from the given vertex
        System.out.println("BFS traversal starting from vertex " + startVertex + ":");
        bfs(startVertex, adjList);
    }
}
