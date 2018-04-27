package com.example.demo.proxy;
/**
 * 代理类
 * @author ThinkPad
 *
 */
public class MiddleStaticProxyImpl implements StaticProxy{
	private StaticProxy staticProxy;

	@Override
	public void buyHouse() {
		System.out.println("kkkkkkkk");
		staticProxy.buyHouse();
		
	}

}
