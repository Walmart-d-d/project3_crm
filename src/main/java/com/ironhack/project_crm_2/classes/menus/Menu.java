package com.ironhack.project_crm_2.classes.menus;
import com.ironhack.project_crm_2.services.AccountService;
import com.ironhack.project_crm_2.services.ContactService;
import com.ironhack.project_crm_2.services.LeadService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class Menu {

    private final Scanner INPUT = new Scanner(System.in);
    private final LeadService LEAD_SERVICE;
    private final ContactService CONTACT_SERVICE;
    private final AccountService ACCOUNT_SERVICE;

    @Autowired
    public Menu(LeadService leadService, ContactService contactService, AccountService accountService) {
        this.LEAD_SERVICE = leadService;
        this.CONTACT_SERVICE = contactService;
        this.ACCOUNT_SERVICE = accountService;
    }


    private static void mainMenuOptions() {
        System.out.println("1. Leads");
        System.out.println("2. Opportunities");
        System.out.println("3. Accounts");
        System.out.println("4. Exit");
    }

    public void mainMenu() {
        mainMenuOptions();
        while (true) {
            String choice = INPUT.nextLine();
            switch (choice) {
                case "1":   // Display lead menu
                    LeadMenu menu = new LeadMenu(LEAD_SERVICE, CONTACT_SERVICE, ACCOUNT_SERVICE);
                    menu.leadMenu();
                    return;
                case "2":   // Display opportunities menu
                    return;
                case "3":   // Display accounts menu
                    //accounts
                    return;
                case "4":   // Exit
                    return;
            }
            System.err.println("Please select a valid option");;
        }
    }

}
