package org.example;




public class Main {
    public static void main(String[] args) {
        // 팩토리 패턴
        Coffee coffee = CoffeeFactory.createCoffee(CoffeeType.LATTE);
        System.out.println(coffee.getName());
        /*
        // 싱글톤 패턴
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        if (a == b) {
            System.out.println(true);
        }
        */

    }
}
/*
1554547125
1554547125
true
*/