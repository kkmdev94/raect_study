package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class Shuttle<T extends BioUnit> {

    private T Unit;

    public void in(T unit) {
        this.Unit = unit;
    }

    public void showInfo() {
        System.out.println("이름 : " + Unit.getName() + ", HP : " + Unit.getHp());
    }
}
