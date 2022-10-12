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

    private final LeadRepository LEAD_REPOSITORY;
    @Autowired
    public LeadService(LeadRepository leadRepository) {
        this.LEAD_REPOSITORY = leadRepository;
    }

    public Lead add(LeadInfo leadinfo){
        return LEAD_REPOSITORY.save(new Lead(leadinfo.name, leadinfo.phoneNumber, leadinfo.email, leadinfo.companyName,
                leadinfo.salesRep));
    }

    public List<Lead> getAll(){
        return LEAD_REPOSITORY.findAll();
    }

    public Lead getById(int id){
        Optional<Lead> optionalLead = LEAD_REPOSITORY.findById(id);
        if(optionalLead.isPresent()) {
            return optionalLead.get();
        } else {
            throw new IllegalArgumentException("Lead not found");
        }
    }

    public boolean isEmptyList() {
        return LEAD_REPOSITORY.findAll().size() == 0;
    }

    public void delete(int id) {
        LEAD_REPOSITORY.deleteById(id);
    }









}
