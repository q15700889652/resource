
package com.example.demo.rabbitmq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
/**
 * 队列声明
 * 交换机声明
 * 队列和交换机绑定
 * @author Administrator
 *
 */
@Configuration
public class RabbitConfig {

	// 声明队列

	@Bean
	public Queue queue1() {
		return new Queue("hello.queue1", true);
	}

	// 声明交互器

	@Bean
	DirectExchange dExchange() {
		return new DirectExchange("scorrtChange");
	}

	// 绑定

	@Bean
	public Binding binding1() {
		return BindingBuilder.bind(queue1()).to(dExchange()).with("key.1");
	}

}
