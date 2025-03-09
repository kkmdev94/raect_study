package collection.set.member;

public class MemeberNoHashNoEq {

    private String id;

    public MemeberNoHashNoEq(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MemeberNoHashNoEq{" +
                "id='" + id + '\'' +
                '}';
    }
}
