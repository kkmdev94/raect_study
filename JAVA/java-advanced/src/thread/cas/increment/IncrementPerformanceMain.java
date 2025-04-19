package thread.cas.increment;

public class IncrementPerformanceMain {

    public static final long COUNT = 100_000_000;

    public static void main(String[] args) {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test(INcrementInteger iNcrementInteger) {
        long startMs = System.currentTimeMillis();

        for (int i = 0; i < COUNT; i++) {
            iNcrementInteger.increment();
        }

        long endtMs = System.currentTimeMillis();
        System.out.println(iNcrementInteger.getClass().getSimpleName() + " : ms = " + (endtMs-startMs));

    }
}
