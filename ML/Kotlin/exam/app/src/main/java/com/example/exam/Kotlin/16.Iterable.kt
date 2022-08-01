package com.example.exam.Kotlin

fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    //반복하는 방법 (1)
    for (item in a) {
        if (item == 5) {
            println("item is Five")
        } else {
            println("item is not Five")
        }
    }
    //반복하는 방법 (2) 인덱스를 조건에 넣어 사용하고 싶을 때
    for ((index, item) in a.withIndex()) {
        println("Index:" + index + "value:" + item)
    }

    // 반복하는 방법 (3)
    a.forEach {
        println(it) //it에 1~9의 값이 들어온다. 이름이 it으로 정해진다.
    }
    // 반복하는 방법 (4) it말고 이름 변경하기
    a.forEach { item ->
        println(item)
    }
    // 반복하는 방법 (5)
    // (2)과 유사 값과 인덱스가 같이 들어오는 것. 람다를 사용하면 더 직관적이다.
    a.forEachIndexed { index, item ->
        println("Index:" + index + "value:" + item)
    }
    // 반복하는 방법 (6)
    // 인덱스만 순회하는 for문. 0부터 a의 사이즈를 빼고
    // untill은 마지막을 포함하지 않는다. 0~8까지. 결국 0 untill 9
    //인덱스를 사용할 때는 인덱스의 범주를 생각해야한다.
    println(a.size) // 9
    for (i in 0 until a.size) {
        println(a.get(i)) //1~9
    }
    // 반복하는 방법(7)
    for (i in 0 until a.size step (2)) {
        println(a.get(i))
    } // 0, 2, 4, 6, 8... 2씩 증가 하는 인덱스에 해당하는 값이 i에 들어간다.
    // 반복하는 방법(8)
    for (i in a.size -1 downTo(0)) {
        println(a.get(i))
    } // 8부터 아래로 내려오는 인덱스 0까지.

    // 반복하는 방법 (9)
    for (i in a.size -1 downTo (0) step (2)) {
        println(a.get(i))
    } // 8, 6, 4, 2, 0

    // 반복하는 방법 (10)
    for(i in 0..10) { // .. 은 마지막 숫자(10)포함한다. 10 대신 a.size
        println(i)
    }

    // 반복하는 방법 (11)
    var b: Int = 0
    var c: Int = 4
    while(b<c) { // while을 정지키시는 코드가 있어야 무한루프에 빠지지 않음
        b++
        println("b")
    }
    // 반복하는 방법 (12) 무조건 한번은 실행
    do {
        println("hello")
    }while(b<c)
}