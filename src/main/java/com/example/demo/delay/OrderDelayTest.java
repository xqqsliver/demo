package com.example.demo.delay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OrderDelayTest {

	public static void main(String[] args) {
		// 存放任务处理的队列
		DelayQueue<OrderDelayTask> delayQueue = new DelayQueue();

		// 初始化线程池
		ArrayBlockingQueue<Runnable> arrayWorkQueue = new ArrayBlockingQueue(10);
		ExecutorService threadPool = new ThreadPoolExecutor(5, 10, 60L,
				TimeUnit.SECONDS, arrayWorkQueue,
				new ThreadPoolExecutor.AbortPolicy());
		List<OrderDelayTask> li = new ArrayList<OrderDelayTask>();
		// 模拟10条数据 这里可以是从数据库里面查询出满足条件的数据
		for (int i = 0; i < 10; i++) {
			OrderDelayTask o = createOrderData(i);
			li.add(o);
			delayQueue.put(o);
		}
		threadPool.execute(new OrderDelayRunnable(delayQueue));
		// System.out.println(li);

	}

	public static OrderDelayTask createOrderData(int i) {
		OrderDelayTask item = new OrderDelayTask();
		item.setOrderNo("xuqqorderno" + i);
		item.setCreateTime(System.currentTimeMillis() + i * 1000);
		item.setExecuteTime(System.currentTimeMillis() + i * 1000 + 600);
		item.setOrderSatus("0");
		return item;

	}

}
