package com.example.demo.base;

public class TestString {
	public static void main(String args[]) {

		String str1 = "abcd";
		String str2 = "ab";
		String str3 = "cd";
		String str4 = str2 + str3;
		String str5 = "ab" + "cd";
		System.out.println(str1 == str4);
		System.out.println(str1 == str5);

	}
	/**
	 * str2 + str3 原来两个字符串str1, str2的拼接 首先会调用 String.valueOf(obj)， 这个Obj为str1，
	 * 而String.valueOf(Obj)中的实现是return obj == null ? "null" : obj.toString(),
	 * 然后产生StringBuilder， 调用的StringBuilder(str1)构造方法，
	 * 把StringBuilder初始化，长度为str1.length()+16。此时的StringBuilder对象是在堆上创建的！，
	 * 接下来调用StringBuilder.append(str2), 把第二个字符串拼接进去，
	 * 然后调用StringBuilder.toString返回结果。所以会返回false。
	 */
	/**
	 * ab" + "cd" jvm会直接把"ab" + "cd" 看成"abcd"。实际上jvm对于这时候的 +
	 * (加号)的处理是在编译期就已经完成了。这时候并没有涉及到stringbuilder
	 * 
	 */
}
