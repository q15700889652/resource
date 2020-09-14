package com.example.demo;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.rabbitmq.produce.Sender;

@RunWith(value=SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitTests {
    
    @Autowired
    private Sender sender;
    
    @Test
    public void sendTest() throws Exception {
    		sender.send();
    }
}
