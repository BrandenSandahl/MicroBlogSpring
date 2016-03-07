package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by branden on 3/7/16 at 12:56.
 */
@Controller
public class MicroBlogSpringController {

    ArrayList<Message> messageList = new ArrayList<Message>();



    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("userName", session.getAttribute("userName"));
        model.addAttribute("messageList", messageList);
        return "home";
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/createMessage", method = RequestMethod.POST)
    public String createMessage(String messageText) {
        Message m = new Message(messageList.size() + 1 , messageText);
        messageList.add(m);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/deleteMessage", method = RequestMethod.POST)
        public String deleteMessage(int messageId) {
        messageList.remove(messageId - 1);
        return "redirect:/";
    }


}