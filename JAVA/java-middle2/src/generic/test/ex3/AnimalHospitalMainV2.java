package generic.test.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV2 {

    public static void main(String[] args) {
        AnimalHospitalV2<Dog> dogHopital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Cat> catHopital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Integer> integerHopital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Double> doubleHopital = new AnimalHospitalV2<>();

        // 제네릭에서 타입 매개변수를 사용하면 어떤 타입이든 들어올 수 있다.
        // 따라서 타입 매개변수를 어떤 타입이든 수용할 수 있는 Object로 가정하고, Object의 기능만 사용할 수 있다.
    }
}
