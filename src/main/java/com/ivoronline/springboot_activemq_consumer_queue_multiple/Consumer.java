package com.ivoronline.springboot_activemq_consumer_queue_multiple;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class Consumer implements MessageListener {

  @Autowired Environment environment;

    @Override
    @JmsListener(destination = "Queue1")
    public void onMessage(Message message) {
      ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
      try {
        String port = environment.getProperty("server.port");
        System.out.println(port + " Received Message from Queue1: "+ textMessage.getText());
      } catch (JMSException e) {
        e.printStackTrace();
      }
    }

}


