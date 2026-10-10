import java.util.concurrent.atomic.AtomicLong;

public class Apurbo_Thread extends Thread {
    private static final AtomicLong safeCounter = new AtomicLong(0);
    private static long unsafeCounter = 0;

    private final int increments;
    private final boolean threadSafe;
    private long instanceCounter = 0;

    public Apurbo_Thread(int increments, boolean threadSafe) {
        this.increments = increments;
        this.threadSafe = threadSafe;
    }

    @Override
    public void run() {
        for (int i = 0; i < increments; i++) {
            if (threadSafe) {
                safeCounter.incrementAndGet();
            } else {
                unsafeCounter++;
            }
            instanceCounter++;
        }
    }

    public long getInstanceCounter() {
        return instanceCounter;
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 3) {
            System.out.println("Usage: java Apurbo_Thread <threads> <incrementsPerThread> <true|false>");
            return;
        }

        int threadCount = Integer.parseInt(args[0]);
        int increments = Integer.parseInt(args[1]);
        boolean threadSafe = Boolean.parseBoolean(args[2]);

        if (threadCount <= 0 || increments < 0 ||
                !(args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false"))) {
            System.out.println("Invalid input. Threads must be positive, increments non-negative, and mode true/false.");
            return;
        }

        safeCounter.set(0);
        unsafeCounter = 0;
        Apurbo_Thread[] threads = new Apurbo_Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Apurbo_Thread(increments, threadSafe);
            threads[i].start();
        }

        for (Apurbo_Thread thread : threads) {
            thread.join();
        }

        long expectedCount = (long) threadCount * increments;
        long staticCount = threadSafe ? safeCounter.get() : unsafeCounter;
        long nonStaticTotal = 0;
        for (Apurbo_Thread thread : threads) {
            nonStaticTotal += thread.getInstanceCounter();
        }

        long absoluteDifference = Math.abs(staticCount - nonStaticTotal);
        double percentageDifference = nonStaticTotal == 0
                ? (staticCount == 0 ? 0.0 : Double.NaN)
                : (absoluteDifference * 100.0 / nonStaticTotal);

        System.out.println("Mode: " + (threadSafe ? "Thread-safe (AtomicLong)" : "Unsafe (static long)"));
        System.out.println("Threads: " + threadCount);
        System.out.println("Increments per thread: " + increments);
        System.out.println("Expected count: " + expectedCount);
        System.out.println("Static count: " + staticCount);
        System.out.println("Non-static total: " + nonStaticTotal);
        System.out.println("Absolute difference: " + absoluteDifference);
        System.out.printf("Percentage difference: %s%n",
                Double.isNaN(percentageDifference) ? "undefined" : String.format("%.4f%%", percentageDifference));
    }
}
