package bxz.base.thread;

/**
 * https://juejin.im/entry/596343686fb9a06bbd6f888c
 * <p>
 * Created by SQ_BXZ on 2018-08-16.
 * 生产者/消费者模型 wait()和notify()的实现
 * <p>
 * 缓冲区满和为空时都调用wait()方法等待，
 * 当生产者生产了一个产品或者消费者消费了一个产品之后会唤醒所有线程。
 */
public class ProductionAndConsumption {
    private static final Integer FULL = 10;
    private static Integer count = 0;
    private static String LOCK = "lock1";

    public static void main(String[] args) {
        ProductionAndConsumption test1 = new ProductionAndConsumption();
        new Thread(test1.new Producer()).start();
//		new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
//		new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
    }

    /**
     * 消费者
     */
    class Consumer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "待生产-------");
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    /**
     * 生产者
     */
    class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "待消费-------");
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

}
