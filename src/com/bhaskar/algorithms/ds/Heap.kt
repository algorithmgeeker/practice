package com.bhaskar.algorithms.ds

/*
1. Implement Heap from scratch
2. Implement Dijkastra Algo without Heap
3. Implement Dijkastra with Heap
4. Study Balance Search Tree and BST
 */
enum class HeapType {
    MIN, MAX
}

class Heap(val type : HeapType) {
    fun add() {}
    fun extract(){}
    fun remove(item : Int) {}
}

fun String.revStr() {
    val char = CharArray(this.length){' '}
    for(i in length-1 downTo 0)
        char[i] = this[(length-1) - i]
            //print(i)
    print(String(char))
}

fun main() {
    "Bhaskar".revStr()
}