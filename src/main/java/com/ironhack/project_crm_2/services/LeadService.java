package com.ironhack.project_crm_2.services;

import com.ironhack.project_crm_2.classes.Utils;
import com.ironhack.project_crm_2.details.LeadInfo;
import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.respositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    private final LeadRepository leadRepository;
    @Autowired
    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead add(LeadInfo leadinfo){
        return leadRepository.save(new Lead(leadinfo.name, leadinfo.phoneNumber, leadinfo.email, leadinfo.companyName,
                leadinfo.salesRep));
    }

    public List<Lead> getAll(){
        return leadRepository.findAll();
    }

    public Lead getById(int id){
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if(optionalLead.isPresent()) {
            return optionalLead.get();
        } else {
            throw new IllegalArgumentException("Lead not found");
        }
    }

    public boolean isEmptyList() {
        return leadRepository.findAll().size() == 0;
    }

    public void delete(int id) {
        leadRepository.deleteById(id);
    }









}
