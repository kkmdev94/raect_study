package collection.set.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOperationsTest {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3,4,5,6,7));

        // 제대로 학습 못하고 보고 풀어 버렸다 set에서 제공하는 메서드를 좀더 잘 알아봐야겟다.
        Set<Integer> sum = new HashSet<>(set1);
//        sum.addAll(set2);
        for (Integer i : set2) {
            sum.add(i);
        }

        Set<Integer> iff = new HashSet<>();
//        iff.retainAll(set2);
        for (Integer num : set1) {
            if (set2.contains(num)) {
                iff.add(num);
            }
        }

        Set<Integer> mans = new HashSet<>(set1);
        mans.removeAll(set2);

        System.out.println("sum = " + sum);
        System.out.println("iff = " + iff);
        System.out.println("mans = " + mans);
    }
}
