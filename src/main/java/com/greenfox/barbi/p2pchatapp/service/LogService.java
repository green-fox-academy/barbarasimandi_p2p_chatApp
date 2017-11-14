package com.greenfox.barbi.p2pchatapp.service;

import com.greenfox.barbi.p2pchatapp.model.Log;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class LogService {

  public void checkEnvironment(HttpServletRequest request) {

   if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")) {
     System.out.println(new Log(request).toString());
    }
    else if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")) {
     System.err.println(new Log(request).toString());
   }
  }
}
