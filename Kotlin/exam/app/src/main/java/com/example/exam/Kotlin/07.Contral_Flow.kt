package com.example.exam.Kotlin

fun main(args:Array<String>) {
    val a: Int = 5
    val b: Int = 10
    if ( a > b) {
        println("a가 크다")
    }
    else if( a == b) {
        println("a와 같다")
    }
    if ( a < b ) {
        println("a가 작다")
    }
    val max = if ( a > b ) a else b
    println(max)
}
