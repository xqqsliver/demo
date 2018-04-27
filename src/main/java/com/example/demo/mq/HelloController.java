package com.example.demo.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	private HelloSender helloSender;

	@RequestMapping("/send/{name}")
	public String helloworld(@PathVariable String name) {
		// RabbitListener rabbitListener =

		// rabbitListener.queues();
		return helloSender.send(name);
	}
}
