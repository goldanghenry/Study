package com.example.exam.Kotlin

fun main(arg:Array<String>) {
    var testAccess:TestAccess = TestAccess("아무개")
    testAccess.test()
    //println(testAccess.name)
   // testAccess.name = "강아지" // 객체 안 맴버 변수가 마음대로 변한다.
   // println(testAccess.name)

    val reward : Reward = Reward()
    //reward.rewardAmount = 2000
}
class Reward() {
    val rewardAmount:Int = 1000
}
class TestAccess{
    private var name:String = "홍길동" //private 적으면 외부에서 변경 불가. class 내부만
   constructor(name:String) {
        this.name = name
    }
    fun test() { //함수 앞에 private 적으면 외부에서 함수를 사용할 수 없게 된다.
        println("테스트") // 왜 막나? 사용할 수 없는 기능인데? 공개x
    }
}
class RunningCar() {

    fun runFast() {} // 여기서는 사용가능하다.
    private fun run() {} // 외부에서는 사용할 수 없지만
}