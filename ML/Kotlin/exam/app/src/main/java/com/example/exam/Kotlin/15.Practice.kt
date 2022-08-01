package com.example.exam.Kotlin
fun main(args:Array<String>) {

    val a = mutableListOf<Int>(1,2,3)
    a.add(4)
    println(a)
    a.add(0,100)
    println(a)
    a.set(0,200)
    println(a)
    a.removeAt(1)

    val b = mutableSetOf<Int>(1,2,3,4)
    println()
    b.add(2)
    println(b)
    b.remove(2)
    b.remove(100)

    val c = mutableMapOf<String, Int>("One" to 1)
    println()
    c.put("two",2)
    println(c)
    c.replace("two", 3)
    println(c)
    println(c.keys)
    println(c.values)
    c.clear()
    println(c)

}