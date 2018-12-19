package edu.mum.controller;

import edu.mum.entity.UserCredentials;
import edu.mum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by: Ganbat Bayar
 * On: 12/17/2018
 * Project: Ticket_Booker
 */
@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
    public String PostLogin(UserCredentials credentials, Model model) {

        UserCredentials validCredentials = userService.getUser(credentials.getUsername());

        if (validCredentials == null)
            return "login";

        model.addAttribute("user", validCredentials.getMember());
        return "redirect:/user/user";
    }
}
