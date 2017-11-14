package com.greenfox.barbi.p2pchatapp.controller;

import com.greenfox.barbi.p2pchatapp.exception.UserException;
import com.greenfox.barbi.p2pchatapp.model.ChatUser;
import com.greenfox.barbi.p2pchatapp.model.Log;
import com.greenfox.barbi.p2pchatapp.repository.ChatUserRepository;
import com.greenfox.barbi.p2pchatapp.repository.LogRepository;
import com.greenfox.barbi.p2pchatapp.service.LogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  ChatUserRepository chatUserRepository;

  @Autowired
  LogRepository logRepository;

  @Autowired
  LogService logService;

  @GetMapping(value = "/")
  public String index(@RequestParam(required = false) String userName, Model model) {
    if (userName != null) {
      model.addAttribute("user", chatUserRepository.findOne(userName));
      return "index";
    }
    else {
      return "redirect:/enter";
    }
  }

  @GetMapping(value = "/enter")
  public String enter() {
    return "enter";
  }

  @GetMapping(value = "/enter/user")
  public String enter(@RequestParam String userName, HttpServletRequest request, Model model) {
    logService.checkEnvironment(request);
    Log log = new Log(request);
    logRepository.save(log);

    if (chatUserRepository.findOne(userName) != null) {
      model.addAttribute("user", chatUserRepository.findOne(userName));
      return "redirect:/" + "?userName=" + userName;
    }

    if (!userName.equals("")) {
      ChatUser user = new ChatUser(userName);
      chatUserRepository.save(user);
    }
    else if (userName.equals("")){
      model.addAttribute("noUserName", new UserException());
    }
    return "enter";
  }

  @GetMapping(value = "/update")
  public String updateUser(@ModelAttribute ChatUser user) {
    chatUserRepository.save(user);
    return "redirect:/";
  }
}
