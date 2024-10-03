package com.scm.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import com.scm.scm.entities.User;
import com.scm.scm.forms.UserForm;
import com.scm.scm.services.UserService;



@Controller
public class MyController {

    @Autowired
    private UserService userService;

    // Home page
    @RequestMapping("home")
    public String home(Model model) {
        model.addAttribute("name", "Kartikey singh");
        model.addAttribute("leetcode", "https://leetcode.com/u/kartikey732/");
        return "home";
    }

    // about route
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin", true);
        System.out.println("About page loading");
        return "about";
    }
    
    //services route
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("Services page loading");
        return "services";
    }

    // contact page
    @RequestMapping("/contact")
    public String contactPage(){
        System.out.println("Contact page loading");
        return "contact";
    }
    
    // Login page
    @RequestMapping("/login")
    public String loginPage(){
        System.out.println("Login page loading");
        return "login";
    }

    //Register page
    @GetMapping("/register")
    public String registerPage(Model model){
        UserForm  userForm = new UserForm();
        // default data can also be given
        userForm.setName("kartikey");
        userForm.setAbout("This is kartikey");
        userForm.setPhoneNumber("6392471751");
        model.addAttribute("userForm", userForm);
        
        return "register";
    }

    //processing register 
    @RequestMapping(value = "/do-register", method=RequestMethod.POST)
    
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println(userForm);
        // fetch the form data
        // validate form data
        // save to database
        //   userService
        //userForm -> User
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://www.google.com/url?sa=i&url=https%3A%2F%2Farchive.org%2Fdetails%2Fwhatsapp-smiling-guy-i-accidentally-made&psig=AOvVaw2u_M3Sn5jxiZM-SCYZHuJ1&ust=1727982451358000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCYmLqy8IgDFQAAAAAdAAAAABAW")
        // .
        // build();
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setProfilePic("https://www.google.com/url?sa=i&url=https%3A%2F%2Farchive.org%2Fdetails%2Fwhatsapp-smiling-guy-i-accidentally-made&psig=AOvVaw2u_M3Sn5jxiZM-SCYZHuJ1&ust=1727982451358000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPCYmLqy8IgDFQAAAAAdAAAAABAW");


        User saveUser = userService.saveUser(user);
        System.out.println("User saved");
        // message = registration successfull
        // redirect

        return "redirect:/register";
    }

    
}
