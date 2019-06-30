import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    // Atomic integer containing the next thread ID to be assigned
    private static AtomicInteger nextId = new AtomicInteger(1);

    public class TThread extends Thread {

        int id;

        public TThread() {
            id = nextId.getAndIncrement();
        }

        @Override
        public void run() {
            System.out.println("Thread " + id + " starting...");
            try {
                Thread.sleep(1000);
                System.out.println("Thread " + id + " is running...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Throwable {
        ThreadTest test = new ThreadTest();
        Thread thread1 = test.new TThread();
        Thread thread2 = test.new TThread();
        Thread thread3 = test.new TThread();
        thread1.setPriority(10);
        thread2.setPriority(8);
        thread3.setPriority(6);
        thread1.start();
        thread2.start();
        thread2.join();
        thread3.start();
    }
}
