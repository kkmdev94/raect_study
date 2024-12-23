package access.ex;

public class MaxCounter {
    private int count;
    private int max;

//    public int getCount;

//    나의 풀이
//    public MaxCounter(int max) {
//        if (count >= max) {
//            System.out.println("max 값에 도달하였습니다.");
//        }
//    }
//
//    public int increment() {
//        getCount = count++;
//        return getCount;
//    }

    public MaxCounter(int max) {
        this.max = max;
    }

    public void increment() {
        if (count >= max) {
            System.out.println("최대값을 초과할 수 없습니다.");
            return;
        }
        count++;
    }

    public int getCount() {
        return count;
    }
}
