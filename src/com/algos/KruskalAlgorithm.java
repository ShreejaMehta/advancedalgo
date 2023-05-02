package com.algos;

import java.util.*;

public class KruskalAlgorithm {

    // Define the class for an edge in the graph
    private static class Edge implements Comparable<Edge> {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        // Sort edges based on their weights
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    // Define the method to find the minimum spanning tree of the graph using Kruskal's algorithm
    public static List<Edge> kruskalAlgorithm(int n, List<Edge> edges) {
        // Initialize a list to store the edges in the minimum spanning tree
        List<Edge> mst = new ArrayList<>();

        // Create a parent array to keep track of the parent of each node in the graph
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Sort the edges in ascending order based on their weights
        Collections.sort(edges);

        // Traverse the edges in ascending order and add them to the minimum spanning tree if they do not create a cycle
        for (Edge edge : edges) {
            int sourceParent = findParent(edge.source, parent);
            int destinationParent = findParent(edge.destination, parent);
            if (sourceParent != destinationParent) {
                mst.add(edge);
                parent[sourceParent] = destinationParent;
            }
        }

        // Return the list of edges in the minimum spanning tree
        return mst;
    }

    // Define the method to find the parent of a node in the graph
    private static int findParent(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node], parent);
        }
        return parent[node];
    }

    // Example usage
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        int n = scanner.nextInt();

        // Take user input for the number of edges and the edges themselves
        List<Edge> edges = new ArrayList<>();
        System.out.print("Enter the number of edges in the graph: ");
        int m = scanner.nextInt();
        System.out.println("Enter the edges in the format 'source destination weight':");
        for (int i = 0; i < m; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(source, destination, weight));
        }

        // Call the kruskalAlgorithm method with the user input
        List<Edge> mst = kruskalAlgorithm(n, edges);
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + ": " + edge.weight);
        }

        // Close the scanner
        scanner.close();
    }
}
