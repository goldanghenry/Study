package com.example.exam.Kotlin

fun plusThree(first:Int, second:Int, third:Int):Int {
    return first+second+third
}
fun minusThree(first:Int, second:Int, Third:Int) : Int = first-second-Third
fun multiplyThree(first:Int=1, second:Int=1, third:Int=1) :Int {
    return first * second * third
}
fun showMyPlus(first: Int,second: Int):Int {
    println(first)
    println(second)
    fun plus(first: Int,second: Int): Int {
        return first + second
    }
    return plus(first, second)
}
fun main(array:Array<String>) {
    var result : Int = minusThree(1,2,3)
    println(result)
    var result2 : Int =  multiplyThree()
    println(result2)
}