package com.bhaskar.algorithms.graph;

import java.util.*;

public class UndirectedConnectedComponents {
    static LinkedList<Node> tracker = new LinkedList<>();
    static Node[] nodes = new Node[]{
            new Node(1),
            new Node(2),
            new Node(3),
            new Node(4),
            new Node(5),
            new Node(6),
            new Node(7),
            new Node(8),
            new Node(9),
            new Node(10)
    };

    public static void main(String[] args) {

        Map<Node, ArrayList<Edge>> graph = new TreeMap<>();
        graph.put(nodes[3], addEdges(2));
        graph.put(nodes[5], addEdges(8,10));
        graph.put(nodes[4], addEdges(1,3,7,9));
        graph.put(nodes[0], addEdges(3,5));
        graph.put(nodes[1], addEdges(4));
        graph.put(nodes[2], addEdges(1,5));
        graph.put(nodes[6], addEdges(5,9));
        graph.put(nodes[7], addEdges(6,10));
        graph.put(nodes[8], addEdges(5,7));
        graph.put(nodes[9], addEdges(7,5));

        //graph.forEach((node, integers) -> System.out.println("Node " + node.vertex + "  Edges " + integers));

        for (Node node : nodes)
            if(!node.isExplored)
                traverse(graph, node);

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
        int dist = -1;

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

        public void markExplored(int vertex) {

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
        System.out.println("Component Starts-> " + startNode.vertex);
        startNode.isExplored = true;
        tracker.add(startNode);
        //startNode.dist = 0;
       // System.out.println("Start Node -> " + startNode.vertex + " (" + startNode.hashCode() + ")");
        while(!tracker.isEmpty()) {
            Node top = tracker.pop();
            //System.out.println("Top Node ->" + top.vertex +  "  Distance : " + top.dist);
            for(Edge edge : graph.get(top)) {
                //System.out.println("About to check Node ->" + edge.endNode.vertex);
                if(!edge.isExplored && !edge.endNode.isExplored) {
                    edge.endNode.isExplored = true;
                    edge.isExplored = true;
                    tracker.add(edge.endNode);
                    //edge.endNode.dist = top.dist + 1;
                    System.out.println("Component -> " + edge.endNode.vertex);
                    //System.out.println("Marked Node ->" + edge.endNode.vertex + "  Distance : " + edge.endNode.dist);
                }
            }
        }
    }
}
