package com.ironhack.project_crm_2.details;


import org.springframework.beans.factory.annotation.Autowired;

public class LeadInfo {

    public final String name;
    public final int phoneNumber;
    public final String email;
    public final String companyName;

    public LeadInfo(String name, int phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }
}
