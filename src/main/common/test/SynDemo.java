package common.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SynDemo {

    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            if (num != 0) {
                this.wait();
                System.out.println(Thread.currentThread().getName() + "-> after await");
            }

            num++;
            System.out.println(Thread.currentThread().getName() + "->" + num);

            this.notifyAll();
        }
    }

    public synchronized void decrement() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            if (num == 0) {
                this.wait();
                System.out.println(Thread.currentThread().getName() + "-> after await");
            }

            num--;
            System.out.println(Thread.currentThread().getName() + "->" + num);

            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        SynDemo demo = new SynDemo();

        new Thread(new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        })).start();
        System.out.println(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1/0);
            }
        }).start();
        System.out.println(1);

/*
        new Thread(() -> {
            try {
                demo.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();
        new Thread(() -> {
            try {
                demo.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();
*/
    }
}
