package nested.inner.ex2;

public class Car {

    private int chargeLevel;
    private String model;
    private Engine engine;

    public Car(int chargeLevel, String model) {
        this.chargeLevel = chargeLevel;
        this.model = model;
        this.engine = new Engine();
    }
//    그냥 참조값 들어오는 것을 멤버변수로 넘기니까 내부클래스에서는 그것을 참조하면되기에 굳이 getter가 필요없다.
//    public int getChargeLevel() {
//        return chargeLevel;
//    }
//
//    public String getModel() {
//        return model;
//    }

    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }

    private class Engine {

//        private Car car;
//        //내부 클래스는 바깥 클래스에 접근이 가능하기에 차에 대한 정보를 알 필요가 없다.
//        public Engine(Car car) {
//            this.car = car;
//        }

        public void start() {
            System.out.println("충전 레벨 확인: " + chargeLevel);
            System.out.println(model +  "의 엔진을 구동합니다.");
        }
    }
}

