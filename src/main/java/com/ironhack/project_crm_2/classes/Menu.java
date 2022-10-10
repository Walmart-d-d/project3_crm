package com.ironhack.project_crm_2.classes;

import com.ironhack.project_crm_2.details.AccountInfo;
import com.ironhack.project_crm_2.details.ContactInfo;
import com.ironhack.project_crm_2.details.LeadInfo;
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
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);
    private final LeadService leadService;
    private final ContactService contactService;
    private final AccountService accountService;

    @Autowired
    public Menu(LeadService leadService, ContactService contactService, AccountService accountService) {
        this.leadService = leadService;
        this.contactService = contactService;
        this.accountService = accountService;
    }

    public void mainMenu() {
        displayMainMenuOptions();
        while (true) {
            String choice = input.nextLine();
            switch (choice) {
                case "1":   // Display lead menu
                    leadMenu();
                    return;
                case "2":   // Display opportunities menu
                    return;
                case "3":   // Display accounts menu
                    //accounts
                    return;
                case "4":   // Exit
                    return;
            }
            System.err.println("Please select a valid option");
        }
    }

    private void displayMainMenuOptions() {
        System.out.println("1. Leads");
        System.out.println("2. Opportunities");
        System.out.println("3. Accounts");
        System.out.println("4. Exit");
    }

    private int promptForInt(String message) {
        System.out.print(message);
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (IllegalArgumentException e) {
                System.err.println("Must enter a valid integer.");
            }
        }
    }

    private int promptForPhoneNumber(String message) {
        System.out.print(message);
        while (true) {
            int phoneNumber = promptForInt("");
            if (phoneNumber > 0)
                return phoneNumber;
            System.err.println("Must enter a valid phone number.");
        }
    }

    private String promptForString(String message) {
        System.out.print(message);
        return input.nextLine();
    }

    private LeadInfo requestLeadInfo() {
        return new LeadInfo(
                promptForString("Introduce name: "),
                promptForPhoneNumber("Introduce telephone number: "),
                promptForString("Introduce email address: "),
                promptForString("Introduce the name of the company: ")
        );
    }

    public void leadMenu() {
        displayLeadMenu();
        while (true) {
            String choice = input.nextLine();
            switch (choice) {
                case "1": //Create lead
                    LeadInfo lead = requestLeadInfo();
                    leadService.addLead(lead);
                    return;
                case "2": //Show all leads
                    showLeads();
                    return;
                case "3": //show lead by id
                    showLeadById();
                    return;
                case "4": //Convert Lead into Opportunity
                    convertLeadIntoOpportunityMenu();
                    return;
                case "5":   // go back
                    return;
            }
            System.err.println("Select a valid option");
        }
    }


    private void showLeadById() {
        while (true) {
            int id = promptForInt("Enter a valid lead ID: ");
            try {
                Lead searchedLead = leadService.getById(id);
                System.out.println(searchedLead.toString());
                break;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void showLeads() {
        List<Lead> allLeads = leadService.getAll();
        for (Lead lead : allLeads) {
            System.out.println(lead.toString());
        }
    }

    private void displayLeadMenu() {
        System.out.println("1. Create Lead");
        System.out.println("2. Show all Leads");
        System.out.println("3. Show Lead by Identification Number");
        System.out.println("4. Convert Lead into Opportunity");
        System.out.println("5. Go back");
    }

    public ContactInfo getInfoLeadToConvert(){
        Lead leadToConvert = getLeadToConvert();
        return new ContactInfo(
                leadToConvert.getName(),
                leadToConvert.getPhoneNumber(),
                leadToConvert.getEmail(),
                leadToConvert.getCompanyName(),
                null);
    }

    public ProductType chooseProductType() {
        displayOpportunityTypeMenu();
        String typeChoice = input.nextLine();
        while(true) {
            switch (typeChoice) {
                case "1":
                    return ProductType.HYBRID;
                case "2":
                    return ProductType.FLATBED;
                case "3":
                    return ProductType.BOX;
            }
            System.err.println("Select a valid option");
        }
    }

    public Account requestAccountById(){
        while (true){
            int id = promptForInt("Enter account Id");
            try {
                Account selectedAccount = accountService.getById(id);
                System.out.println(selectedAccount.toString());
                return selectedAccount;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public Account selectAccountForOpportunity(){
        displayCreateOrAssociateAccountMenu();
        String choice = input.nextLine();
        while (true) {
            switch (choice) {
                case "1": //Create account
                    AccountInfo accountInfo = requestAccountInfo();
                    return accountService.createAccount(accountInfo);
                case "2":  //Select account by id
                    return requestAccountById();
                default:
                    System.err.println("Select a valid option");
            }
        }
    }

    public void displayIndustryOptionMenu(){
        System.out.println("Choose the company's sector:");
        System.out.println("1. Produce");
        System.out.println("2. E-Commerce");
        System.out.println("3. Manufacturing");
        System.out.println("4. Medical");
        System.out.println("5. Other");
    }

    public IndustryOption requestIndustryOption() {
        displayIndustryOptionMenu();
        while (true) {
            String choice = input.nextLine();
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
            System.err.println("Select a valid option");
        }
    }

    public AccountInfo requestAccountInfo() {
        return new AccountInfo(
                requestIndustryOption(),
                promptForInt("Number of employees: "),
                promptForString("City: "),
                promptForString("Number: ")
                );
        }


    public void convertLeadIntoOpportunityMenu() {
        ContactInfo contactInfo = getInfoLeadToConvert();
        Contact decisionMaker = contactService.createContact(contactInfo);
        ProductType productType = chooseProductType();
        int numProducts = promptForInt("Number of products:");
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
    public void displayOpportunityTypeMenu() {
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
    }

    public void displayCreateOrAssociateAccountMenu() {
        System.out.println("1. Create account");
        System.out.println("2. Associate to existent account");
    }


    public Lead getLeadToConvert() {
        while (true) {
            try {
                int id = promptForInt("Enter a valid lead ID: ");
                Lead leadToConvert = leadService.getById(id);
                System.out.println(leadToConvert.toString());
                return leadToConvert;
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
