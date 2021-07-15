package com.bhaskar.algorithms.practice

import com.bhaskar.algorithms.graph.JAVA_CODE
import com.bhaskar.algorithms.graph.KOTLIN_CODE
import com.bhaskar.algorithms.graph.testing as name

// Reverse a String
fun strReverse(string: String): String {
    val len = string.length
    val revString = CharArray(len) { index -> string[len - (index + 1)] }
    return String(revString)
}

fun main() {
    var input = listOf<Int>(1,3);
    //val result = strReverse("Bhaskar")
    "Bhaskar".name()
    print(getNextPosition(input))
}

fun getNextPosition(imagePosition: List<Int>): Int {
    if (imagePosition.isNotEmpty()) {
        var sortedPosition = imagePosition.sorted()
        var couter: Int = 1
        for (i in sortedPosition) {
            if (couter != i)
                return couter;
            couter += 1;
        }
    } else
        return 1
    return 1
}