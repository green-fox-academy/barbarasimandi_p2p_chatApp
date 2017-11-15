package com.greenfox.barbi.p2pchatapp.controller;

import com.greenfox.barbi.p2pchatapp.exception.UserException;
import com.greenfox.barbi.p2pchatapp.model.ChatUser;
import com.greenfox.barbi.p2pchatapp.model.Log;
import com.greenfox.barbi.p2pchatapp.model.Message;
import com.greenfox.barbi.p2pchatapp.repository.ChatUserRepository;
import com.greenfox.barbi.p2pchatapp.repository.LogRepository;
import com.greenfox.barbi.p2pchatapp.repository.MessageRepository;
import com.greenfox.barbi.p2pchatapp.service.ChatUserService;
import com.greenfox.barbi.p2pchatapp.service.LogService;
import com.greenfox.barbi.p2pchatapp.service.MessageService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.size;

@Controller
public class MainController {

  @Autowired
  ChatUserService chatUserService;

  @Autowired
  LogRepository logRepository;

  @Autowired
  LogService logService;

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  MessageService messageService;

  @GetMapping(value = "/")
  public String index(Model model) {
    ChatUser first = chatUserService.findFirst();
    Iterable<Message> messages = messageRepository.findAll();

    if (size(chatUserService.getUsers()) != 0) {
      model.addAttribute("user", first);
      model.addAttribute("messages", messages);
      model.addAttribute("message", new Message());
      return "index";
    }
    else {
      return "redirect:/enter";
    }
  }

  @GetMapping(value = "/enter")
  public String enter(Model model) {
    model.addAttribute("noUserName", new UserException());
    model.addAttribute("newUser", new ChatUser());
    return "enter";
  }

  @PostMapping(value = "/save")
  public String enter(HttpServletRequest request, @ModelAttribute ChatUser chatUser) {
    logService.checkEnvironment(request);
    Log log = new Log(request);
    logRepository.save(log);

    if (chatUser.equals(null)) {
      return "redirect:/enter";
    }
    else {
      chatUserService.save(chatUser);
      return "redirect:/";
    }
  }

  @PostMapping(value = "/update")
  public String updateUser(@ModelAttribute ChatUser chatUser) {
    chatUserService.save(chatUser);
    return "redirect:/";
  }

  @PostMapping(value = "/newMessage")
  public String sendMessage(@ModelAttribute Message message) {
    messageRepository.save(new Message(chatUserService.findFirst().getUsername(), message.getText()));
    return "redirect:/";
  }
}
