package bxz.base.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by SQ_BXZ on 2018-08-16.
 *  生产者/消费者模型  使用BlockingQueue实现
 *
 *
 *
 */
public class ProductionAndConsumption_2 {

	private static Integer count = 0;

	//创建一个阻塞队列
	final BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);


	public static void main(String[] args) {
		ProductionAndConsumption_2 test1 = new ProductionAndConsumption_2();
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
				try {
					blockingQueue.put(1);
					count++;
					System.out.println(Thread.currentThread().getName()
							+ "生产者生产，目前总共有" + count);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
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
				try {
					blockingQueue.take();
					count--;
					System.out.println(Thread.currentThread().getName()
							+ "消费者消费，目前总共有" + count);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}



}
