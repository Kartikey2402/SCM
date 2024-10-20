package com.scm.scm.services;

import java.util.List;

import com.scm.scm.entities.Contacts;

public interface ContactServices {

    //save contacts
    Contacts save(Contacts contacts);

    //update contacts
    Contacts update(Contacts contacts);

    //get contacts
    List<Contacts> getAll();

    //get contact by id
    Contacts getById(String id);

    // delete contact
    void delete(String id);

    //search contact
    List<Contacts> search(String name, String email, String phoneNumber);

    //get contacts by userid
    List<Contacts> getByUserid(String userid);
}
