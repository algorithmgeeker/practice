package com.bhaskar.algorithms.graph

val JAVA_CODE = 4
const val KOTLIN_CODE = 4

class Graph(private val vertexNum: Int, val isDirected : Boolean = false) {
    private val _adj: Array<MutableList<Int>> = Array(vertexNum) { mutableListOf<Int>() }
    private val _revAdj: Array<MutableList<Int>> = Array(vertexNum) { mutableListOf<Int>() }
    //val outDegree = Array<Int>(vertexNum){0}
    //val outDegree = Array<Int>(vertexNum){0}
    val inDegree = Array<Int>(vertexNum){0}
    val size
    get() = vertexNum

    fun addEdge(startVertex: Int, endVertex: Int) {
        _adj[startVertex - 1].add(endVertex)
        _revAdj[endVertex - 1].add(startVertex)
        inDegree[endVertex-1] += 1
        if(!isDirected) {
            _adj[endVertex - 1].add(startVertex)
            inDegree[startVertex-1] += 1
        }
    }

    fun getAdjacencyList(vertex : Int) = _adj[vertex-1]

    fun getRevAdjacencyList(vertex : Int) = _revAdj[vertex-1]

    fun getDegree(vertex : Int) = inDegree[vertex-1]
}

fun main() {
    val a : Int
    val b = 56
    a = 24
    print("a -> $a")
}

fun test(a: Int = 1) {

}

fun String.testing() {
    print(this)
}