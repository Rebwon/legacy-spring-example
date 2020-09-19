package com.rebwon.spring.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource({"classpath:application.properties"})
@ComponentScan({
    "com.rebwon.spring.repository",
    "com.rebwon.spring.service"
})
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

  @Bean
  public DataSource dataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2)
        .build();
    return db;
  }

  /*@Bean(name = "dataSource")
  public DriverManagerDataSource dataSource(@Autowired Environment env) {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUrl(env.getProperty("database.url"));
    ds.setUsername(env.getProperty("database.username"));
    ds.setPassword(env.getProperty("database.password"));
    return ds;
  }*/

  @Bean(name = "sessionFactory")
  public SessionFactory sessionFactory() {
    LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
    builder.scanPackages("com.rebwon.spring.*").addProperties(hibernateProperties());
    return builder.buildSessionFactory();
  }

  private Properties hibernateProperties() {
    Properties prop = new Properties();

    prop.put("hibernate.format_sql", "true");
    prop.put("hibernate.hbm2ddl.auto", "create-drop");
    prop.put("hibernate.show_sql", "true");
    prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    return prop;
  }

  @Bean
  public HibernateTransactionManager txManager() {
    return new HibernateTransactionManager(sessionFactory());
  }
}
