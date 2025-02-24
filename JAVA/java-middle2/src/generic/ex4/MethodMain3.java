package generic.ex4;

import generic.animal.Cat;
import generic.animal.Dog;

public class MethodMain3 {

    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 200);

        ComplexBox<Dog> hosital = new ComplexBox<>();
        hosital.set(dog);

        Cat returnCat = hosital.printAndReturn(cat);
        System.out.println("returnCat = " + returnCat);
    }
}
