package com.example.demo.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean
 * 
 * @author ThinkPad
 *
 */
public class FactoryBeanDemo implements FactoryBean<Object> {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public Object getObject() throws Exception {
		if (type.equals("cl")) {
			return new Cat();
		} else {
			return new Object();
		}
	}

	@Override
	public Class getObjectType() {
		// TODO Auto-generated method stub
		return Cat.class;
	}

}
