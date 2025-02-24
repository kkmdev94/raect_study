package generic.test.ex3;

import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zealot;

public class UnitUtilTest {

    public static void main(String[] args) {
        Marine marine1 = new Marine("마린1", 40);
        Marine marine2 = new Marine("마린2", 50);
        Marine result = UnitUtil.maxHP(marine1, marine2);
        System.out.println("result = " + result);

        Zealot zealot1 = new Zealot("질럿1", 150);
        Zealot zealot2 = new Zealot("질럿2", 100);
        Zealot result2 = UnitUtil.maxHP(zealot1, zealot2);
        System.out.println("result2 = " + result2);
    }
}
