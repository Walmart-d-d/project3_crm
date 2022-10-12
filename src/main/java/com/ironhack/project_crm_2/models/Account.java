package com.ironhack.project_crm_2.models;



import com.ironhack.project_crm_2.enums.IndustryOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private IndustryOption industryOption;
    private int employeeCount;
    private String city;
    private String country;

    @OneToMany(mappedBy = "account")
    private List<Opportunity> opportunityList;

    @OneToMany(mappedBy = "account")
    private List<Contact> contactList;

    public Account() {
    }

    public Account(IndustryOption industryOption, int employeeCount, String city, String country) {
        setIndustryOption(industryOption);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
    }

    public Account(IndustryOption industryOption, int employeeCount, String city, String country, List<Opportunity> opportunityList, List<Contact> contactList) {
        setIndustryOption(industryOption);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        setOpportunityList(opportunityList);
        setContactList(contactList);
    }

    public int getId() {
        return id;
    }

    public IndustryOption getIndustryOption() {
        return industryOption;
    }

    public void setIndustryOption(IndustryOption industryOption) {
        this.industryOption = industryOption;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void addContactList(Contact contact){
        this.contactList.add(contact);
    }

    public void addOpportunityList(Opportunity opportunity){
        this.opportunityList.add(opportunity);
    }

    @Override
    public String toString() {
        return "Account " +this.getId()+":\n"+
                "Industry sector: " + this.getIndustryOption() +"\n"+
                "Employee count: " + this.getEmployeeCount() +"\n"+
                "City: " + this.getCity() + "\n"+
                "Country: " + this.getCountry() + "\n" +
                "==========================================";
    }
}
