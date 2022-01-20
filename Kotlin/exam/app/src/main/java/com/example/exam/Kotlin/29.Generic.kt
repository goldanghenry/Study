package com.example.exam.Kotlin

// 29. Generic(제너릭)
// 목적 : 타입을 체크해주는 기능
// 제너릭은 만들기 어렵고 실제로 만들일이 거의 없기 때문에 사용하는 방법만 숙지.

fun main(args:Array<String>) {

    //제너릭을 사용하지 않은 경우
    // 형 변환을 해줘야 한다
    val list1=listOf(1,2,3,"가")
    val b: String= list1[2].toString() //형변환(타입 변환)

    // 제너릭을 사용하는 경우 -> 타입이 안전하다.
    val list2 = listOf<String>("a","b","c")
    val c: String = list2[2] // String이라는 것을 보장 받는다. 제너릭 사용.

    // 강한 타입을 체크 할수 있다.
    val list3 = listOf(1,2,3,4,"가","나",3.0)
    val list4 = listOf<Int>(1,2,3) // 강한 타입 체크, 에러.

    // 제너릭을 사용하지 않은 경우 type?
    val list5 = listOf(1,2,3,"가") // -> Any : 최고 위의 조상.
    // 부모 : Any
    // 자식 : string int float  부모는 자식의 타입이 될 수 있다.

}

