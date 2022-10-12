package com.ironhack.project_crm_2.classes.menus;
import com.ironhack.project_crm_2.services.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class Menu {

    private final Scanner INPUT = new Scanner(System.in);
    private final LeadService LEAD_SERVICE;
    private final ContactService CONTACT_SERVICE;
    private final AccountService ACCOUNT_SERVICE;
    private final OpportunityService OPPORTUNITY_SERVICE;
    private final SalesRepService SALES_REP_SERVICE;

    @Autowired
    public Menu(LeadService leadService, ContactService contactService,
                AccountService accountService,  OpportunityService opportunityService, SalesRepService salesRepService) {
        this.LEAD_SERVICE = leadService;
        this.CONTACT_SERVICE = contactService;
        this.ACCOUNT_SERVICE = accountService;
        this.OPPORTUNITY_SERVICE = opportunityService;
        this.SALES_REP_SERVICE = salesRepService;
    }


    private static void mainMenuOptions() {
        System.out.println("1. Leads");
        System.out.println("2. Opportunities");
        System.out.println("3. Accounts");
        System.out.println("4. Exit");
    }

    public void mainMenu() {
        while (true) {
            mainMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice) {
                case "1":   // Display lead menu
                    LeadMenu menu = new LeadMenu(LEAD_SERVICE, CONTACT_SERVICE, ACCOUNT_SERVICE, OPPORTUNITY_SERVICE, SALES_REP_SERVICE);
                    menu.leadMenu();
                    break;
                case "2":   // Display opportunities menu
                    OpportunityMenu oppMenu = new OpportunityMenu(LEAD_SERVICE, CONTACT_SERVICE, ACCOUNT_SERVICE, OPPORTUNITY_SERVICE, SALES_REP_SERVICE);
                    oppMenu.oppMenu();
                    break;
                case "3":   // Display accounts menu
                    //accounts
                    return;
                case "4":   // Exit
                    System.exit(0);
                default:
                    System.err.println("Please select a valid option");;
            }

        }
    }

}
