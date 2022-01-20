package com.example.exam.Kotlin

// 과제
//Night, Monster - 부모 -> Charactor 로 줄이기.
// SuperNight, SuperMonster - 자식이 가진 특별한 기능.
// 상속 관계를 이용해 공격과 반응

fun main(args:Array<String>) {
    val monster=SuperMonster(100,10)
    val night=SuperNight(130, 8)
    monster.attack(night)
    monster.bite(night)
}
// 상속이 만들어낸 특징, 자식 클래스는 부모 클래스의 타입이다. 거꾸로는 안된다.
// 부모클래스는 자식 클래스의 타입이 아니다.
open class Charator(var hp :Int, val power:Int) {
    fun attack(charator:Charator, power:Int=this.power) {
        charator.defense(power)
    }
    open fun defense(damage:Int) {
        hp -= damage
        if(hp >0) println("${javaClass.simpleName}의 남은 체력: $hp") //클래스 이름 호출
        else println("${javaClass.simpleName}는 사망 했습니다.")
    }
}
// 자식 클래스가 인스턴스화 되기 위해서 부모 클래스 선행되서 인스턴스화 되어야 한다.
class SuperMonster(hp:Int, power:Int):Charator(hp,power) {
    fun bite(charator: Charator) {
        super.attack(charator, power+2)
    }
}
class SuperNight(hp:Int, power:Int):Charator(hp,power) {
    val defensePower = 2
    override fun defense(damage: Int) {
        super.defense(damage-defensePower)
    }
}