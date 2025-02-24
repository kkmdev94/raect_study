package generic.test.ex3;

import generic.test.ex3.unit.BioUnit;
import generic.test.ex3.unit.Marine;
import generic.test.ex3.unit.Zealot;
import generic.test.ex3.unit.Zergling;

public class ShuttleTest {

    public static void main(String[] args) {
        Shuttle<Marine> suttle1 = new Shuttle<>();
        suttle1.in(new Marine("마린",50));
        suttle1.showInfo();

        Shuttle<Zealot> shuttle2 = new Shuttle<>();
        shuttle2.in(new Zealot("질럿", 150));
        shuttle2.showInfo();

        Shuttle<Zergling> shuttle3 = new Shuttle<>();
        shuttle3.in(new Zergling("저글링", 40));
        shuttle3.showInfo();
    }
}
