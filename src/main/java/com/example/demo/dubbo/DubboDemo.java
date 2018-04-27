package com.example.demo.dubbo;

import java.util.LinkedList;
import java.util.ListIterator;

public class DubboDemo {
	public static void main(String args[]) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("aaaa");
		ll.add("bbbb");
		ll.add("cccc");

		// ListIterator(列表迭代器)有add及previous方法
		ListIterator<String> it = ll.listIterator();
		/***
		 * 在 “bbbb” 后面插入 “xxxx”
		 */
		/**
		 * while (it.hasNext()) { String item = it.next(); if
		 * ("bbbb".equals(item)) { it.add("xxxx"); } }
		 **/
		ll.add(0, "xxxxxxxxxxxxsssssssssssss");
		// ll.set(0, "xxxxxxxxxxxxsssssssssssss");
		System.out.println(ll); // 输出结果： [aaaa, bbbb, xxxx, cccc]

		/***
		 * 在 “bbbb” 修改为 “BBBB”
		 */
		it = ll.listIterator();
		while (it.hasNext()) {
			String item = it.next();
			if ("bbbb".equals(item)) {
				it.set("BBBB");
			}
		}
		System.out.println(ll);
	}

}
