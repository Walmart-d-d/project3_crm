package com.ironhack.project_crm_2.classes.menus;
import com.ironhack.project_crm_2.classes.Utils;
import com.ironhack.project_crm_2.details.LeadInfo;
import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.models.SalesRep;
import com.ironhack.project_crm_2.services.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LeadMenu {

    private final Scanner INPUT = new Scanner(System.in);
    private final LeadService LEAD_SERVICE;
    private final ContactService CONTACT_SERVICE;
    private final AccountService ACCOUNT_SERVICE;
    private final OpportunityService OPPORTUNITY_SERVICE;
    private final SalesRepService SALES_REP_SERVICE;

    @Autowired
    public LeadMenu(LeadService leadService, ContactService contactService, AccountService accountService,
                    OpportunityService opportunityService, SalesRepService salesRepService) {
        this.LEAD_SERVICE = leadService;
        this.CONTACT_SERVICE = contactService;
        this.ACCOUNT_SERVICE = accountService;
        this.OPPORTUNITY_SERVICE = opportunityService;
        this.SALES_REP_SERVICE = salesRepService;
    }

    private void displayLeadMenuOptions() {
        System.out.println("LEAD MENU");
        System.out.println("1. Create Lead");
        System.out.println("2. Show all Leads");
        System.out.println("3. Show Lead by Identification Number");
        System.out.println("4. Convert Lead into Opportunity");
        System.out.println("5. Go back");
    }

    public void leadMenu() {
        while (true) {
            displayLeadMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice) {
                case "1": //Create lead
                    LeadInfo leadInfo = requestLeadInfo();
                    Lead newLead = LEAD_SERVICE.add(leadInfo);
                    System.out.println("NEW LEAD CREATED:");
                    System.out.println(newLead.toString());
                    break;
                case "2": //Show all leads
                    showLeads();
                    break;
                case "3": //show lead by id
                    showById();
                    break;
                case "4": //Convert Lead into Opportunity
                    OpportunityMenu oppMenu = new OpportunityMenu(
                            LEAD_SERVICE, CONTACT_SERVICE, ACCOUNT_SERVICE,
                            OPPORTUNITY_SERVICE);
                    oppMenu.convertLeadIntoOpportunity();
                    break;
                case "5":   // go back
                    return;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }


    public LeadInfo requestLeadInfo() {
        return new LeadInfo(
                Utils.promptForString("Introduce name: "),
                Utils.promptForPhoneNumber("Introduce telephone number: "),
                Utils.promptForString("Introduce email address: "),
                Utils.promptForString("Introduce the name of the company: "),
                getSalesRep()
        );
    }


    public SalesRep getSalesRep() {
        SalesRepMenu salesRepMenu = new SalesRepMenu(SALES_REP_SERVICE);
        if (SALES_REP_SERVICE.isEmptyList()) {
            System.err.println("Sales representative list is empty.");
            return salesRepMenu.addNewSalesRep();
        } else {
            while(true) {
                int salesRepId = Utils.promptForInt("Select sales representative by Id: ");
                try {
                    return SALES_REP_SERVICE.getById(salesRepId);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


    public void showById() {
            int id = Utils.promptForInt("Enter a valid lead ID: ");
            try {
                Lead searchedLead = LEAD_SERVICE.getById(id);
                System.out.println(searchedLead.toString());
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }

    public void showLeads() {
        List<Lead> allLeads = LEAD_SERVICE.getAll();
        if (allLeads.size() == 0) {
            System.out.println("Empty list");
        } else {
            for (Lead lead : allLeads) {
                System.out.println(lead.toString());
            }
        }
    }

}
