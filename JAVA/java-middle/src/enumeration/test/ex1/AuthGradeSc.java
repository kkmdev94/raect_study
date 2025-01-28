package enumeration.test.ex1;

public enum AuthGradeSc {
    GUEST("손님",1),
    LOGIN("회원", 2),
    ADMIN("관리자", 3);

    private final String description;
    private final int lavel;

    AuthGradeSc(String description, int lavel) {
        this.description = description;
        this.lavel = lavel;
    }

    public String getDescription() {
        return description;
    }

    public int getLavel() {
        return lavel;
    }
}
