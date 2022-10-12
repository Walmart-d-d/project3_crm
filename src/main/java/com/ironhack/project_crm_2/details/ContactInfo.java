package com.ironhack.project_crm_2.details;

import com.ironhack.project_crm_2.models.Account;

public class ContactInfo {
    public int id;
    public String name;
    public int phoneNumber;
    public String email;
    public String companyName;
    public Account account;

    public ContactInfo(int id, String name, int phoneNumber, String email, String companyName, Account account) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.account = account;
    }

    public ContactInfo(String name, int phoneNumber, String email, String companyName, Account account) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.account = account;
    }
}
