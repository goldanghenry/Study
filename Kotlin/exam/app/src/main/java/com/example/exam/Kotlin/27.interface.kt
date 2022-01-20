package com.example.exam.Kotlin
// 인터페이스는 약속. 니가 이것을 구현하면 너도 이 타입이다.
// 구현하는 클래스는 인터페이스가 가지고 있는 함수를 반드시 구현해야 한다. 내용을 채운다.
// 정확한 기능 설명이 필요. 생성자가 없다. -> 인스턴스화 x, 설명서가 아니다.
// 지침서이다. 니가 이것을 구현하고 싶다면, 반드시 아래 기능을 구현해라.
// 구현하는 클래스가 담당하기 때문에 괄호가 없다.
// 우클릭, Implement(구현하다) methods
// Student_는 Person_의 타입이 된다.
// 상속은 자식 클래스들이 공통 기능을 부모 클래스에 올려두면 편하다.
// 자식이 부모의 기능을 쓰는데 조금 다를 때
// interface는 부모와 자녀의 기능이 많이 다를 때.(fun의 세부 내용이)
fun main(args:Array<String>) {
    val student_: Student_ = Student_()
    student_.eat()
    student_.sleep()
}

interface Person_{
    fun eat()
    fun sleep()
}
class Student_:Person_ {
    override fun eat() {}
    override fun sleep() {}
}

class SocerPlay: Person_ {
    override fun eat() {}
    override fun sleep() {}
}

open class Person() {
   open fun eat() {

    }
    fun sleep() {

    }
}

class Student(): Person() {

}

class Teacher(): Person(){

}
