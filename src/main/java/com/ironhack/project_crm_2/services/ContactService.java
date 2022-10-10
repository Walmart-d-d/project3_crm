package com.ironhack.project_crm_2.services;

import com.ironhack.project_crm_2.details.ContactInfo;
import com.ironhack.project_crm_2.models.Contact;
import com.ironhack.project_crm_2.respositories.ContactRepository;
import com.ironhack.project_crm_2.respositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact createContact(ContactInfo contactInfo){
        return contactRepository.save(new Contact(
                contactInfo.name,
                contactInfo.phoneNumber,
                contactInfo.email,
                contactInfo.companyName,
                contactInfo.account));
            }
    }
