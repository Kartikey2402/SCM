package com.scm.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm.entities.User;
import com.scm.scm.helper.Helper;
import com.scm.scm.services.UserService;



@Controller
@RequestMapping("/user")

public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    

    //user dashboard

    @RequestMapping(value = "/dashBoard")
    public String userDashboard() {
        return "user/dashBoard";
    }

    //User profile page

    @RequestMapping(value = "/profile")
    public String userProfile(Model model,Authentication authentication) {
        
        return "user/profile";
    }
    

    //user add contact page

    //user view contacts

    //user edit contact

    // user delete contact

    // user search contact

}
