package com.greenfox.barbi.p2pchatapp.controller;

import com.greenfox.barbi.p2pchatapp.model.ChatUser;
import com.greenfox.barbi.p2pchatapp.model.Log;
import com.greenfox.barbi.p2pchatapp.repository.ChatUserRepository;
import com.greenfox.barbi.p2pchatapp.repository.LogRepository;
import com.greenfox.barbi.p2pchatapp.service.ChatUserService;
import com.greenfox.barbi.p2pchatapp.service.LogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.size;

@Controller
public class MainController {

  @Autowired
  ChatUserRepository chatUserRepository;

  @Autowired
  ChatUserService chatUserService;

  @Autowired
  LogRepository logRepository;

  @Autowired
  LogService logService;

  @GetMapping(value = "/")
  public String index(Model model) {
    if (size(chatUserRepository.findAll()) != 0) {
      model.addAttribute("user", chatUserService.findFirst());
      return "index";
    }
    else {
      return "enter";
    }
  }

  @GetMapping(value = "/enter")
  public String enter() {
    return "enter";
  }

  @PostMapping(value = "/save")
  public String enter(HttpServletRequest request, @RequestParam String userName) {
    logService.checkEnvironment(request);
    Log log = new Log(request);
    logRepository.save(log);

    chatUserRepository.save(new ChatUser(userName));
    return "redirect:/";
  }

  @PostMapping(value = "/update")
  public String updateUser(@ModelAttribute ChatUser user) {
    chatUserRepository.save(user);
    return "redirect:/";
  }
}
