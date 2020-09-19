package com.rebwon.spring.config;

import java.time.Duration;
import java.util.List;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ComponentScan({"com.rebwon.spring.web"})
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/images/**", "/css/**", "/js/**")
        .addResourceLocations("classpath:/static/images/", "classpath:/static/css/", "classpath:/static/js/")
        .setCacheControl(CacheControl.maxAge(Duration.ofDays(1)));
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    Jackson2ObjectMapperBuilder objectMapperBuilder = new Jackson2ObjectMapperBuilder()
        .indentOutput(true);
    converters.add(new MappingJackson2HttpMessageConverter(objectMapperBuilder.build()));
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.enableContentNegotiation(new MappingJackson2JsonView());
  }
}
