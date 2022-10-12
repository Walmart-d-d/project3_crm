package com.ironhack.project_crm_2.services;

import com.ironhack.project_crm_2.details.ContactInfo;
import com.ironhack.project_crm_2.models.Contact;
import com.ironhack.project_crm_2.respositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository CONTACT_REPOSITORY;
    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.CONTACT_REPOSITORY = contactRepository;
    }

    public Contact createContact(ContactInfo contactInfo){
        return CONTACT_REPOSITORY.save(new Contact(
                contactInfo.name,
                contactInfo.phoneNumber,
                contactInfo.email,
                contactInfo.companyName,
                contactInfo.account));
            }
    }
