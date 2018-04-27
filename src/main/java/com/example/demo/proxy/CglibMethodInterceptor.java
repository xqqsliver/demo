package com.example.demo.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibMethodInterceptor implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
		 System.out.println("Before:" + method);  
	        Object object = proxy.invokeSuper(obj, arg);
	        System.out.println("After:" + method); 
	        return object;
	}

}
