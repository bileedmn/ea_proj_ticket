package edu.mum.controller;

import edu.mum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by: Ganbat Bayar
 * On: 12/17/2018
 * Project: Ticket_Booker
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(Model model) {
        return "user";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public ResponseEntity changePassword(@RequestParam("name") String name) {
        return userService.resetPassword(name);
    }
}
