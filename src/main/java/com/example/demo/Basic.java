package com.example.demo;

import org.springframework.data.redis.core.StringRedisTemplate;

public class Basic {

	public static void main(String args[]) {
		Basic b = new Basic();
		b.run();
		StringRedisTemplate redisTemplate = new StringRedisTemplate();
		redisTemplate.delete("v");
	}

	public void run() {
		synchronized (this) {
		}
		System.out.print("lllllllllll");
		walk();
	}

	public void walk() {

	}

}
