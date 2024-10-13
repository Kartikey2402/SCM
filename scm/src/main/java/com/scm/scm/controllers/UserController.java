package com.scm.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/user")

public class UserController {

    //user dashboard

    @RequestMapping(value = "/dashBoard", method=RequestMethod.POST)
    public String userDashboard() {
        return "user/dashBoard";
    }

    //User profile page

    @RequestMapping(value = "/profile", method=RequestMethod.GET)
    public String userProfile() {
        return "user/profile";
    }
    

    //user add contact page

    //user view contacts

    //user edit contact

    // user delete contact

    // user search contact

}
