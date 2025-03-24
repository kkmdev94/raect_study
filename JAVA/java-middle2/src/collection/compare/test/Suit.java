package collection.compare.test;

public enum Suit {
    SPADE("\u2660"),
    HEART("\u2665"),
    DIAMOND("\u2663"),
    CLUB("\u2666");

    private String icon;

    Suit(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
