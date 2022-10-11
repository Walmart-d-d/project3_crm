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

    public void add(LeadInfo leadinfo){
        leadRepository.save(new Lead(leadinfo.name, leadinfo.phoneNumber, leadinfo.email, leadinfo.companyName));
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

    public void showById() {
        while (true) {
            int id = Utils.promptForInt("Enter a valid lead ID: ");
            try {
                Lead searchedLead = getById(id);
                System.out.println(searchedLead.toString());
                break;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void showLeads() {
        List<Lead> allLeads = getAll();
        for (Lead lead : allLeads) {
            System.out.println(lead.toString());
        }
    }

    public Lead getLeadToConvert() {
        while (true) {
            try {
                int id = Utils.promptForInt("Enter a valid lead ID: ");
                Lead leadToConvert = getById(id);
                System.out.println(leadToConvert.toString());
                return leadToConvert;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }









}
