package com.ironhack.project_crm_2.methods;

import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.methods.*;
import java.util.Map;

public class Menu {
    public void main(String[] args) throws NoSuchFieldException {
        mainMenu();
    }
    public void mainMenu() throws NoSuchFieldException {
        System.out.println("1. Leads and opportunities");
        System.out.println("2. Accounts");
        System.out.println("3. Exit");
        String option = input.nextLine();
        switch (option){
            case "1":
                leadMenu();
                break;
            case "2":
                accountMenu();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.err.println("Invalid option");
                System.out.println("Please, enter a valid option");
                mainMenu();
        }
    }
    public void leadMenu() throws NoSuchFieldException {
        System.out.println("1. Create Lead");
        System.out.println("2. Show all Leads");
        System.out.println("3. Show Lead by Identification Number");
        System.out.println("4. Show all Opportunities");
        System.out.println("5. Convert Lead into Opportunity");
        System.out.println("6. Change status of an Opportunity");
        System.out.println("7. Go back");
        String option = input.nextLine();
        switch (option){
            case "1":
                Map<String, String> leadInfo = getLeadInfo();
                Lead lead = createLead(leadInfo);
                leadMap.put(lead.getId(), lead);
                System.out.println("A new Lead has been created:");
                System.out.println(lead.toString());
                leadMenu();
                break;
            case "2":
                showLeadMap();
                leadMenu();
                break;
            case "3":
                showLeadById();
                leadMenu();
                break;
            case "4":
                showAllOpportunities();
                leadMenu();
                break;
            case "5":
                createOppMenu();
                break;
            case "6":
                changeStatus(oppMap);
                leadMenu();
                break;
            case "7":
                mainMenu();
                break;
            default:
                System.err.println("Invalid option");
                System.out.println("Please, enter a valid option");
                leadMenu();
        }
    }

    public void createOppMenu() throws NoSuchFieldException {
        System.out.println("1. Create a new Opportunity in a new Account");
        System.out.println("2. Show all Accounts");
        System.out.println("3. Create a new Opportunity in an existing Account");
        System.out.println("4. Go back");
        String option = input.nextLine();
        switch(option) {
            case "1":
                getLeadToConvert(leadMap);
                createDecisionMaker(lead);
                createOpportunity(oppMap);
                mainMenu();
                break;
            case "2":
                showAccounts();
                createOppMenu();
                break;
            case "3":
                getLeadToConvert(leadMap);
                createDecisionMaker(lead);
                createOpportunityInAccount(accountMap);
                createOppInAccount(account);
                mainMenu();
                break;
            case "4":
                leadMenu();
                break;
            default:
                System.err.println("Invalid option");
                System.out.println("Please, enter a valid option");
                createOppMenu();
        }
    }

    public void accountMenu() throws NoSuchFieldException {
        System.out.println("1. Show all Accounts");
        System.out.println("2. Show list of Opportunities in an Account");
        System.out.println("3. Show list of Contacts in an Account");
        System.out.println("4. Go back");
        String option = input.nextLine();
        switch (option){
            case "1":
                showAccounts();
                accountMenu();
                break;
            case "2":
                showOpportunityList();
                accountMenu();
                break;
            case "3":
                showContactList();
                accountMenu();
                break;
            case "4":
                mainMenu();
            default:
                System.err.println("Invalid option");
                System.out.println("Please, enter a valid option");
                accountMenu();
        }
    }

}
