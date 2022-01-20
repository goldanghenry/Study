package com.example.exam.Kotlin
// 두번까지는 봐준다(같은 코드)
// 두번 이상이 넘어가면 리펙토링(정리)해라. 기능에는 변함이 없어야.

// 상속 : 부모로부터 설명사를 물려받는다! 맴버 변수도.

fun main(arg:Array<String>) {
    val superCar=SuperCar100()
    superCar.drive()
}
// 부모 : Car100, 자식 :Supercar100, Bus100
open class Car100() { //class 는 private가 default
    open fun drive() : String {
        return "달린다"
        println("달린다")
    }
    fun stop() {}
}
class SuperCar100():Car100() {
    //부모의 기능에서 조금 수정이 필요할 때? fun 앞에 open. 마우스 우클릭 Generate
    // override methods 해도 되고 직접 쳐도 된다.
    override fun drive() : String {
        val run = super.drive()
        return "빨리 $run"
    }
}
class Bus100():Car100() {

}

