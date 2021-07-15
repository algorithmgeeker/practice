package com.bhaskar.algorithms

//class Bhaskar constructor(v : Int) {
//    val value : Int
//    init {
//        value = v
//    }
//}

class Bhaskar(val value: Int = 10)

open class Su(val r : Int)

class Rohan(val e : Int) : Su(e)

class Ram : Su {
    val a : Int
    constructor(a : Int) : this(a, 4)

    constructor(b : Int, c : Int) : super(b) {
        a = b
    }
}

fun Bhaskar.print() = print(value)

//class Bhaskar(bhaskar : Int) {
//    val name = bhaskar
//}
fun main(args: Array<String>) {
    val c = DataTest(3, 6)
    val d = c.copy(b = 9)
    print("c -> $c AND d -> $d")
}

data class DataTest(val a : Int, val b: Int)

class NewTest<T> (iL : Collection<T> = arrayListOf()) : Collection<T> by iL {
    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }
}