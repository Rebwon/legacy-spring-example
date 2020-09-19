package com.rebwon.spring.web;

import com.rebwon.spring.domain.Account;
import com.rebwon.spring.service.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  @Autowired
  private AccountService accountService;

  @GetMapping("/sample")
  public String sample() {
    return "Hello MockMvc Test";
  }

  @GetMapping("/accounts")
  public List<Account> accounts() {
    return this.accountService.findAll();
  }
}
