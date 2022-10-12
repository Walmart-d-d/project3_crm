package com.ironhack.project_crm_2.services;

import com.ironhack.project_crm_2.details.OpportunityInfo;
import com.ironhack.project_crm_2.enums.OppStatus;
import com.ironhack.project_crm_2.models.Opportunity;
import com.ironhack.project_crm_2.respositories.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OpportunityService {

    @Autowired
    private final OpportunityRepository OPPORTUNITY_REPOSITORY;

    public OpportunityService(OpportunityRepository oppRepository) {
        this.OPPORTUNITY_REPOSITORY = oppRepository;
    }


    public Opportunity createOpportunity(OpportunityInfo opportunityInfo) {
        return OPPORTUNITY_REPOSITORY.save(new Opportunity(
                opportunityInfo.productType,
                opportunityInfo.decisionMaker,
                opportunityInfo.quantity,
                opportunityInfo.status,
                opportunityInfo.account,
                opportunityInfo.salesRep));
            }

    public List<Opportunity> getAll() {
        return OPPORTUNITY_REPOSITORY.findAll();
    }

    public Opportunity getById(int id){
        Optional<Opportunity> optionalOpportunity = OPPORTUNITY_REPOSITORY.findById(id);
        if(optionalOpportunity.isPresent()) {
            return optionalOpportunity.get();
        } else {
            throw new IllegalArgumentException("Opportunity not found");
        }
    }

    public Opportunity changeStatus(int id, OppStatus status){
        Optional<Opportunity> opportunityOptional = OPPORTUNITY_REPOSITORY.findById(id);

        if (opportunityOptional.isPresent()) {
            Opportunity opportunity = opportunityOptional.get();
            opportunity.setStatus(status);
            return OPPORTUNITY_REPOSITORY.save(opportunity);
        }
        else {
            throw new IllegalArgumentException("Opportunity not found");
        }
    }
}
