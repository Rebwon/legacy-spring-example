package com.rebwon.spring.repository;

import com.rebwon.spring.domain.Account;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaDao {
  @Autowired
  private SessionFactory sessionFactory;

  public List<Account> findAll() {
    return getSession().createQuery("select a from Account a", Account.class).getResultList();
  }

  public void save(Account account) {
    getSession().save(account);
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }
}
