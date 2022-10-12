package com.ironhack.project_crm_2.classes.menus;

import com.ironhack.project_crm_2.classes.Utils;
import com.ironhack.project_crm_2.details.LeadInfo;
import com.ironhack.project_crm_2.services.*;
import org.springframework.beans.factory.annotation.Autowired;

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
        System.out.println("1. Create Lead");
        System.out.println("2. Show all Leads");
        System.out.println("3. Show Lead by Identification Number");
        System.out.println("4. Convert Lead into Opportunity");
        System.out.println("5. Go back");
    }

    public void leadMenu() {
        //displayLeadMenuOptions();
        while (true) {
            displayLeadMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice) {
                case "1": //Create lead
                    LeadInfo lead = requestLeadInfo();
                    LEAD_SERVICE.add(lead);
                    break;
                case "2": //Show all leads
                    LEAD_SERVICE.showLeads();
                    break;
                case "3": //show lead by id
                    LEAD_SERVICE.showById();
                    break;
                case "4": //Convert Lead into Opportunity
                    OpportunityMenu menu = new OpportunityMenu(
                            LEAD_SERVICE, CONTACT_SERVICE, ACCOUNT_SERVICE,
                            OPPORTUNITY_SERVICE, SALES_REP_SERVICE);
                    menu.convertLeadIntoOpportunity();
                    break;
                case "5":   // go back
                    return;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }

    private LeadInfo requestLeadInfo() {
        return new LeadInfo(
                Utils.promptForString("Introduce name: "),
                Utils.promptForPhoneNumber("Introduce telephone number: "),
                Utils.promptForString("Introduce email address: "),
                Utils.promptForString("Introduce the name of the company: ")
        );
    }
}
