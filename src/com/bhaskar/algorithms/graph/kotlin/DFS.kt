package com.bhaskar.algorithms.graph.kotlin

import com.bhaskar.algorithms.graph.Graph
import java.util.*
import kotlin.collections.ArrayDeque

private val visited = mutableSetOf<Int>()
private val graph = Graph(vertexNum = 9, isDirected = true)
private val queue  = LinkedList<Int>()
private lateinit var topologicalSorted : Array<Int>
private var counter : Int = 0
//private val finishingOrder = mutableListOf<Int>()
private val finishingOrder = java.util.ArrayDeque<Int>()
private val connectedComponents = mutableMapOf<Int, MutableSet<Int>>()

fun main() {
//    graph.addEdge(1, 2)
//    graph.addEdge(1, 3)
//    graph.addEdge(2, 4)
//    graph.addEdge(3, 4)
//    graph.addEdge(3, 5)
//    graph.addEdge(4, 5)
//    graph.addEdge(4, 6)
//    graph.addEdge(5, 6)
    //traverseDfs(1)
    //var i = 1;
//    for(degree in graph.inDegree) {
//        println("Degree ${i++}-> $degree")

//  }
    /*graph.addEdge(6, 3);
    graph.addEdge(6, 1);
    graph.addEdge(5, 1);
    graph.addEdge(5, 2);
    graph.addEdge(3, 4);
    graph.addEdge(4, 2);*/
    /*topologicalSorted = Array<Int>(graph.size){0}
    counter = graph.size -1*/
    /*for(vertex in 1..6)
        topologicalSort(vertex)
    println("Order -> ${topologicalSorted.contentToString()}  Expected Result -> [5 6 3 1 4 2]")*/
    graph.addEdge(9, 7)
    graph.addEdge(8, 9)
    graph.addEdge(7, 8)
    graph.addEdge(6, 9)
    graph.addEdge(6, 1)
    graph.addEdge(5, 6)
    graph.addEdge(4, 5)
    graph.addEdge(4, 2)
    graph.addEdge(3, 4)
    graph.addEdge(2, 3)
    graph.addEdge(1, 5)
    stronglyConnectedComponents()
}

fun traverseDfs(startNode : Int) {
    println("Start Node -> $startNode")
    visited.add(startNode)
    val edgeEndPoints = graph.getAdjacencyList(startNode)
    for(edgeEndPoint in edgeEndPoints) {
        println("Looking at edge ($startNode - $edgeEndPoint)")
        if (!visited.contains(edgeEndPoint))
            traverseDfs(edgeEndPoint)
    }
}

// Without using DFS (Using InOrder)
fun topologicalSort() : MutableList<Int> {
    val result = mutableListOf<Int>()
    for(i in 1..6)
        if(graph.getDegree(i) == 0)
            queue.add(i)
    while(queue.isNotEmpty()) {
        val vertex = queue.pop()
        result.add(vertex)
        val endPoints = graph.getAdjacencyList(vertex)
        for(endVertex in endPoints) {
            graph.decrementDegree(endVertex)
            if(graph.getDegree(endVertex)== 0)
                queue.add(endVertex)
        }
    }
    return result
}

fun Graph.decrementDegree(vertex : Int) {
    inDegree[vertex-1] -= 1
}

// Using DFS
fun topologicalSort(startNode: Int) {
    if(visited.contains(startNode))
        return
    visited.add(startNode)
    val endPoints = graph.getAdjacencyList(startNode)
    for(endVertex in endPoints)
        if(!visited.contains(endVertex))
            topologicalSort(endVertex)
    print("counter -> $counter")
    if(counter != -1 && topologicalSorted[counter] == 0) {
        topologicalSorted[counter] = startNode
        counter -= 1
    }
}

/**
 * Step 1 - Reverse the graph
 * Step 2 - Calculate finishing time
 * Step 3 - Run DFS
 *
 * Tip - Can do step 1 & 2 by just running DFS in reverse direction i.e. instead of going start to end vertex go end to
 * start vertex
 */
fun calculateFinishingTimes(startNode : Int) {
    visited.add(startNode)
    val endNodes = graph.getRevAdjacencyList(startNode)
    for(endNode in endNodes) {
        if(!visited.contains(endNode))
            calculateFinishingTimes(endNode)
    }
    finishingOrder.push(startNode)
}

fun calculateStronglyConnected(startNode : Int) {
    visited.add(startNode)
    val endNodes = graph.getAdjacencyList(startNode)
    for(endNode in endNodes) {
        if(!visited.contains(endNode))
            calculateStronglyConnected(endNode)
    }
    print("$startNode -> ")
}

fun stronglyConnectedComponents() {
    for(vertex in 1..graph.size ) {
        if (!visited.contains(vertex))
            calculateFinishingTimes(vertex)
    }
    print("$finishingOrder \n")
    visited.clear()

    while (finishingOrder.isNotEmpty()) {
        val vertex = finishingOrder.pop()
        println("Poped ->  $vertex")
        if (!visited.contains(vertex)) {
            calculateStronglyConnected(vertex)
            print("\n")
        } else
            print("Skiping -> $vertex")
    }
}