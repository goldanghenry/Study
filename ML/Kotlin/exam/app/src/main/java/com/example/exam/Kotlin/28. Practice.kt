package com.example.exam.Kotlin
// 상속하고 싶은데 협업때문에 interface를 사용해야 하는 경우?
// 인터페이스도 구현이 있는 함수를 만들 수 있다.
// 인터페이스에 구현이 있는 함수는 인터페이스를 구현하는 클래스에서 그 함수를 구현할 필요가 없다.
fun main(args:Array<String>) {
    val student__=Student__()
    student__.sleep()
}

interface Person__{
    fun eat() {
        println("먹는다")
    } //여기에서 구현을 할 수 있다. }
    fun sleep() {
        println("잔다")
    }
    abstract fun study() // 선생과 학생의 기능 차이가 크다. 이 클래스는 반드시 구현해야한다.
}
class Student__:Person__ {
    override fun study() {
    }
} // 구현부가 없더라도 에러가 발생하지 않는다.

class Teacher__: Person__ {
    override fun study() {
    }
}