package com.ironhack.project_crm_2.details;

import com.ironhack.project_crm_2.enums.OppStatus;
import com.ironhack.project_crm_2.enums.ProductType;
import com.ironhack.project_crm_2.models.Account;
import com.ironhack.project_crm_2.models.Contact;
import com.ironhack.project_crm_2.models.SalesRep;

public class OpportunityInfo {
    public final ProductType productType;
    public final Contact decisionMaker;
    public final int quantity;
    public final OppStatus status;
    public final Account account;
    public final SalesRep salesRep;

    public OpportunityInfo(ProductType productType, Contact decisionMaker, int quantity, OppStatus status, Account account, SalesRep salesRep) {
        this.productType = productType;
        this.decisionMaker = decisionMaker;
        this.quantity = quantity;
        this.status = status;
        this.account = account;
        this.salesRep = salesRep;
    }
}
