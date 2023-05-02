package com.algos;

import java.util.*;

public class Dijkstra {

    public static void dijkstra(Map<Integer, Map<Integer, Integer>> graph, int start) {
        // Map to store the shortest distances from the start vertex to each vertex
        Map<Integer, Integer> distances = new HashMap<>();

        // Priority queue to keep track of the vertices with their distances
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));

        // Set to keep track of visited vertices
        Set<Integer> visited = new HashSet<>();

        // Add the start vertex to the priority queue with a distance of 0
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            // Remove the vertex with the minimum distance from the priority queue
            Node node = pq.remove();

            // Skip if the vertex is already visited
            if (visited.contains(node.vertex)) {
                continue;
            }

            // Mark the vertex as visited and store its distance
            visited.add(node.vertex);
            distances.put(node.vertex, node.distance);

            // Explore the neighbors of the current vertex
            for (Map.Entry<Integer, Integer> neighbor : graph.get(node.vertex).entrySet()) {
                if (!visited.contains(neighbor.getKey())) {
                    // Calculate the new distance to the neighbor vertex and add it to the priority queue
                    pq.add(new Node(neighbor.getKey(), node.distance + neighbor.getValue()));
                }
            }
        }

        // Print the shortest distances from the start vertex to each vertex
        System.out.println(distances);
    }

    // Inner class to represent a vertex with its distance
    private static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        // Create an empty graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Read the number of vertices in the graph
        System.out.print("Enter the number of vertices in the graph: ");
        int numVertices = scanner.nextInt();

        // Build the graph by adding vertices and their neighbors
        for (int i = 1; i <= numVertices; i++) {
            graph.put(i, new HashMap<>());

            // Read the number of neighbors for the current vertex
            System.out.print("Enter the number of neighbors for vertex " + i + ": ");
            int numNeighbors = scanner.nextInt();

            // Add each neighbor and its weight to the adjacency list of the current vertex
            for (int j = 0; j < numNeighbors; j++) {
                System.out.print("Enter the neighbor vertex: ");
                int neighbor = scanner.nextInt();

                System.out.print("Enter the weight of the edge: ");
                int weight = scanner.nextInt();

                graph.get(i).put(neighbor, weight);
            }
        }

        // Read the starting vertex for Dijkstra's algorithm
        System.out.print("Enter the starting vertex: ");
        int start = scanner.nextInt();

        // Perform Dijkstra's algorithm
        dijkstra(graph, start);
    }
}
