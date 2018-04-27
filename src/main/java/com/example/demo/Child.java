package com.example.demo;

public class Child extends Parent {
	public void say(){
		System.out.println("子类");
		
	}
	public static void main(String args[]){
		Parent p=new Parent();
		p.say();
	}
}
