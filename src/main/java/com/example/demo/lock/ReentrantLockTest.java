package com.example.demo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 所谓重入锁，指的是以线程为单位，当一个线程获取对象锁之后，这个线程可以再次获取本对象上的锁，而其他的线程是不可以的
 * synchronized 和   ReentrantLock 都是可重入锁
 * @author ThinkPad
 *
 */
public class ReentrantLockTest {
	 private Lock lock = new ReentrantLock();
	    private Condition condition=lock.newCondition();
	    public void testMethod() {
	        
	        try {
	            lock.lock();
	            System.out.println("开始wait");
	            condition.await();
	            for (int i = 0; i < 5; i++) {
	                System.out.println("ThreadName=" + Thread.currentThread().getName()
	                        + (" " + (i + 1)));
	            }
	        } catch (InterruptedException e) {
	            // TODO 自动生成的 catch 块
	            e.printStackTrace();
	        }
	        finally
	        {
	            lock.unlock();
	        }
	    }
	    public static void main(String args[]){
	    	ReentrantLockTest t=new ReentrantLockTest();
	    	t.testMethod();
	    }

}
