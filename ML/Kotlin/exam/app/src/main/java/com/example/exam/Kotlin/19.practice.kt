package com.example.exam.Kotlin

fun main(array: Array<String>) {
    val arithmetic = Arithmetic()
    arithmetic.plus(10, 20)
    arithmetic.minus(10, 20)
    arithmetic.multiply(10, 20)
    arithmetic.divide(10, 2)
    println(" ")
    val calculator3 = Calculator3(3)
    calculator3.plus(5).minus(5)

    val account:Account= Account("우성현", 951130,1000)
    account.inquiry()
    account.deposit(50000)
    account.withdrawal(500)
    println(" ")

    val tv=Tv(listOf<String>("k","M","S"))
    tv.switch()
    println(tv.onOroff)


}

//1) 사칙연산을 수행할 수 있는 클래스
class Arithmetic {
    fun plus(input1: Int, input2: Int) {
        var f = input1 + input2
        println("$input1 + $input2 = $f")
    }
    fun minus(input1: Int, input2: Int) {
        var f = input1 - input2
        println("$input1 - $input2 = $f")
    }
    fun multiply(input1: Int, input2: Int) {
        var f = input1 * input2
        println("$input1 * $input2 = $f")
    }
    fun divide(input1: Int, input2: Int) {
        var f = input1 / input2
        println("$input1 / $input2 = $f")
    }
}
class Calculator() {
    fun Plus(vararg numbers: Int): Int {
        var result = 0
        numbers.forEach {
            result += it
        }
        return result
    }

    fun minus(vararg numbers: Int): Int {
        var result: Int = numbers[0]
        for (i in 0 until numbers.size) {
            if (i != 0)
                result -= numbers[i]
        }
        return result
    }

    fun multiply(vararg numbers: Int): Int {
        var result: Int = 1
        numbers.forEach {
            if (it != 0) {
                result *= it
            }
        }
        return result
    }

    fun divide(vararg numbers: Int): Int {
        var result: Int = numbers[0]
        numbers.forEachIndexed { index, value ->
            if (index != 0 && value != 0) {
                result /= value
            }
        }
        return result
    }
}

// 자료형은 타입이 될 수 있다. +연산의 결과 Cal3가 나간다(=Int).
class Calculator3(val initiaValue: Int) {
    fun plus(number: Int): Calculator3 {
        val result = this.initiaValue + number
        return Calculator3(result)
    }

    fun minus(number: Int): Calculator3 {
        var result = this.initiaValue - number
        return Calculator3(result)
    }

    fun multiply(number: Int): Calculator3 {
        var result = this.initiaValue * number
        return Calculator3(result)
    }

    fun divide(number: Int): Calculator3 {
        var result = this.initiaValue / number
        return Calculator3(result)
    }
}


//2)은행 계좌 만들기
class Account {
    var name: String = "우성현"
    var birth: Int = 0
    var balance:Int=1000 //초기값

    init{
        println("$name 님의 계좌가 생성되었습니다. 예금 잔액 : $balance")
    }

    constructor(name: String, birth: Int, balance:Int) {
        this.name = name
        this.birth = birth
        if(balance >= 0) { //초기값 음수 제어
            this.balance = balance
        } else {
            this.balance = 0
        }
        this.balance = balance
    }
    fun deposit(m:Int) {
        balance += m
        println("$m 원 예금이 완료되었습니다. 예금 잔액:$balance")
    }
    fun inquiry() {
        println("현재 예금 잔액:$balance")
    }
    fun withdrawal(d:Int) {
        balance -= d
        println("$d 원이 출금되었습니다. 예금 잔액:$balance")
    }
}
class Account2(initialBalance:Int) {  // 변수 앞에 val이나 var를 적어주지x
    //음수 제어
    val balance : Int = if (initialBalance >= 0) initialBalance else 0
    // 값을 리턴하는 if
    fun checkBalance():Int {
        return balance
    }
}

class Tv(val channels: List<String>) {

    var onOroff: Boolean = false //True -> On, False -> off
    var currentChnnelNumber = 0
        set(value) { // 아래 적어줘야함. 위의 변수. 할당하는 부분. 새로 들어오는 value.
            field = value // 무한 반복을 피할 수 있는 키워드
            //currentChnnelNumber = value -> 무한 루프.
            if (field > 2) field = 0
            if (field < 0) field = 2
            println(value)
        }
    //set은 위의 변수에 어떤 값을 할당할 때 포착, 호출된다.
    // 값을 할당 a = b. value를 위 변수에 넣는다.
    // 값이 나갈 때? get. 누군가에 의해 사용될 때(반환)
        get(){
            println("호출되었습니다.")
        return field // 현재 currentChannelNumber
        }

    fun switch() {
        onOroff = !onOroff
    }
    fun channelUp() {
        currentChnnelNumber = currentChnnelNumber + 1
    }
    fun checkCurrentChannel(): String {
        return channels[currentChnnelNumber]
    }
    fun channelDown() {
        currentChnnelNumber = currentChnnelNumber - 1
    }



}

