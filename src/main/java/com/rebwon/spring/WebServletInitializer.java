package com.rebwon.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    applicationContext.setConfigLocation("com.rebwon.spring.config");
    servletContext.addListener(new ContextLoaderListener(applicationContext));
    Dynamic dispatcher = servletContext
        .addServlet("dispatcher", new DispatcherServlet(applicationContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}
