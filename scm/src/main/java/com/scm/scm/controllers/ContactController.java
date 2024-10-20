package com.scm.scm.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.scm.scm.entities.Contacts;
import com.scm.scm.entities.User;
import com.scm.scm.forms.ContactForm;
import com.scm.scm.helper.Helper;
import com.scm.scm.helper.Message;
import com.scm.scm.helper.MessageType;
import com.scm.scm.services.ContactServices;
import com.scm.scm.services.ImageService;
import com.scm.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/user/contact")
public class ContactController {

    private Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactServices contactService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    // add contact page: handler
    @RequestMapping("/add")
    public String addContactView(Model model){

        ContactForm contactForm = new ContactForm();
        model.addAttribute("contactForm", contactForm);
        return "user/addContact";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String saveContact(@Valid @ModelAttribute ContactForm contactForm, BindingResult result, Authentication authentication, HttpSession session){


        //process the form data

        //validate form
        //this is validation logic
        
            if(result.hasErrors()){

                result.getAllErrors().forEach(error -> logger.info(error.toString()));
                session.setAttribute("message", Message.builder()
                .content("Please correct the following errors")
                .type(MessageType.red)
                .build());
                return "user/addContact";
            }

        String username = Helper.getEmailOfLoggedInUser(authentication);

        // form -> contact
        User user = userService.getUserByEmail(username);

        //processs the contaCT PICTURE
        
        //upload krne ka code
        String filename = UUID.randomUUID().toString();
        String fileURL = imageService.uploadImage(contactForm.getContactImage(), filename);

        Contacts contacts = new Contacts();
        contacts.setName(contactForm.getName());
        contacts.setFavourite(contactForm.isFavourite());
        contacts.setEmail(contactForm.getEmail());
        contacts.setAddress(contactForm.getAddress());
        contacts.setDescription(contactForm.getDescription());
        contacts.setPhoneNumber(contactForm.getPhoneNumber());
        contacts.setUser(user);
        contacts.setLinkedInLink(contactForm.getLinkedInLink());
        contacts.setWebsiteLink(contactForm.getWebsiteLink());
        contacts.setPicture(fileURL);
        contacts.setCloudinaryImagePublicId(filename);
        contactService.save(contacts);
        System.out.println(contactForm);

        //SET THE CONTACT PICTURE URL

        // SET THE MESSAGE FOR DISPLAY 
        session.setAttribute("message", Message.builder()
        .content("You have successfully added a new contact")
        .type(MessageType.green)
        .build());
        return "redirect:/user/contact/add";
    }

}
