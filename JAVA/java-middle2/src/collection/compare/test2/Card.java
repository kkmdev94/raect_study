package collection.compare.test2;

import java.util.Comparator;

public class Card implements Comparable<Card> {

    private final int rank;
    private final Suit suit;

    public Card(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card antherCard) {
        if (this.rank != antherCard.rank) {
            return Integer.compare(this.rank, antherCard.rank);
        } else {
            return this.suit.compareTo(antherCard.suit);
        }
    }
}
