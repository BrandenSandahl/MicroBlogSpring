package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


/**
 * Created by branden on 3/7/16 at 12:56.
 */
@Controller
public class MicroBlogSpringController {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;



    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        String userName = null;
        if (!session.isNew()) { //really strange behavior here. Why do i have to do this?
            userName = session.getAttribute("userName").toString();
        }

        model.addAttribute("userName", userName);
        model.addAttribute("messageList", messageRepository.findAll());

        return "home";
    }


    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        userRepository.save(new User(userName));
        return "redirect:/";
    }

    @RequestMapping(path = "/createMessage", method = RequestMethod.POST)
    public String createMessage(HttpSession session, String messageText) {
        String userName = session.getAttribute("userName").toString();
        Message m = new Message(messageText);
        messageRepository.save(m);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/editMessage", method = RequestMethod.POST)
    public String editMessage(int messageId, String editMessage) {
        Message m = messageRepository.findOne(messageId);
        m.setText(editMessage);
        messageRepository.save(m);
        return "redirect:/";
    }
    @RequestMapping(path = "/deleteMessage", method = RequestMethod.POST)
    public String deleteMessage(int messageId) {
        messageRepository.delete(messageId);

         return "redirect:/";
    }


}