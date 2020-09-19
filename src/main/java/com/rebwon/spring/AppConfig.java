package com.rebwon.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

@PropertySource({"classpath:application.properties"})
@Profile({"rebwon"})
@ComponentScan(basePackages = {"com.rebwon.spring.service"})
@Configuration
public class AppConfig {

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("messages");
    return messageSource;
  }

  @Bean
  public BasicService basicService() {
    return new BasicService();
  }
}
