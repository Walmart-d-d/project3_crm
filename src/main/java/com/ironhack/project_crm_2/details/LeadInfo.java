package com.ironhack.project_crm_2.details;
import com.ironhack.project_crm_2.models.SalesRep;

public class LeadInfo {

    public String name;
    public int phoneNumber;
    public String email;
    public String companyName;
    public SalesRep salesRep;


    public LeadInfo(String name, int phoneNumber, String email, String companyName, SalesRep salesRep) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.salesRep = salesRep;
    }

    public LeadInfo(String name, int phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }
}
