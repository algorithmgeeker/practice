package com.bhaskar.algorithms.graph;

import java.util.*;

public class BFSUpdated {
    private static final Set<Integer> visited = new HashSet<>(6);
    private static final LinkedList<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Graph graph = new Graph(6, false);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        traverse(graph, 1);

    }

 /*   private static ArrayList<Edge> addEdges(int... edges) {
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
    }*/

    private static void traverse(Graph graph, int startNode) {
        //visited.add(startNode);
        queue.add(startNode);
        System.out.println("Start Node -> " + startNode );
        while(!queue.isEmpty()) {
            int startVertex = queue.pop();
            if(!visited.contains(startVertex)) {
                System.out.println("Top Node ->" + startVertex);
                List<Integer> edges = graph.getAdjacencyList(startVertex);
                for (int endVertex : edges) {
                    System.out.println("About to check Edge -> (" + startVertex + " - " + endVertex + ")");
                    //queue.add(endVertex);
                    System.out.println("Inserted Vertex -> "+ endVertex + " " + queue.add(endVertex));
                }
                visited.add(startVertex);
            }
        }
    }

    static public class Graph {
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

        List<Integer> getAdjacencyList(int vertex) {
            return adj.get(vertex -1);
        }
    }
}
