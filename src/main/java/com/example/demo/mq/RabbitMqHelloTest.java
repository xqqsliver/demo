package com.example.demo.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.amqp.core.BindingBuilder;

public class RabbitMqHelloTest {
	private static final String HOST = "XXXX";

	private static final String USERNAME = "xxx";
	private static final String PASSWORD = "xxx";

	public static void main(String[] args) throws IOException, TimeoutException {
		BindingBuilder.bind();
	}
}
