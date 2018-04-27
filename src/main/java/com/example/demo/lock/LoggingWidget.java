package com.example.demo.lock;
/**
 * 如果synchronized 不是可重入锁，那么LoggingWidget 的super.dosomething();无法获得Widget对象的锁，因为会死锁。
 * @author ThinkPad
 *子类对象，其实是持有父类Widget 的doSomething方法的，
 *只需要使用super关键字告诉虚拟机要运行的是父类的doSomething方法，
 *虚拟机会去调用子类对象中的父类Widget 的doSomething方法的。
 *所以，super关键字并没有新建一个父类的对象，
 *比如说widget，然后再去调用widget.doSomething方法，
 *实际上调用父类doSomething方法的还是我们的子类对象。
 *
　*那么这样就很好理解了，
　*如果一个线程有子类对象的引用loggingWidget，
　*然后调用loggingWidget.doSomething方法的时候，
　*会请求子类对象loggingWidget 的对象锁；
　*又因为loggingWidget 的doSomething方法中调用的父类的doSomething方法
　*，实际上还是要请求子类对象loggingWidget 的对象锁，
　*那么如果synchronized 关键字不是个可重入锁的话，
　*就会在子类对象持有的父类doSomething方法上产生死锁了。
　*正因为synchronized 关键字的可重入锁，
　*当前线程因为已经持有了子类对象loggingWidget 的对象锁，
　*后面再遇到请求loggingWidget 的对象锁就可以畅通无阻地执行同步方法了。
  */
public class LoggingWidget extends Widget {
     public synchronized void doSomething() {
         super.doSomething();
    }
     
     public static void main(String args[]){
    	 LoggingWidget w=new LoggingWidget();
    	 w.doSomething();
     }
 }