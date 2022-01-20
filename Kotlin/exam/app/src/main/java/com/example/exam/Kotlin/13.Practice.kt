package com.example.exam.Kotlin

fun main(args:Array<String>) {

//    val array = arrayOf<Int>(1,2,3)
//   // val number = array.get(100)
//    println(number)
//    //array.set(0,100)
//
//  //  val number2 = array.get(100)
//    //println(number2)

    //array의 bound는 처음 만들 때 결정 된다.

    //array를 만드는 방법(3)
    val a1 = intArrayOf(1,2,3)
    val a2 = charArrayOf('a', 'b')
    val a3 = doubleArrayOf(1.2,100.345)
    val a4 = booleanArrayOf(true, false)

    // array를 만드는 방법(4)
    val a5 = Array(10,{0}) //lambda를 활용한 방법
    val a6 = Array(5, {1;2;3;4;5})
    println(a5)
}