package com.algos;

import java.util.*;
import java.util.Scanner;

public class Prims {

    private int V; // number of vertices
    private List<List<Edge>> adjList; // adjacency list to store graph
    private boolean[] visited; // boolean array to mark visited vertices
    private PriorityQueue<Edge> pq; // priority queue to keep track of minimum weighted edges
    private List<Edge> mstEdges; // list to store edges in the minimum spanning tree
    private int mstWeight; // total weight of the minimum spanning tree

    public Prims(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[V];
        pq = new PriorityQueue<>(new EdgeComparator());
        mstEdges = new ArrayList<>();
        mstWeight = 0;
    }

    // add edge to graph
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Edge(u, v, weight));
        adjList.get(v).add(new Edge(v, u, weight));
    }

    // compute minimum spanning tree
    public void computeMST(int startVertex) {
        visit(startVertex);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int u = e.u;
            int v = e.v;
            if (visited[u] && visited[v]) {
                continue;
            }
            mstEdges.add(e);
            mstWeight += e.weight;
            if (!visited[u]) {
                visit(u);
            }
            if (!visited[v]) {
                visit(v);
            }
        }
    }

    // helper method to mark vertex as visited and add its edges to priority queue
    private void visit(int vertex) {
        visited[vertex] = true;
        List<Edge> edges = adjList.get(vertex);
        for (Edge e : edges) {
            if (!visited[e.v]) {
                pq.offer(e);
            }
        }
    }

    // get minimum spanning tree edges
    public List<Edge> getMSTEdges() {
        return mstEdges;
    }

    // get total weight of minimum spanning tree
    public int getMSTWeight() {
        return mstWeight;
    }

    // inner class to represent edge in graph
    private class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    // inner class to compare edges by weight
    private class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge e1, Edge e2) {
            return e1.weight - e2.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        Prims graph = new Prims(V);

        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter the edges (u, v, weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(u, v, weight);
        }

        System.out.print("Enter the starting vertex: ");
        int startVertex = sc.nextInt();

        graph.computeMST(startVertex);
        List<Prims.Edge> mstEdges = graph.getMSTEdges();
        int mstWeight = graph.getMSTWeight();
        System.out.println("Minimum Spanning Tree Edges:");
        for (Prims.Edge e : mstEdges) {
            System.out.println("(" + e.u + ", " + e.v + ") - " + e.weight);
        }
        System.out.println("Minimum Spanning Tree Weight: " + mstWeight);
    }

}
