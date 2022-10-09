package com.ironhack.project_crm_2.methods;

import com.ironhack.project_crm_2.models.*;
import com.ironhack.project_crm_2.methods.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static Map<Integer, Lead> leadMap = new HashMap<>();
    private static Map<Integer, SalesRep> salesRepMap = new HashMap();
    private static Scanner input = new Scanner (System.in);
    private static Map<Integer, Opportunity> oppMap = new HashMap<>();
    private static Contact decisionMaker;
    private static Map<Integer, Account> accountMap = new HashMap<>();
    private static SalesRep salesRep;
    private static Account account;
    private static Opportunity opportunity;
    private static Lead lead;
    public static void mainMenu() throws NoSuchFieldException {
        System.out.println("Main Menu");
        System.out.println("1. Sales Representatives");
        System.out.println("2. Leads and opportunities");
        System.out.println("3. Accounts");
        System.out.println("4. Exit");
        String option = input.nextLine();
        switch (option){
            case "1":
                salesRepMenu();
                break;
            case "2":
                leadMenu();
                break;
            case "3":
                accountMenu();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.err.println("Invalid option");
                System.out.println("Please, enter a valid option");
                mainMenu();
        }
    }

    public static void salesRepMenu() throws NoSuchFieldException {
        System.out.println("Sales Representatives");
        System.out.println("1. New Sales Representative");
        System.out.println("2. Show all Sales Representatives");
        System.out.println("3. Go back");
        String option = input.nextLine();
        switch (option){
            case "1":
                SalesRep salesRep = SalesRepMethods.createSalesRep();
                salesRepMap.put(salesRep.getId(), salesRep);
                System.out.println("A new Sales Representative has been created");
                System.out.println(salesRep);
                salesRepMenu();
                break;
            case "2":
                SalesRepMethods.showSalesRepMap(salesRepMap);
                if (salesRepMap.isEmpty()){
                    System.out.println("There are currently no Sales Representatives recorded.");
                }
                salesRepMenu();
                break;
            case "3":
                mainMenu();
                break;
            default:
                System.err.println("Invalid option");
                System.out.println("Please, enter a valid option");
                salesRepMenu();
        }
    }
    public static void leadMenu() throws NoSuchFieldException {
        System.out.println("1. New Lead");
        System.out.println("2. Show all Leads");
        System.out.println("3. Show Lead by Identification Number");
        System.out.println("4. Show all Opportunities");
        System.out.println("5. Convert Lead into Opportunity");
        System.out.println("6. Change status of an Opportunity");
        System.out.println("7. Go back");
        String option = input.nextLine();
        switch (option){
            case "1":
                Map<String, String> leadInfo = LeadMethods.getLeadInfo(leadMap, salesRepMap);
                Lead lead = LeadMethods.createLead(leadInfo, salesRepMap);
                leadMap.put(lead.getId(), lead);
                System.out.println("A new Lead has been created:");
                System.out.println(lead);
                leadMenu();
                break;
            case "2":
                LeadMethods.showLeadMap(leadMap);
                if (leadMap.isEmpty()){
                    System.out.println("There are currently no Leads recorded");
                }
                leadMenu();
                break;
            case "3":
                LeadMethods.showLeadById(leadMap);
                leadMenu();
                break;
            case "4":
                OppMethods.showAllOpportunities(oppMap);
                leadMenu();
                break;
            case "5":
                createOppMenu();
                break;
            case "6":
                OppMethods.changeStatus(oppMap);
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

    public static void createOppMenu() throws NoSuchFieldException {
        System.out.println("1. Create a new Opportunity in a new Account");
        System.out.println("2. Show all Accounts");
        System.out.println("3. Create a new Opportunity in an existing Account");
        System.out.println("4. Go back");
        String option = input.nextLine();
        switch(option) {
            case "1":
                lead = OppMethods.getLeadToConvert(leadMap);
                salesRep = lead.getSalesRep();
                decisionMaker = OppMethods.createDecisionMaker(lead);
                opportunity = OppMethods.createOpportunity(decisionMaker, salesRep);
                LeadMethods.removeFromLeadMap(lead.getId(), leadMap);
                account = AccMethods.createAccount(opportunity, decisionMaker);
                opportunity.setAccount(account);
                accountMap.put(account.getId(), account);
                oppMap.put(opportunity.getId(), opportunity);
                mainMenu();
                break;
            case "2":
                AccMethods.showAccounts(accountMap);
                createOppMenu();
                break;
            case "3":
                lead = OppMethods.getLeadToConvert(leadMap);
                salesRep = lead.getSalesRep();
                decisionMaker = OppMethods.createDecisionMaker(lead);
                account = AccMethods.selectAccount(accountMap);
                opportunity = OppMethods.createOppInAccount(account, decisionMaker, salesRep);
                oppMap.put(opportunity.getId(), opportunity);
                account.addContactList(decisionMaker);
                account.addOpportunityList(opportunity);
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

    public static void accountMenu() throws NoSuchFieldException {
        System.out.println("1. Show all Accounts");
        System.out.println("2. Show list of Opportunities in an Account");
        System.out.println("3. Show list of Contacts in an Account");
        System.out.println("4. Go back");
        String option = input.nextLine();
        switch (option){
            case "1":
                AccMethods.showAccounts(accountMap);
                accountMenu();
                break;
            case "2":
                AccMethods.showOpportunityList(accountMap);
                accountMenu();
                break;
            case "3":
                AccMethods.showContactList(accountMap);
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
