package com.bhaskar.algorithms.matrix

fun main() {
    transposeMatrix()
}

fun transposeMatrix() {
    val matrix: Array<Array<Int>>
    print("Enter Number of Rows : ")
    val row = readLine()!!.toInt()
    print("Enter Number of Columns : ")
    val col = readLine()!!.toInt()
    matrix = Array(row) { _ -> Array(col) { 0 } }
    //val resultMatrix = Array(row){ _ -> Array(col){0} }
    for (i in 0 until row) {
        print("${i + 1}th Row -> ")
        val rowInput = readLine()!!.split(" ")
        for (j in 0 until col) {
            matrix[i][j] = rowInput[j].toInt()
        }
    }
    for (i in 0 until row) {
        println()
        for (j in 0 until col)
            print("${matrix[i][j]} ")
    }
    for (i in 0 until row)
        for (j in (0+i) until col) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = tmp
        }
    println()
    println("Result : ")
    for (i in 0 until row) {
        println()
        for (j in 0 until col)
            print("  ${matrix[i][j]}  ")
    }
}

