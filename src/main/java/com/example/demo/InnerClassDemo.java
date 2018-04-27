package com.example.demo;

public class InnerClassDemo {
	//普通内部类
	class normal{
		
	}
	//静态内部类
	static class staticDemo{
		
	}
	public void jump(){
		//局部内部类
		@SuppressWarnings("unused")
		class normalInner{
			
		}
		
		//匿名内部类
		new InnerClassDemo(){
			@SuppressWarnings("unused")
			public void walk(){
				
			}
		};
	}
	

}

