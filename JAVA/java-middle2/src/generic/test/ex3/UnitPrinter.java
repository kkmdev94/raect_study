package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;

public class UnitPrinter {

    public static <T extends Shuttle> T printV1(T t) {
        t.showInfo();
        return t;
    }

    static void printV2(Shuttle<? extends BioUnit> shuttle) {
        shuttle.showInfo();
    }
}

