package common.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger i = new AtomicInteger();
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "\t" + i.incrementAndGet());
                try {
                    Thread.sleep(100000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Thread.yield();
            }
        });
        t1.setName("T1");
        t1.start();
        //t1.join();

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "\t" + i.incrementAndGet());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
            }
        });
        t2.setName("T2");
        t2.start();
        //t2.join();
    }
}
