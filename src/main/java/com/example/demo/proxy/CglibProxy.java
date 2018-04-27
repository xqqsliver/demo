package com.example.demo.proxy;

import org.springframework.cglib.proxy.Enhancer;

/**
 * 静态代理和动态代理都需要接口。cglib不需要
 * @author xuqq
 *
 */
public class CglibProxy {
	public static void main(String args[]){
		Enhancer enhancer = new Enhancer();  
		enhancer.setSuperclass(CglibUser.class);  
		enhancer.setCallback(new CglibMethodInterceptor());  
		CglibUser cglibUser = (CglibUser)enhancer.create();
		cglibUser.add();
		cglibUser.delete(1);
	}

}
