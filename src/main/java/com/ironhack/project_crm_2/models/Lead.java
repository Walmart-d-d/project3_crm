package com.ironhack.project_crm_2.models;

import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.*;

@Entity
@Table(name="contact_lead")
public class Lead{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leadId;
    private String name;
    private int phoneNumber;
    private String email;
    private String companyName;

    @ManyToOne
    @JoinColumn (name = "sales_rep_id")
    private SalesRep salesRep;

    public Lead() {
    }

    public Lead(String name, int phoneNumber, String email, String companyName, SalesRep salesRep) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
        setSalesRep(salesRep);
    }

    public Lead(String name, int phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    public int getId() {
        return leadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeadId() {
        return leadId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }


    @Override
    public String toString() {
        return "Lead " +this.getId()+": \n" +
                "Contact name: " + this.getName() + '\n' +
                "Telephone number: " + this.getPhoneNumber() + '\n'+
                "E-mail address: " + this.getEmail() + '\n' +
                "Company: " + this.getCompanyName() + '\n' +
                "Sales representative: " + this.getSalesRep().getName() + '\n' +
                "==========================================";
    }
}
