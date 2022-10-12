package com.ironhack.project_crm_2.services;

import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.models.SalesRep;
import com.ironhack.project_crm_2.respositories.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesRepService {

    @Autowired
    private final SalesRepRepository SALES_REP_REPOSITORY;

    public SalesRepService(SalesRepRepository SALES_REP_REPOSITORY) {
        this.SALES_REP_REPOSITORY = SALES_REP_REPOSITORY;
    }

    public SalesRep getById(int id){
        Optional<SalesRep> optionalSalesRep = SALES_REP_REPOSITORY.findById(id);
        if(optionalSalesRep.isPresent()) {
            return optionalSalesRep.get();
        } else {
            throw new IllegalArgumentException("Sales representative not found");
        }
    }




}
