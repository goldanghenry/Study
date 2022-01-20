package com.example.exam.Kotlin

fun plus(first:Int,second:Int): Int {
    val result:Int = first + second
    return result
}
fun plusFive(first:Int, second:Int=5) : Int {
    val result : Int = first + second
    return result
}
fun plusPrint(first:Int, second:Int=5): Unit {
    println(first+second)
}

fun plusShort(first:Int, second:Int) = first + second
fun plusMany(vararg numbers:Int) {
    for(number in numbers) {
        println(number)
    }
}
fun main(array:Array<String>) {
    val result = plus(5,10)
    println(result)

    val result1 = plusFive(10)
    println(result1)
    plusMany(1,2,3)
    plusPrint(3)
}

