package collection.set.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class UniqueNamesTest1 {

    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        Set<Integer> inputSet = new HashSet<>();
//        inputSet.add(30);
//        inputSet.add(20);
//        inputSet.add(20);
//        inputSet.add(10);
//        inputSet.add(10);
//        System.out.println("inputSet = " + inputSet);
        for (Integer s : inputArr) {
            inputSet.add(s);
        }

        for (Integer s : inputSet) {
            System.out.println("s = " + s);
        }
    }
}
