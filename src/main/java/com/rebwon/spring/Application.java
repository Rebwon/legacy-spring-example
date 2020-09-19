package com.rebwon.spring;

import java.io.File;
import java.nio.charset.StandardCharsets;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class Application {

  public static void main(String[] args) throws LifecycleException {
    Tomcat tomcat = new Tomcat();
    tomcat.setBaseDir("out/webapp");
    Connector connector = tomcat.getConnector();
    connector.setURIEncoding(StandardCharsets.UTF_8.displayName());

    tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
    tomcat.setPort(8080);
    tomcat.start();
    tomcat.getServer().await();
  }
}
