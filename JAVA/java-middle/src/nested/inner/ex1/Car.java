package nested.inner.ex1;

public class Car {

    private int chargeLevel;
    private String model;
    private Engine engine;

    public Car(int chargeLevel, String model) {
        this.chargeLevel = chargeLevel;
        this.model = model;
        this.engine = new Engine(this);
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public String getModel() {
        return model;
    }

    public void start() {
        engine.start();
        System.out.println(model + " 시작 완료");
    }
}
