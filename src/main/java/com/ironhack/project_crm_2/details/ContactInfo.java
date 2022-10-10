package com.ironhack.project_crm_2.details;

import com.ironhack.project_crm_2.models.Account;

public class ContactInfo {
    public final String name;
    public final int phoneNumber;
    public final String email;
    public String companyName;
    public final Account account;

    public ContactInfo(String name, int phoneNumber, String email, String companyName, Account account) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.account = account;
    }
}
