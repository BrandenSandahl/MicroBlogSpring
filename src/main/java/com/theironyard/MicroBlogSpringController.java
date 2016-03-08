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
        String userName = null;
        if (!session.isNew()) { //really strange behavior here. Why do i have to do this?
            userName = session.getAttribute("userName").toString();
        }
         ArrayList<Message> userMessagesList = new ArrayList<Message>();

        if (!messageList.isEmpty()) {
            for (Message m : messageList) {
                if (m.getUserName().equals(userName)) userMessagesList.add(m);
            }
        }
        model.addAttribute("userName", userName);
        model.addAttribute("messageList", userMessagesList);

        return "home";
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/createMessage", method = RequestMethod.POST)
    public String createMessage(HttpSession session, String messageText) {
        String userName = session.getAttribute("userName").toString();
        Message m = new Message(messageList.size() + 1 , messageText, userName);
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