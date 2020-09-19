package com.rebwon.spring.service;

import com.rebwon.spring.domain.Account;
import com.rebwon.spring.repository.JpaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
  @Autowired
  private JpaDao jpaDao;

  @Transactional(readOnly = true)
  public List<Account> findAll() {
    return jpaDao.findAll();
  }
}
