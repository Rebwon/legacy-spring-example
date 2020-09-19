package com.rebwon.spring;

import com.rebwon.spring.service.ConversionService;
import java.util.Locale;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Application {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    ConfigurableEnvironment environment = applicationContext.getEnvironment();
    environment.setActiveProfiles("rebwon");
    applicationContext.register(AppConfig.class);
    applicationContext.refresh();

    BasicService basicService = applicationContext.getBean(BasicService.class);
    ConversionService conversionService = applicationContext.getBean(ConversionService.class);
    String property = environment.getProperty("spring.application.name");
    String message = applicationContext
        .getMessage("argument.required", new Object[]{"rebwon"}, Locale.getDefault());
    System.out.println(message);
    System.out.println(property);
    System.out.println(basicService);
    System.out.println(conversionService);
  }
}
