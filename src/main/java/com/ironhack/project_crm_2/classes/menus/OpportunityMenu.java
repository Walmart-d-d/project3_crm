package com.ironhack.project_crm_2.classes.menus;

import com.ironhack.project_crm_2.classes.Utils;
import com.ironhack.project_crm_2.details.AccountInfo;
import com.ironhack.project_crm_2.details.ContactInfo;
import com.ironhack.project_crm_2.enums.IndustryOption;
import com.ironhack.project_crm_2.enums.ProductType;
import com.ironhack.project_crm_2.models.Account;
import com.ironhack.project_crm_2.models.Contact;
import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.services.AccountService;
import com.ironhack.project_crm_2.services.ContactService;
import com.ironhack.project_crm_2.services.LeadService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OpportunityMenu {

    private final Scanner INPUT = new Scanner(System.in);
    private final LeadService LEAD_SERVICE;
    private final ContactService CONTACT_SERVICE;
    private final AccountService ACCOUNT_SERVICE;

    @Autowired
    public OpportunityMenu(LeadService leadService, ContactService contactService, AccountService accountService) {
        this.LEAD_SERVICE = leadService;
        this.CONTACT_SERVICE = contactService;
        this.ACCOUNT_SERVICE = accountService;
    }

    public void convertLeadIntoOpportunityMenu() {
        ContactInfo contactInfo = getInfoLeadToConvert();
        Contact decisionMaker = CONTACT_SERVICE.createContact(contactInfo);
        ProductType productType = chooseProductType();
        int numProducts = Utils.promptForInt("Number of products:");
        Account account = selectAccountForOpportunity();
        //Asignar salesRep
        //AccountInfo selectAccount = selectAccountForOpportunity();


        //OPPORTUNITY-INFO
        // - Product Type,
        // - Contact decisionMaker
        // - quantitiy
        // - Account account
        // - SalesRep

        //OpportunityInfo opportunityInfo = new OpportunityInfo()
    }

    public Account selectAccountForOpportunity(){
        createOrAssociateAccountMenu();
        String choice = INPUT.nextLine();
        while (true) {
            switch (choice) {
                case "1": //Create account
                    AccountInfo accountInfo = requestAccountInfo();
                    return ACCOUNT_SERVICE.createAccount(accountInfo);
                case "2":  //Select account by id
                    return requestAccountById();
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }

    public Account requestAccountById(){
        while (true){
            int id = Utils.promptForInt("Enter account Id");
            try {
                Account selectedAccount = ACCOUNT_SERVICE.getById(id);
                System.out.println(selectedAccount.toString());
                return selectedAccount;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public AccountInfo requestAccountInfo() {
        return new AccountInfo(
                requestIndustryOption(),
                Utils.promptForInt("Number of employees: "),
                Utils.promptForString("City: "),
                Utils.promptForString("Number: ")
        );
    }

    public IndustryOption requestIndustryOption() {
        industryOptionMenu();
        while (true) {
            String choice = INPUT.nextLine();
            switch (choice) {
                case "1":
                    return IndustryOption.PRODUCE;
                case "2":
                    return IndustryOption.ECOMMERCE;
                case "3":
                    return IndustryOption.MANUFACTURING;
                case "4":
                    return IndustryOption.MEDICAL;
                case "5":
                    return IndustryOption.OTHER;
            }
            System.err.println("Please select a valid option");
        }
    }

    public ContactInfo getInfoLeadToConvert(){
        Lead leadToConvert = LEAD_SERVICE.getLeadToConvert();
        return new ContactInfo(
                leadToConvert.getName(),
                leadToConvert.getPhoneNumber(),
                leadToConvert.getEmail(),
                leadToConvert.getCompanyName(),
                null);
    }


    public ProductType chooseProductType() {
        opportunityTypeMenu();
        String typeChoice = INPUT.nextLine();
        while(true) {
            switch (typeChoice) {
                case "1":
                    return ProductType.HYBRID;
                case "2":
                    return ProductType.FLATBED;
                case "3":
                    return ProductType.BOX;
            }
            System.err.println("Please select a valid option");
        }
    }

    public static void industryOptionMenu(){
        System.out.println("Choose the company's sector:");
        System.out.println("1. Produce");
        System.out.println("2. E-Commerce");
        System.out.println("3. Manufacturing");
        System.out.println("4. Medical");
        System.out.println("5. Other");
    }

    public static void opportunityTypeMenu() {
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
    }

    public static void createOrAssociateAccountMenu() {
        System.out.println("1. Create account");
        System.out.println("2. Associate to existent account");
    }
}
