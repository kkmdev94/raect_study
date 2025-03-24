package collection.compare.test2;

import java.util.ArrayList;

public class Heart {

    private int cardSize = 13;

    ArrayList<Integer> heart = new ArrayList<>();

    public ArrayList<Integer> getHeart() {
        for (int i = 0; i < cardSize; i++) {
            System.out.println(i+1 + "\u2665");
        }
        return heart;
    }
}
