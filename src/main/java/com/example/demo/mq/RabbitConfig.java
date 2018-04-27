package com.example.demo.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 定义配置类
 * @author ThinkPad
 * @Bean等同于<bean>,例如 <beans> <bean id="transferService"
 *                   class="com.acme.TransferServiceImpl"/> </beans>
 */
@Configuration
public class RabbitConfig {

	@Bean
	public Queue helloQueue() {
		return new Queue("hello12xscsc");
	}

}
