package com.bhaskar.algorithms.graph;

import java.util.*;

public class BFS {
    static LinkedList<Node> tracker = new LinkedList<>();
    static Node[] nodes = new Node[]{
            new Node(1),
            new Node(2),
            new Node(3),
            new Node(4),
            new Node(5),
            new Node(6),
    };

    public static void main(String[] args) {

        Map<Node, ArrayList<Edge>> graph = new TreeMap<>();
        graph.put(nodes[3], addEdges(2,3,5,6));
        graph.put(new Node(5), addEdges(3,4,6));
        graph.put(new Node(6), addEdges(4,5));
        graph.put(new Node(1), addEdges(2,3));
        graph.put(new Node(2), addEdges(1,4));
        graph.put(new Node(3), addEdges(1,4,5));

        //graph.forEach((node, integers) -> System.out.println("Node " + node.vertex + "  Edges " + integers));

        traverse(graph, nodes[0]);

    }

    private static ArrayList<Edge> addEdges(int... edges) {
        ArrayList<Edge> edgeList = new ArrayList<>(edges.length);
        for(int edge : edges)
            edgeList.add(new Edge(nodes[edge-1]));
        return edgeList;
    }

    static class Node implements Comparable<Node>{
        final int vertex;
        boolean isExplored;

        Node(int vertex) {
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Node node) {
            return this.vertex - node.vertex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return vertex == node.vertex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex, isExplored);
        }
    }

    static class Edge {
        Node endNode;
        boolean isExplored;
        Edge(Node endPoint) {
            this.endNode = endPoint;
        }
    }

    private static void traverse(Map<Node, ArrayList<Edge>> graph, Node startNode) {
        startNode.isExplored = true;
        tracker.add(startNode);
        System.out.println("Start Node -> " + startNode.vertex + " (" + startNode.hashCode() + ")");
        while(!tracker.isEmpty()) {
            Node top = tracker.pop();
            System.out.println("Top Node ->" + top.vertex + " (" + top.hashCode() + ")");
            for(Edge edge : graph.get(top)) {
                System.out.println("About to check Node ->" + edge.endNode.vertex);
                if(!edge.isExplored && !edge.endNode.isExplored) {
                    edge.endNode.isExplored = true;
                    edge.isExplored = true;
                    tracker.add(edge.endNode);
                    System.out.println("Marked Node ->" + edge.endNode.vertex);
                }
            }
        }
    }
}

/*
public class Graph {
    private final int vertexNum;
    final private boolean isDirected;
    private List<List<Integer>> adj;

    public Graph(int vertexNum, boolean isDirected) {
        this.vertexNum = vertexNum;
        this.isDirected = isDirected;
        adj = new ArrayList<>(this.vertexNum);
        for(int i=0; i<vertexNum; i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int startVertex, int endVertex) {
        adj.get(startVertex - 1).add(endVertex);
        if(!isDirected)
            adj.get(endVertex - 1).add(startVertex);
    }

    List<List<Integer>> getAdjacencyList() {
        return adj;
    }
}*/
