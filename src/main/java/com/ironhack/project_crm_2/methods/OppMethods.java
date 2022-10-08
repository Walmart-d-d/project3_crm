package com.ironhack.project_crm_2.methods;

import com.ironhack.project_crm_2.enums.OppStatus;
import com.ironhack.project_crm_2.enums.ProductType;
import com.ironhack.project_crm_2.models.Contact;
import com.ironhack.project_crm_2.models.Account;
import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.models.Opportunity;
import org.apache.commons.lang3.math.NumberUtils;
import com.ironhack.project_crm_2.methods.*;

import java.util.HashMap;
import java.util.Map;

public class OppMethods {

    protected Contact decisionMaker;
    protected Opportunity opportunity;
    protected Map<Integer, Opportunity> oppMap = new HashMap<>();

    public Lead getLeadToConvert(Map<Integer, Lead> leadMap) {
        System.out.println("Enter the identification number of the lead you want to convert:");
        String idString = input.nextLine();

        while (!NumberUtils.isParsable(idString)) {
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the identification number:");
            idString = input.nextLine();
        }
        int idInt = Integer.parseInt(idString);

        while (!leadMap.containsKey(idInt)) {
            System.err.println("Lead not found.");
            System.out.println("Enter the identification number of the lead you want to convert:");
            idString = input.nextLine();
            while (!NumberUtils.isParsable(idString)) {
                System.err.println("The identification must be a number.");
                System.out.println("Please, enter the identification number:");
                idString = input.nextLine();
            }
            idInt = Integer.parseInt(idString);
        }
        lead = leadMap.get(idInt);
        leadMap.remove(idInt);
        return lead;
    }

    public void createDecisionMaker(Lead lead){
        decisionMaker = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
    }

    public void createOpportunity(Map<Integer, Opportunity> oppMap) {
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
        String productKey = input.nextLine();
        ProductType productType = null;
        switch (productKey) {
            case "1":
                productType = ProductType.HYBRID;
                break;
            case "2":
                productType = ProductType.FLATBED;
                break;
            case "3":
                productType = ProductType.BOX;
                break;
            default:
                System.err.println("Invalid option.");
                createOpportunity(oppMap);
        }
        System.out.println("Number of products:");
        String numberOfProducts = input.nextLine();
        while (!NumberUtils.isParsable(numberOfProducts)) {
            System.err.println("The quantity must be written in numbers.");
            System.out.println("Please, enter the number of products:");
            numberOfProducts = input.nextLine();
        }
        int quantity = Integer.parseInt(numberOfProducts);
        OppStatus status = OppStatus.OPEN;
        opportunity = new Opportunity(productType, decisionMaker, quantity, status);
        oppMap.put(opportunity.getId(), opportunity);
        createAccount(accountMap);
    }

    public Opportunity createOppInAccount(Account account){
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
        String productKey = input.nextLine();
        ProductType productType = null;
        switch(productKey){
            case "1":
                productType = ProductType.HYBRID;
                break;
            case "2":
                productType = ProductType.FLATBED;
                break;
            case "3":
                productType = ProductType.BOX;
                break;
            default:
                System.err.println("Not a valid option.");
                createOppInAccount(account);
        }
        System.out.println("Number of products:");
        String numberOfProducts = input.nextLine();
        while (!NumberUtils.isParsable(numberOfProducts)) {
            System.err.println("Invalid value.");
            System.out.println("Please, enter the quantity of products in numbers:");
            numberOfProducts = input.nextLine();
        }
        int quantity = Integer.parseInt(numberOfProducts);
        OppStatus status = OppStatus.OPEN;
        opportunity = new Opportunity(productType, decisionMaker, quantity, status);
        oppMap.put(opportunity.getId(), opportunity);
        account.addContactList(decisionMaker);
        account.addOpportunityList(opportunity);
        return opportunity;
    }
    public void showAllOpportunities(){
        for(Map.Entry<Integer, Opportunity> opportunityEntry : oppMap.entrySet()){
            System.out.println(opportunityEntry.getValue());
        }
    }
    public void changeStatus(Map<Integer, Opportunity> oppMap) {
        System.out.println("Select opportunity by identification number:");
        String oppId = input.nextLine();
        while(!NumberUtils.isParsable(oppId)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the opportunity's identification number:");
            oppId = input.nextLine();
        }
        int oppIdInt = Integer.parseInt(oppId);
        if (!oppMap.containsKey(oppIdInt)) {
            System.err.println("Opportunity not found.");
            changeStatus(oppMap);
        }
        System.out.println("Choose new status:");
        System.out.println("1. OPEN");
        System.out.println("2. CLOSED_WON");
        System.out.println("3. CLOSED_LOST");
        String status = input.nextLine();
        switch (status) {
            case "1":
                oppMap.get(oppIdInt).setStatus(OppStatus.OPEN);
                break;
            case "2":
                oppMap.get(oppIdInt).setStatus(OppStatus.CLOSED_WON);
                break;
            case "3":
                oppMap.get(oppIdInt).setStatus(OppStatus.CLOSED_LOST);
                break;
            default:
                System.err.println("Please, enter a valid option.");
                changeStatus(oppMap);
        }
        System.out.println("New status is "+oppMap.get(oppIdInt).getStatus());
    }
}
