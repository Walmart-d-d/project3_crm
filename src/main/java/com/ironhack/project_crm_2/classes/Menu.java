package com.ironhack.project_crm_2.classes;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static final Scanner input = new Scanner(System.in);

    public static void mainMenu(){
        boolean selectValidOption = false;

        while(!selectValidOption){
            try {
                String mainMenuOption = Menu.getInputMainMenu();
                Menu.manageOptionMainMenu(mainMenuOption);
                selectValidOption = true;
            } catch (InputMismatchException e) {
                System.err.println("Select a valid option");
            }
        }
    }

    public static String getInputMainMenu() {
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

    public static void manageOptionMainMenu(String option){
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

    public static void leadMenu(){
        boolean selectValidOption = false;

        while(!selectValidOption){
            try {
                String mainMenuOption = Menu.getInputLeadMenu();
                Menu.manageOptionLeadMenu(mainMenuOption);
                selectValidOption = true;
            } catch (InputMismatchException e) {
                System.err.println("Select a valid option");
            }
        }
    }

    public static String getInputLeadMenu(){
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

    public static void manageOptionLeadMenu(String option){
            switch (option) {
                case "1":
                    System.out.println("create lead");
                    break;
                case "2":
                    System.out.println("show leads");
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
