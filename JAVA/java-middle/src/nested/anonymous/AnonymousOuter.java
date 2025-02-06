package nested.anonymous;

import nested.local.Printer;

public class AnonymousOuter {

    private int outInstanceVar = 3;

    public void process(int paramVar) {
        int localVar = 1;

        Printer printer = new Printer() {

            int value = 0;

            @Override
            public void print() {

            }

        }
    }
}
