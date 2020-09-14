
package com.example.demo.rabbitmq.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;



/**
 * 生产者ACK确认机制
 * 
 * @author Administrator
 *
 */
@Configuration
public class RabbitConfirmCallbackConfig {

	@Value("${spring.rabbitmq.host}")
	private String addresses;

	@Value("${spring.rabbitmq.port}")
	private String port;

	@Value("${spring.rabbitmq.username}")
	private String username;

	@Value("${spring.rabbitmq.password}")
	private String password;

	@Value("${spring.rabbitmq.virtual-host}")
	private String virtualHost;

	@Value("${spring.rabbitmq.publisher-confirms}")
	private boolean publisherConfirms;
	/**
	 * 连接配置
	 * 开启ack自动应答
	 * @author scorrt
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(addresses + ":" + port);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setVirtualHost(virtualHost);
		/** 如果要进行消息回调，则这里必须要设置为true */
		connectionFactory.setPublisherConfirms(publisherConfirms);
		return connectionFactory;
	}

	/**
	 * 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置
	 *
	 * @return
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)    //多列
	public RabbitTemplate rabbitTemplateNew() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		// 使用Confirm模式，关闭掉事务
		// template.setChannelTransacted(true);
		return template;
	}
}
