package common.test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < 5; i++) {
            final int ii = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("get " + ii);
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println("leave " + ii);
                }
            }).start();
        }
        System.out.println(111);
    }
}
