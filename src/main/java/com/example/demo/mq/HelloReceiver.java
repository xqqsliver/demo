package com.example.demo.mq;

/**
 * @RabbitListener注解标注该类为RabbitMQ的消息处理类
 * @RabbitHandler注解标注在方法上，
 * 表示当有收到消息的时候，
 * 就交给带有@RabbitHandler的方法处理，
 * 具体找哪个方法需要根据MessageConverter转换后的对象类型决定
 */
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello12xscsc")
public class HelloReceiver {

	@RabbitHandler
	public void process(String hello) {
		System.out.println("Receiver  : " + hello);
	}

}