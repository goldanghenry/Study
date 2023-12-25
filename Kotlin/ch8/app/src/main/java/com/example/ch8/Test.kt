package com.example.ch8

fun samTest1() {
    val obj = SAMTest()
    obj.setInterface(object:JavaInterface1{
        override fun callback() {
            println("hello kotlin")
        }
    })
    obj.callback.callback()
}

fun samTest2() {
    val obj = SAMTest()
    obj.setInterface{ println("hello SAM") }
    obj.callback.callback()
}

fun main() {
    samTest1()
    samTest2()
}