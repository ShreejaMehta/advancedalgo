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
        int n = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));

        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));
        List<Edge> mst = kruskalAlgorithm(n, edges);
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + ": " + edge.weight);
        }
    }
}
