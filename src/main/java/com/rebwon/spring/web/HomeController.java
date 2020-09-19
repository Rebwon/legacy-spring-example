package com.rebwon.spring.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
  @GetMapping("/")
  public String home(Model model) throws Exception {
    model.addAttribute("message", "Hello Rebwon!");
    return "index";
  }

  @GetMapping("/json")
  @ResponseBody
  public Map<String, Object> json() throws IOException {
    Map<String, Object> body = new HashMap<>();
    body.put("message", "Hello Json!");
    return body;
  }
}
