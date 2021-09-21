package common.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            int ii = i;
            new Thread(() -> {
                //System.out.println(ii);
                System.out.println(Thread.currentThread().getName() + "RPC invoke");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doneLatch.countDown();
            }, ii+"").start();
        }

        doneLatch.await();
        System.out.println("get all rcp finish");
    }
}
