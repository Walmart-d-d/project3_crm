package com.ironhack.project_crm_2.classes;

import com.ironhack.project_crm_2.details.LeadInfo;
import com.ironhack.project_crm_2.services.LeadService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class Menu {

    private final Scanner input = new Scanner(System.in);
    private final LeadService leadService;

    @Autowired
    public Menu(LeadService services) {
        this.leadService = services;
    }

    public void mainMenu(){
        boolean selectValidOption = false;


        while(!selectValidOption){
            try {
                String mainMenuOption = getInputMainMenu();
                manageOptionMainMenu(mainMenuOption);
                selectValidOption = true;
            } catch (InputMismatchException e) {
                System.err.println("Select a valid option");
            }
        }
    }

    public String getInputMainMenu() {
        List<String> validOptions = List.of("1", "2", "3", "4");

        System.out.println("1. Leads");
        System.out.println("2. Opportunities");
        System.out.println("3. Accounts");
        System.out.println("4. Exit");
        String option = input.nextLine();

        if(!validOptions.contains(option)) {
            throw new InputMismatchException("Invalid option");
        }
        return option;
    }

    public void manageOptionMainMenu(String option){
        switch (option) {
            case "1":
                leadMenu();
                break;
            case "2":
                //accountMenu(); --> opportunities
                System.out.println("oppMenu");
                break;
            case "3":
                //accounts
                break;
            case "4":
                System.exit(0);
                break;
        }
    }

    public void leadMenu(){
        boolean selectValidOption = false;

        while(!selectValidOption){
            try {
                String mainMenuOption = getInputLeadMenu();
                manageOptionLeadMenu(mainMenuOption);
                selectValidOption = true;
            } catch (InputMismatchException e) {
                System.err.println("Select a valid option");
            }
        }
    }

    public String getInputLeadMenu(){
        List<String> validOptions = List.of("1", "2", "3", "4", "5");

        System.out.println("1. Create Lead");
        System.out.println("2. Show all Leads");
        System.out.println("3. Show Lead by Identification Number");
        System.out.println("4. Convert Lead into Opportunity");
        System.out.println("5. Go back");
        String option = input.nextLine();

        if(!validOptions.contains(option)) {
            throw new InputMismatchException("Invalid option");
        }
        return option;
    }


    public void manageOptionLeadMenu(String option){

            Form form = new Form();

            switch (option) {
                case "1":
                    LeadInfo lead = form.readLeadInfo();
                    leadService.addLead(lead);
                    break;
                case "2":
                    leadService.showAllLeads();
                    break;
                case "3":
                    System.out.println("Show lead by id");
                    break;
                case "4":
                    System.out.println("Convert lead into opp");
                    break;
                case "5":
                    System.out.println("go back");
                    break;
            }
    }
}
