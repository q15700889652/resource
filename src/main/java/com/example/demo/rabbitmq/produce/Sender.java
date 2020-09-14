package com.example.demo.rabbitmq.produce;

import java.util.UUID;


import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender implements RabbitTemplate.ConfirmCallback {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send() {

		rabbitTemplate.setConfirmCallback(this);
		String msg = "callbackSender : i am callback sender";
		System.out.println(msg);
		for (int i = 0; i < 100; i++) {
			
	
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		System.out.println("callbackSender UUID: " + correlationData.getId());
		/**
		 * 存入数据库
		 */
		try {
			//key值绑定发送
			this.rabbitTemplate.convertAndSend("scorrtChange", "key.1", msg, correlationData);
		} catch (AmqpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			continue;
		}
		}
	}

	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		/**
		 * ack=true  删除数据库数据
		 * ack=false 修改数据库状态 
		 */
		// 这里的ack是Broker对发布者消息达到服务端的确认
		System.out.println("callbakck confirm: " + correlationData.getId() + " ACK : " + ack + " cause : "+ cause);
	}
}