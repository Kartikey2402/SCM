package com.scm.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm.helper.Helper;



@Controller
@RequestMapping("/user")

public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //user dashboard

    @RequestMapping(value = "/dashBoard", method=RequestMethod.POST)
    public String userDashboard() {
        return "user/dashBoard";
    }

    //User profile page

    @RequestMapping(value = "/profile", method=RequestMethod.GET)
    public String userProfile(Authentication authentication) {
        
        String username = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User logged in:{} ", username);

        //database se user ko fetch kr skte hain
        return "user/profile";
    }
    

    //user add contact page

    //user view contacts

    //user edit contact

    // user delete contact

    // user search contact

}
