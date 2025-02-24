package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class UnitUtil1 {

    public static <T extends BioUnit> T maxHP(T t1, T t2) {
        return t1.getHp() > t2.getHp() ? t1 : t2;
    }
}
