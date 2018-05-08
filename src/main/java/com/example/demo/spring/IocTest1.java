package com.example.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IocTest1 {
	public static void main(String args[]) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/resources/applicationContext.xml");
		Animal animal = (Animal) context.getBean("Animal");// 这个是普通的bean
		FactoryBeanDemo factoryBeanPojo = (FactoryBeanDemo) context
				.getBean("&factoryBeanDemo");// 这个是factoryBean
		try {
			Cat ct = (Cat) factoryBeanPojo.getObject();// 获取对象
			ct.say();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		animal.say();
	}

}
