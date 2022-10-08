package com.ironhack.project_crm_2.classes;

import java.util.InputMismatchException;
import java.util.List;
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
        List<String> validOptions = List.of("1", "2", "3");

        System.out.println("1. Leads and opportunities");
        System.out.println("2. Accounts");
        System.out.println("3. Exit");
        String option = input.nextLine();

        if(!validOptions.contains(option)) {
            throw new InputMismatchException("Invalid option");
        }
        return option;
    }

    public static void manageOptionMainMenu(String option){
        switch (option) {
            case "1":
                //leadMenu();
                System.out.println("leadMenu");
                break;
            case "2":
                //accountMenu();
                System.out.println("accountMenu");
                break;
            case "3":
                System.exit(0);
                break;
        }
    }
}
