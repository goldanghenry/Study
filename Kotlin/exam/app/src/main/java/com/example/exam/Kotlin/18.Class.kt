package com.example.exam.Kotlin

//객체를 만드는 방법
fun main(array:Array<String>) {
// 클래스(설명서)를 통해서 실체를 만드는 방법 -> 인스턴스화(과정) -> 인스턴스(실제로 만들어진것)
    Car("v8 engine", "big")
    // 우리가 만든 클래스(설명서)는 자료형이 된다.
    val bigCar = Car("v8 engine", "big")
    val bigCar1 : Car = Car("v8 engine", "big")
    val superCar : SuperCar = SuperCar("good engine", "big", "white")

    val runableCar:RunableCar = RunableCar("simple engine", "short body")
    runableCar.ride()
    runableCar.navi("부산")
    runableCar.drive()

    //인스턴스의 맴버 변수에 접근하는 방법
    val runableCar2 : RunableCar2 = RunableCar2("nice engine", "long body")
    println(runableCar2.body)
    println(runableCar2.engine)

}
//클래스(설명서) 만드는 방법(1) - 축약
class Car(var engine : String, var body: String) {
}
//클래스(설명서) 만드는 방법(2) - 정식
class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(engine: String, body: String, door:String) {
        println(engine)
        println(body)
        println(door)
        this.engine = engine //this는 설명서. 함수를 통해 들어온 good engine부품을 넣어준다.
        this.body = body
        this. door = door
    }
}
// 클래스(설명서) 만드는 방법(3) -> 1번 방법의 확장. 2는 필수, door는 따로 있어도 없어도 가능.
class Car1 constructor(engine: String, body: String) {
    var door: String =""
    // 생성자. 추가적으로 있으면 좋은 것을 본문 안에.
    constructor(engine: String, body: String, door: String):this(engine, body) {
        this.door = door
    }
}

// 클래스(설명서) 만드는 방법(4) -> 2번 방법의 확장
class Car2 {
    var engine: String=""
    var body:String=""
    var door:String=""

    constructor(engine:String, body: String) {
        this.engine = engine
        this.body = body
    }
    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

class RunableCar(engine: String, body: String) {
    fun ride() {
        println("탑승하였습니다")
    }
    fun drive() {
        println("달립니다")
    }
    fun navi(destination:String) {
        println("$destination 으로 목적지가 설정되었습니다.")
    }
}

class RunableCar2 {
    var engine: String
    var body: String

    init {
    //class안에 적을 시 실제 객체가 만들어질 때 가장 먼저 호출된다. 초기 셋팅시 유용.
        println("RunableCar2가 만들어졌습니다.")
    }

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    fun ride() {
        println("탑승하였습니다")
    }

    fun drive() {
        println("달립니다")
    }

    fun navi(destination: String) {
        println("$destination 으로 목적지가 설정되었습니다.")
    }
}

//오버로딩 : class 안에 함수의 이름이 동일할 때 처리하는 방법(인자가 다르다면 가능)
class TestClass() {

    fun test(a:Int){}
    fun test(a:Int,b:Int){} //구분가능하기 때문
}