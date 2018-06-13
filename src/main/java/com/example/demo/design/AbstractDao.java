package com.example.demo.design;

public abstract class AbstractDao {

	/**
	 * 模板模式 例如一个功能的实现需要调用 method1,method2(这两个公共部分),rowMapper是一个抽象的方法 由子类自己实现
	 * 
	 */
	protected Object find(String sql) {

		String ss = sql;
		System.out.println(ss);
		Object obj;
		// method1;
		// method2;
		obj = rowMapper(ss);
		return obj;
	}

	protected abstract Object rowMapper(String name);

	// 同时可以添加 insert ，update 等方法
}
