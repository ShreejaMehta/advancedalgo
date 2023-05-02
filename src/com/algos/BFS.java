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
        // Create the adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1, 2));
        adjList.put(1, Arrays.asList(2));
        adjList.put(2, Arrays.asList(0, 3));
        adjList.put(3, Arrays.asList(3));

        // Perform BFS traversal starting from vertex 2
        System.out.println("BFS traversal starting from vertex 2:");
        bfs(2, adjList);
    }
}
