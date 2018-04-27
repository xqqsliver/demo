package com.example.demo.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	public static void main(String[] args)
	{
	    ApplicationContext ctx = 
	            new ClassPathXmlApplicationContext("aop.xml");
	        
	    HelloWorld hw1 = (HelloWorld)ctx.getBean("helloWorldImpl1");
	    HelloWorld hw2 = (HelloWorld)ctx.getBean("helloWorldImpl2");
	    hw1.printHelloWorld();
	    System.out.println();
	    hw1.doPrint();
	    
	    System.out.println();
	    hw2.printHelloWorld();
	    System.out.println();
	    hw2.doPrint();
	    //匿名内部类的格式 new P(){method};
	    //P为接口。method 为P里面定义的方法的实现
	    Person p=new Person(){
	    		public void say(){
	    			System.out.println("www");
	    		}
	    };
	    p.say();
	}
	
	

}
