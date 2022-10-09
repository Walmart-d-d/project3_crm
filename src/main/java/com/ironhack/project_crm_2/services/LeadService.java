package com.ironhack.project_crm_2.services;

import com.ironhack.project_crm_2.details.LeadInfo;
import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.respositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    private final LeadRepository leadRepository;
    @Autowired
    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public void addLead(LeadInfo leadinfo){
        leadRepository.save(new Lead(leadinfo.name, leadinfo.phoneNumber, leadinfo.email, leadinfo.companyName));
    }

    public void showAllLeads(){
        List<Lead> allLeads = leadRepository.findAll();
        for (Lead lead: allLeads) {
            System.out.println(lead.toString());
        }
    }

    public void showLeadById(int id){
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if(optionalLead.isPresent()) {
            Lead searchedLead = optionalLead.get();
            System.out.println(searchedLead.toString());
        } else throw new IllegalArgumentException("Lead not found");
    }







}
