package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;
import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zealot;
import generic.test.ex3.unit.Zergling;

public class UnitUtil {

    public static void main(String[] args) {
        Marine marine = new Marine("마린", 50);
        Zealot zealot = new Zealot("질럿", 100);
        Zergling zergling = new Zergling("저글링", 45);

        BioUnit hp = UnitUtil.maxHP(marine, zergling);
        System.out.println("hp = " + hp);

    }

    public static <T extends BioUnit> T maxHP(T t1, T t2) {
        return t1.getHp() > t2.getHp() ? t1 : t2;
    }
}
