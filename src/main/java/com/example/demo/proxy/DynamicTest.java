package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 动态代理类
 * @author ThinkPad
 *
 */
public class DynamicTest implements InvocationHandler {
	 private Object proxied;   

	  public DynamicTest( Object proxied )   
	  {   
	    this.proxied = proxied;   
	  }   

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		 	System.out.println("买东西前准备");
		    Object result = method.invoke(proxied,args);//method 可以变化的。可以是sellGoods,refund(看接口定义，不需要像静态代理那样一个一个写了)
		    System.out.println("买东西吃");
		    return result;
	}
	//测试
	 public static void main(String[] args) {
		         Sell buyHouse = new SellImpl();
		         Sell proxyBuyHouse = (Sell) Proxy.newProxyInstance(Sell.class.getClassLoader(), new
		                  Class[]{Sell.class}, new DynamicTest(buyHouse));
		         proxyBuyHouse.sellGoods();
	 }

}
