package com.example.demo.mq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public String send(String name) {
		String context = "hello " + new Date() + name;
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello12xscsc", context);
		return "cc";
	}

}
