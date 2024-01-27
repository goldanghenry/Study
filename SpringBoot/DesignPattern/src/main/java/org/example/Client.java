package org.example;

// 1. 추상 제품
interface Animal {
    void makeSound();
}

// 2. 구체적인 제품
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// 3. 추상 팩토리
interface AnimalFactory {
    Animal createAnimal();
}

// 4. 구체적인 팩토리
class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

// 5. 클라이언트
public class Client {
    public static void main(String[] args) {
        // 사용하고자 하는 팩토리를 선택
        AnimalFactory factory = new DogFactory(); // 또는 CatFactory

        // 팩토리를 통해 제품(객체) 생성
        Animal animal = factory.createAnimal();

        // 제품(객체) 사용
        animal.makeSound();  // 출력: Woof! 또는 Meow!
    }
}
