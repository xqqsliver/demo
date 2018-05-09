package com.qq.xu.test.test1;

import java.util.concurrent.DelayQueue;

public class OrderDelayRunnable implements Runnable {
    private DelayQueue<OrderDelayTask> tasks;
    public OrderDelayRunnable(DelayQueue<OrderDelayTask> tasks) {
    	this.tasks=tasks;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                OrderDelayTask task = tasks.take();
                if (null == task) {
                    continue;
                }
                handler(task);
            } catch (InterruptedException e) {
            	System.out.println(e);
                
            }
            System.out.println("Finished PersonalCussumer");
        }

    }

    private void handler(OrderDelayTask task) {
        task.setOrderSatus("1");
        System.out.println("order status 1");

    }
}
