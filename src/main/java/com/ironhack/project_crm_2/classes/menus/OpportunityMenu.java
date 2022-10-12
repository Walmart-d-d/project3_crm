package com.ironhack.project_crm_2.classes.menus;
import com.ironhack.project_crm_2.classes.Utils;
import com.ironhack.project_crm_2.details.AccountInfo;
import com.ironhack.project_crm_2.details.ContactInfo;
import com.ironhack.project_crm_2.details.OpportunityInfo;
import com.ironhack.project_crm_2.enums.IndustryOption;
import com.ironhack.project_crm_2.enums.OppStatus;
import com.ironhack.project_crm_2.enums.ProductType;
import com.ironhack.project_crm_2.models.*;
import com.ironhack.project_crm_2.services.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OpportunityMenu {

    private final Scanner INPUT = new Scanner(System.in);
    private final LeadService LEAD_SERVICE;
    private final ContactService CONTACT_SERVICE;
    private final AccountService ACCOUNT_SERVICE;
    private final OpportunityService OPPORTUNITY_SERVICE;
    private final SalesRepService SALES_REP_SERVICE;

    @Autowired
    public OpportunityMenu(LeadService leadService, ContactService contactService, AccountService accountService,
                           OpportunityService opportunityService, SalesRepService salesRepService) {
        this.LEAD_SERVICE = leadService;
        this.CONTACT_SERVICE = contactService;
        this.ACCOUNT_SERVICE = accountService;
        this.OPPORTUNITY_SERVICE = opportunityService;
        this.SALES_REP_SERVICE = salesRepService;
    }

    public void convertLeadIntoOpportunity(){
        Lead leadToConvert = LEAD_SERVICE.getLeadToConvert();
        ContactInfo contactInfo = getInfoLeadToConvert(leadToConvert);
        Account account = selectAccountForOpportunity();
        contactInfo.account = account;
        Contact decisionMaker = CONTACT_SERVICE.createContact(contactInfo);
        OpportunityInfo opportunityInfo = getOpportunityInfo(decisionMaker, account);
        Opportunity newOpportunity = OPPORTUNITY_SERVICE.createOpportunity(opportunityInfo);
        LEAD_SERVICE.delete(leadToConvert.getId());
    }

    public OpportunityInfo getOpportunityInfo(Contact decisionMaker, Account account) {
        ProductType productType = chooseProductType();
        int numProducts = Utils.promptForInt("Number of products:");

        //Pending manage error if sales rep not found
        SalesRep salesRep = SALES_REP_SERVICE.getById(Utils.promptForInt("Select sales repr by Id"));

        return new OpportunityInfo(
                productType,
                decisionMaker,
                numProducts,
                OppStatus.OPEN,
                account,
                salesRep
            );
        }

    public Account selectAccountForOpportunity(){
        displayCreateOrAssociateAccountMenu();
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
        displayIndustryOptionMenu();
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

    public ContactInfo getInfoLeadToConvert(Lead lead){
        return new ContactInfo(
                lead.getId(),
                lead.getName(),
                lead.getPhoneNumber(),
                lead.getEmail(),
                lead.getCompanyName(),
                null);
        }


    public ProductType chooseProductType() {
        displayOpportunityTypeMenu();
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

    public static void displayIndustryOptionMenu(){
        System.out.println("Choose the company's sector:");
        System.out.println("1. Produce");
        System.out.println("2. E-Commerce");
        System.out.println("3. Manufacturing");
        System.out.println("4. Medical");
        System.out.println("5. Other");
    }

    public static void displayOpportunityTypeMenu() {
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
    }

    public static void displayCreateOrAssociateAccountMenu() {
        System.out.println("1. Create account");
        System.out.println("2. Associate to existent account");
    }
}
