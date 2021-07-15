package com.bhaskar.algorithms.graph;

import java.util.*;

import static com.bhaskar.algorithms.graph.UndirectedConnectedComponents.*;

public class DfsRecursion {
    /*static Node[] nodes = new Node[]{
            new Node(1),
            new Node(2),
            new Node(3),
            new Node(4),
            new Node(5),
            new Node(6),
    };*/
    //static Set<Integer> connectedSet= new HashSet<>();
    static List<Integer> connectedSet= new ArrayList<>();
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
        /*Map<Node, ArrayList<Edge>> graph = new TreeMap<>();
        graph.put(nodes[3], addEdges(2,3,5,6));
        graph.put(nodes[4], addEdges(3,4,6));
        graph.put(nodes[5], addEdges(4,5));
        graph.put(nodes[0], addEdges(2,3));
        graph.put(nodes[1], addEdges(1,4));
        graph.put(nodes[2], addEdges(1,4,5));
        traverseRecursive(graph, nodes[0]);*/
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

        for(Node node : nodes)
            if(!node.isExplored) {
                connectedSet.clear();
                traverseRecursive(graph, node);
                System.out.println(Arrays.toString(connectedSet.toArray()));
            }
    }

    private static ArrayList<Edge> addEdges(int... edges) {
        ArrayList<Edge> edgeList = new ArrayList<>(edges.length);
        for(int edge : edges)
            edgeList.add(new Edge(nodes[edge-1]));
        return edgeList;
    }

    static void traverseRecursive(Map<Node, ArrayList<Edge>> graph, Node startNode) {
        if(startNode.isExplored)
            return;
        connectedSet.add(startNode.vertex);
        System.out.println("Starting from Node :- " + startNode.vertex);
        startNode.isExplored = true;
        for (Edge edge : graph.get(startNode)) {
            System.out.println("Checking Edge :- (" + startNode.vertex + "," + edge.endNode.vertex + ")");
            if (!edge.isExplored)
                traverseRecursive(graph, edge.endNode);
        }
    }
}
