package com.ivoronline.springboot_activemq_consumer_queue_multiple;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

@Configuration
public class Config {

  //=============================================================
  // CONNECTION FACTORY
  //=============================================================
  @Bean
  public ConnectionFactory connectionFactory(){
    ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
    activeMQConnectionFactory.setTrustedPackages(Arrays.asList("com.ivoronline.springboot_activemq_consumer"));
    return activeMQConnectionFactory;
  }

  //=============================================================
  // DEFAULT JMS LISTENER CONTAINER FACTORY
  //=============================================================
  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory());
    return factory;
  }

}
