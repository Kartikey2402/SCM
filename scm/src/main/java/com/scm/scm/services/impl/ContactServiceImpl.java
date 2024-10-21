package com.scm.scm.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.scm.entities.Contacts;
import com.scm.scm.entities.User;
import com.scm.scm.helper.ResourceNotFoundException;
import com.scm.scm.repositories.ContactRepo;
import com.scm.scm.services.ContactServices;

@Service
public class ContactServiceImpl implements ContactServices{

    @Autowired
    private ContactRepo contactRepo;

    @Override
    public Contacts save(Contacts contacts) {
        String contactid = UUID.randomUUID().toString();
        contacts.setId(contactid);
        return contactRepo.save(contacts);
    }

    @Override
    public Contacts update(Contacts contacts) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Contacts> getAll() {
        return contactRepo.findAll();
    }

    @Override
    public Contacts getById(String id) {
        
        return contactRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact not found"));
    }

    @Override
    public void delete(String id) {
        var contact = contactRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact not found"));
        contactRepo.delete(contact);
        
    }

    @Override
    public List<Contacts> search(String name, String email, String phoneNumber) {
        
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Contacts> getByUserid(String userId) {
        
        return contactRepo.findByUserId(userId);
    }

    @Override
    public List<Contacts> getByUser(User user) {

        return contactRepo.findByUser(user);
    }

}
