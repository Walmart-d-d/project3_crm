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
import java.util.List;
import java.util.Scanner;

public class OpportunityMenu {

    private final Scanner INPUT = new Scanner(System.in);
    private final LeadService LEAD_SERVICE;
    private final ContactService CONTACT_SERVICE;
    private final AccountService ACCOUNT_SERVICE;
    private final OpportunityService OPPORTUNITY_SERVICE;

    @Autowired
    public OpportunityMenu(LeadService leadService, ContactService contactService, AccountService accountService,
                           OpportunityService opportunityService) {
        this.LEAD_SERVICE = leadService;
        this.CONTACT_SERVICE = contactService;
        this.ACCOUNT_SERVICE = accountService;
        this.OPPORTUNITY_SERVICE = opportunityService;
    }

    public void displayOpportunityMenu(){
        System.out.println("OPPORTUNITY MENU");
        System.out.println("1. Show opportunities");
        System.out.println("2. Change status of an opportunity");
        System.out.println("3. Go back");
    }


    public void oppMenu() {
        while (true) {
            displayOpportunityMenu();
            String choice = INPUT.nextLine();
            switch (choice) {
                case "1": //Show all opportunities
                    showOpportunities();
                    break ;
                case "2":  //Change status of an opportunity
                    try {
                        Opportunity opportunity = getOpportunityToUpdate();
                        updateOpportunityStatus(opportunity.getId());
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "3": // Go back
                    return;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }

    public void showOpportunities(){
        List<Opportunity> list = OPPORTUNITY_SERVICE.getAll();
        if (list.size() == 0) {
            System.out.println("Empty list");
        } else {
            for (Opportunity opportunity : list) {
                System.out.println(opportunity.toString());
            }
        }
    }

    public Opportunity getOpportunityToUpdate(){
        int id = Utils.promptForInt("Enter a valid opportunity ID: ");
        Opportunity opportunityToUpdate = OPPORTUNITY_SERVICE.getById(id);
        System.out.println(opportunityToUpdate.toString());
        return opportunityToUpdate;
    }

    public void displayOppStatus() {
        System.out.println("1. Open");
        System.out.println("2. Closed Won");
        System.out.println("3. Closed Lost");
    }


    public void updateOpportunityStatus(int opportunityId){
        displayOppStatus();
        String choice = INPUT.nextLine();
        while(true) {
            switch (choice) {
                case "1":
                   OPPORTUNITY_SERVICE.changeStatus(opportunityId, OppStatus.OPEN);
                   System.out.println("Opportunity updated");
                   return;
                case "2":
                    OPPORTUNITY_SERVICE.changeStatus(opportunityId, OppStatus.CLOSED_WON);
                    System.out.println("Opportunity updated");
                    return;
                case "3":
                    OPPORTUNITY_SERVICE.changeStatus(opportunityId, OppStatus.CLOSED_LOST);
                    System.out.println("Opportunity updated");
                    return;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }



    public void convertLeadIntoOpportunity() {
        if (LEAD_SERVICE.isEmptyList()) {
            System.err.println("Lead list is empty.");
        } else {
            Lead leadToConvert = getLeadToConvert();
            SalesRep salesRep = leadToConvert.getSalesRep();
            ContactInfo contactInfo = getInfoLeadToConvert(leadToConvert);
            Account account = selectAccountForOpportunity();
            contactInfo.account = account;
            Contact decisionMaker = CONTACT_SERVICE.createContact(contactInfo);
            OpportunityInfo opportunityInfo = getOpportunityInfo(decisionMaker, account, salesRep);
            OPPORTUNITY_SERVICE.createOpportunity(opportunityInfo);
            LEAD_SERVICE.delete(leadToConvert.getId());
        }
    }

    public Lead getLeadToConvert() {
            while (true) {
                try {
                    int id = Utils.promptForInt("Enter a valid lead ID: ");
                    Lead leadToConvert = LEAD_SERVICE.getById(id);
                    System.out.println(leadToConvert.toString());
                    return leadToConvert;
                } catch (IllegalArgumentException | InputMismatchException e) {
                    System.err.println(e.getMessage());
                }
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

    public OpportunityInfo getOpportunityInfo(Contact decisionMaker, Account account, SalesRep salesRep) {
        ProductType productType = chooseProductType();
        int numProducts = Utils.promptForInt("Number of products: ");

        return new OpportunityInfo(
                productType,
                decisionMaker,
                numProducts,
                OppStatus.OPEN,
                account,
                salesRep
            );
        }


    public static void displayCreateOrAssociateAccountMenu() {
        System.out.println("1. Create account");
        System.out.println("2. Associate to existent account");
    }


    public Account selectAccountForOpportunity(){
        AccountMenu accountMenu = new AccountMenu(CONTACT_SERVICE, ACCOUNT_SERVICE);
        displayCreateOrAssociateAccountMenu();
        String choice = INPUT.nextLine();
        while (true) {
            switch (choice) {
                case "1": //Create account
                   return accountMenu.createAccountByRequest();
                case "2":  //Select account by id
                    if(ACCOUNT_SERVICE.isEmptyList()) {
                        System.err.println("Account list is empty.");
                        return accountMenu.createAccountByRequest();
                    } else return accountMenu.requestAccountById();
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }

    public static void displayOpportunityTypeMenu() {
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
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
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }
}
