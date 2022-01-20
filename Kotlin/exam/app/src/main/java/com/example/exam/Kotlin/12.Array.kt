package com.example.exam.Kotlin

fun main(args:Array<String>) {

// 배열을 생성하는 방법(1)
var group1 = arrayOf<Int>(1,2,3,4,5)
println(group1 is Array)

// 배열을 생성하는 방법(2)
var group2 = arrayOf(1,2,3.5,"Hello")

//Index란
//[1,2,3,4,5]
// 0부터 시작.

//배열의 값을 꺼내는 방법(1)
val test1 = group1.get(0)

//배열의 값을 꺼내는 방법(2)
val test2 = group1[0]

//배열의 값을 바꾸는 방법(1)
group1.set(0,100)

//배열의 값을 바꾸는 방법(2)
group1[0] = 4

}