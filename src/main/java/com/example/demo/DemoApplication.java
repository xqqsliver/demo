package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DemoApplication {
	// public DemoApplication(Thread t) {
	// }

	public static void main(String[] args) {
		// String l = "";
		// Parent p = new Parent();
		// p.say();
		// DemoApplication d = new DemoApplication(new Thread() {

		// public void say() {

		// }
		// });

		SpringApplication.run(DemoApplication.class, args);
	}

	public void as1() {
		as();
	}

	public void as() {

	}
}
