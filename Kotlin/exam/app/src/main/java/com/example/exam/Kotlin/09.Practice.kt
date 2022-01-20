package com.example.exam.Kotlin

fun main(args:Array<String>) {

    val a: Int? = null
    val b: Int = 10
    val c: Int = 100

    if(a==null) {
        println("a is null")
    }
    else {
        println("a is not null")
    }

    if( b + c == 110 ) {
        println("b plus c is 110")
    }

    val number: Int? = null
    val number2 = number ?: 10
    println(number2)

    val num1: Int = 10
    val num2: Int = 20

    val max = if (num1 > num2) num1
    else if ( num1 == num2) num2
    else 100
}