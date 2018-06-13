package com.example.demo.lock;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * 
 * @author ThinkPad
 *
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		int N = 8; // 工人数
		Semaphore semaphore = new Semaphore(5); // 机器数目
		for (int i = 0; i < N; i++)
			new Worker(i, semaphore).start();
	}

	static class Worker extends Thread {
		private int num;
		private Semaphore semaphore;

		public Worker(int num, Semaphore semaphore) {
			this.num = num;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("工人" + this.num + "占用一个机器在生产...");
				System.out.println(Thread.currentThread());
				Thread.sleep(2000);
				System.out.println("工人" + this.num + "释放出机器");
				System.out.println(Thread.currentThread());
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
