package com.rebwon.spring.repository;

import static org.junit.Assert.*;

import com.rebwon.spring.config.DataSourceConfig;
import com.rebwon.spring.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
public class JpaDaoTest {

  @Autowired
  private JpaDao jpaDao;

  @Test
  public void saveTests() {
    Account account = new Account();
    account.setEmail("msolo021015@gmail.com");
    jpaDao.save(account);
  }

  @Test
  public void findAllTests() {
    jpaDao.findAll();
  }
}