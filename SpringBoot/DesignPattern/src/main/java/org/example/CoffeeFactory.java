package org.example;

// factory pattern
// enum : 상수의 집합을 정의할 때 사용하는 타입
enum CoffeeType {
    LATTE,
    ESPRESSO
}

// 추상 클래스 커피
abstract class Coffee {
    protected String name;
    public String getName() {
        return name;
    }
}

// 추상 클래스인 커피를 상속 받아 생성자 구현
class Latte extends Coffee {
    public Latte() {
        name = "latte";
    }
}

class Espresso extends Coffee {
    public Espresso() {
        name ="Espresso";
    }
}

class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType type) {
        switch (type) {
            case LATTE : return new Latte();
            case ESPRESSO : return new Espresso();
            default : throw new IllegalArgumentException("Invalid coffee type: "+type);
        }
    }
}
