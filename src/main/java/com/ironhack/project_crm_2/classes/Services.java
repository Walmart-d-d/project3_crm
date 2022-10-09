package com.ironhack.project_crm_2.classes;

import com.ironhack.project_crm_2.details.LeadInfo;
import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.respositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services {

    private final LeadRepository leadRepository;
    @Autowired
    public Services(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public void addLead(LeadInfo leadinfo){
        leadRepository.save(new Lead(leadinfo.name, leadinfo.phoneNumber, leadinfo.email, leadinfo.companyName));
    }







}
