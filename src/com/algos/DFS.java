package com.algos;

import java.util.*;

public class DFS {

    // Helper function to perform DFS traversal
    private static void dfsUtil(int v, boolean[] visited, Map<Integer, List<Integer>> adjList) {
        visited[v] = true; // Mark the current vertex as visited
        System.out.print(v + " "); // Print the current vertex

        // Recur for all adjacent vertices
        for (int adj : adjList.get(v)) { // Iterate over the adjacent vertices of the current vertex
            if (!visited[adj]) { // If the adjacent vertex is not visited
                dfsUtil(adj, visited, adjList); // Recursively call the DFS function for the adjacent vertex
            }
        }
    }

    // Main DFS function
    public static void dfs(int start, Map<Integer, List<Integer>> adjList) {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[adjList.size()];

        // Perform DFS traversal
        dfsUtil(start, visited, adjList);
    }

    // Driver code
    public static void main(String[] args) {
        // Create the adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1, 2)); // Vertex 0 is connected to vertices 1 and 2
        adjList.put(1, Arrays.asList(2)); // Vertex 1 is connected to vertex 2
        adjList.put(2, Arrays.asList(0, 3)); // Vertex 2 is connected to vertices 0 and 3
        adjList.put(3, Arrays.asList(3)); // Vertex 3 is connected to itself

        // Perform DFS traversal starting from vertex 2
        System.out.println("DFS traversal starting from vertex 2:");
        dfs(2, adjList);
    }
}
