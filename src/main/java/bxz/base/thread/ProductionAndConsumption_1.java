package bxz.base.thread;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SQ_BXZ on 2018-08-16.
 *  生产者/消费者模型 ReentrantLock的实现
 *
 *  java.util.concurrent.lock 中的 Lock 框架是锁定的一个抽象，
 *  通过对lock的lock()方法和unlock()方法实现了对锁的显示控制，
 *  而synchronize()则是对锁的隐性控制。可重入锁，也叫做递归锁，指的是同一线程 外层函数获得锁之后 ，
 *  内层递归函数仍然有获取该锁的代码，但不受影响，简单来说，该锁维护这一个与获取锁相关的计数器，
 *  如果拥有锁的某个线程再次得到锁，那么获取计数器就加1，函数调用结束计数器就减1，
 *  然后锁需要被释放两次才能获得真正释放。已经获取锁的线程进入其他需要相同锁的同步代码块不会被阻塞。
 *
 */
public class ProductionAndConsumption_1 {
	private static Integer count = 0;
	private static final Integer FULL = 10;
	//创建一个锁对象
	private  Lock lock = new ReentrantLock();

	//创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	public static void main(String[] args) {
		ProductionAndConsumption_1 test1 = new ProductionAndConsumption_1();
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
				// 获取锁
				lock.lock();
				try {
					while (count==FULL){
						try {
							System.out.println(Thread.currentThread().getName()+"等待消费------");
							notFull.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					count++;
					System.out.println(Thread.currentThread().getName()+"生产者生产，目前总共有"+count);
					// 唤醒消费者
					notEmpty.signal();
				} finally {
					// 释放锁
					lock.unlock();
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
				// 获取锁
				lock.lock();
				try {
					while (count==FULL){
						try {
							System.out.println(Thread.currentThread().getName()+"等待生产------");
							notEmpty.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					count++;
					System.out.println(Thread.currentThread().getName()+"消费者消费，目前总共有"+count);
					// 唤醒消费者
					notFull.signal();
				} finally {
					// 释放锁
					lock.unlock();
				}

			}
		}
	}

}
