package collection.compare.test;

public class Card implements Comparable<Card> {

    private final int rank; // 카드 숫자
    private final Suit suit; // 카드 문양

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
    public int compareTo(Card o) {
        // 숫자를 먼저 비교하고, 숫자가 같으면 마크를 비교
        if (this.rank != o.rank) {
            return Integer.compare(this.rank, o.rank);
        } else {
            return this.suit.compareTo(o.suit); // ENUM은 이미 컴페어블을 상속받고 있고, 여기서 오디널을 통해 ENUM은 자체의 순서를 가지게 된다.
        }
    }

    @Override
    public String toString() {
        return rank + "(" + suit.getIcon() + ")";
    }
}
