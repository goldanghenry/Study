package com.example.exam.Kotlin

//변수의 접근 범위 : 필요한 곳에서만 접근할 수 있도록 최소한으로 설정하는 것이 좋다.
// 1. 전역 변수
// 2. 지역 변수 :
var number100:Int = 10

fun main(array:Array<String>) {
    println(number100)
    var test = Test("홍길동")
    test.testFun()
    test.name
    println(number100)
}
class Test(var name:String) { // 클래스 안에서 접근할 수 있는 변수 중괄호 안
    fun testFun() {
        var birth:String ="2000/3/1" // 함수 안에서만 사용 가능
       name = "홍길동"
        number100 = 100
    }
}
