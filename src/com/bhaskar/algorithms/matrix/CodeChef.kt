package com.bhaskar.algorithms.matrix

fun main(args: Array<String>) {
    var originalArray: Array<Array<Long>>
    val testCase = readLine()!!.toInt()
    val result = Array<Long>(testCase) { 0 }
    for (t in 0 until testCase) {
        val metaInputs = readLine()!!.trim().split(" ")
        val rows = metaInputs[0].toInt()
        val cols = metaInputs[1].toInt()
        val k = metaInputs[2].toLong()
        originalArray = Array(rows) { Array(cols) { 0.toLong() } }
        for (i in 0 until rows) {
            val row = readLine()!!.trim().split(" ")
            for (j in 0 until cols)
                originalArray[i][j] = row[j].toLong()
        }
        calculatePrefixSum(rows, cols, originalArray)
        result[t] = traverseMatrix(rows, cols, k, originalArray)
    }
    for (r in result)
        println(r)
}

fun calculatePrefixSum(rows: Int, cols: Int, originalArray: Array<Array<Long>>) {
    for (row in 0 until rows)
        for (col in 0 until cols) {
            if (row == 0 && col == 0)
                continue
            else if (col - 1 < 0)
                originalArray[row][col] = originalArray[row - 1][col] + originalArray[row][col]
            else if (row - 1 < 0)
                originalArray[row][col] = originalArray[row][col - 1] + originalArray[row][col]
            else
                originalArray[row][col] =
                    originalArray[row][col - 1] + originalArray[row - 1][col] + originalArray[row][col] - originalArray[row - 1][col - 1]
        }
}

fun traverseMatrix(rows: Int, cols: Int, k: Long, originalArray: Array<Array<Long>>): Long {
    var count: Long = 0
    for (rowStart in 0 until rows)
        for (colStart in 0 until cols) {
            var i = rowStart
            var j = colStart
            while (i < rows && j < cols) {
                val totalItems = (i - rowStart + 1) * (j - colStart + 1)
                val avg: Float
                if ((rowStart - 1) < 0 && (colStart - 1) < 0)
                    avg = originalArray[i][j] / totalItems.toFloat()
                else if ((colStart - 1) < 0)
                    avg = (originalArray[i][j] - originalArray[rowStart - 1][j]) / totalItems.toFloat()
                else if ((rowStart - 1) < 0)
                    avg = (originalArray[i][j] - originalArray[i][colStart - 1]) / totalItems.toFloat()
                else
                    avg =
                        (originalArray[i][j] - originalArray[i][colStart - 1] - originalArray[rowStart - 1][j] + originalArray[i - 1][j - 1]) / totalItems.toFloat()
                if (avg >= k) {
                    val a = rows - i - 1
                    val b = cols - j - 1
                    if (a > b)
                        count += b + 1
                    else
                        count += a + 1
                    break
                }
                i++
                j++
            }
        }
    return count
}