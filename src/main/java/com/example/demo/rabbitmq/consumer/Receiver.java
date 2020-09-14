/*
 * package com.example.demo.rabbitmq.consumer;
 * 
 * import org.springframework.amqp.rabbit.annotation.RabbitListener; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class Receiver {
 * 
 * @RabbitListener(queues = "hello.queue1") public void processMessage1(String
 * msg) { System.out.println(Thread.currentThread().getName() +
 * " 接收到来自hello.queue1队列的消息：" + msg); //return msg.toUpperCase(); } }
 */