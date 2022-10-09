package com.ironhack.project_crm_2.models;

import javax.persistence.*;

@Entity
public class Contact{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int phoneNumber;
    private String email;
    private String companyName;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Contact(String name, int phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    public Contact(String name, int phoneNumber, String email, String companyName, Account account) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
        setAccount(account);
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return  "-----\n"+
                "Contact " +this.getId()+": \n" +
                "Contact name: " + this.getName() + '\n' +
                "Telephone number: " + this.getPhoneNumber() + '\n'+
                "E-mail address: " + this.getEmail() + '\n' +
                "Company: " + this.getCompanyName() + '\n' +
                "-----";
    }
}
