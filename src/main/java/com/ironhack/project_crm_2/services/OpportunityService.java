package com.ironhack.project_crm_2.services;

import com.ironhack.project_crm_2.details.OpportunityInfo;
import com.ironhack.project_crm_2.models.Opportunity;
import com.ironhack.project_crm_2.respositories.LeadRepository;
import com.ironhack.project_crm_2.respositories.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityService {

    @Autowired
    private final OpportunityRepository oppRepository;

    public OpportunityService(OpportunityRepository oppRepository) {
        this.oppRepository = oppRepository;
    }

    Opportunity createOpportunity(OpportunityInfo opportunityInfo){
        return oppRepository.save(new Opportunity(
                opportunityInfo.productType,
                opportunityInfo.decisionMaker,
                opportunityInfo.quantity,
                opportunityInfo.status,
                opportunityInfo.account,
                opportunityInfo.salesRep));
            }



}
