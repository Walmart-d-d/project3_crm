package com.ironhack.project_crm_2.classes.menus;

import com.ironhack.project_crm_2.services.AccountService;
import com.ironhack.project_crm_2.services.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class QueryMenu {
    private final Scanner INPUT = new Scanner(System.in);
    private final AccountService ACCOUNT_SERVICE;
    private final OpportunityService OPPORTUNITY_SERVICE;

    public QueryMenu(AccountService ACCOUNT_SERVICE, OpportunityService OPPORTUNITY_SERVICE) {
        this.ACCOUNT_SERVICE = ACCOUNT_SERVICE;
        this.OPPORTUNITY_SERVICE = OPPORTUNITY_SERVICE;
    }

    @Autowired


    private void queryMenuOptions() {
        System.out.println("1. Opportunities by product");
        System.out.println("2. Opportunities by country");
        System.out.println("3. Opportunities by city");
        System.out.println("4. Opportunities by account");
        System.out.println("5. Employee count");
        System.out.println("6. Quantity of products");
        System.out.println("7. Go back");
    }
    public void queryMenu(){
        while(true){
        queryMenuOptions();
        String choice = INPUT.nextLine();
        switch (choice){
            case "1":
                oppByProductMenu();
                break;
            case "2":
                oppByCountryMenu();
                break;
            case "3":
                oppByCityMenu();
                break;
            case "4":
                oppByAccountMenuOptions();
                break;
            case "5":
                averageEmployeeCountMenu();
                break;
            case "6":
                averageQuantityMenu();
                break;
            case "7":
                return;
            default:
                System.err.println("Please select a valid option");;
        }
    }
    }

    public void oppByProductMenuOptions(){
        System.out.println("1. All opportunities by product");
        System.out.println("2. Won opportunities by product");
        System.out.println("3. Lost opportunities by product");
        System.out.println("4. Open opportunities by product");
        System.out.println("5. Go back");
    }

    public void oppByProductMenu(){
        while(true){
        oppByProductMenuOptions();
        String choice = INPUT.nextLine();
        switch (choice){
            case "1":
                OPPORTUNITY_SERVICE.reportOppByProduct();
                break;
            case "2":
                OPPORTUNITY_SERVICE.reportOppClosedWonByProduct();
                break;
            case "3":
                OPPORTUNITY_SERVICE.reportOppClosedLostByProduct();
                break;
            case "4":
                OPPORTUNITY_SERVICE.reportOppOpenByProduct();
                break;
            case "5":
                queryMenu();
                break;
            default:
                System.err.println("Please select a valid option");
        }
        }
    }
    public void oppByCountryMenuOptions(){
        System.out.println("1. All opportunities by country");
        System.out.println("2. Won opportunities by country");
        System.out.println("3. Lost opportunities by country");
        System.out.println("4. Open opportunities by country");
        System.out.println("5. Go back");
    }

    public void oppByCountryMenu(){
        while(true){
            oppByCountryMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice){
                case "1":
                    OPPORTUNITY_SERVICE.reportOppByCountry();
                    break;
                case "2":
                    OPPORTUNITY_SERVICE.reportOppClosedWonByCountry();
                    break;
                case "3":
                    OPPORTUNITY_SERVICE.reportOppClosedLostByCountry();
                    break;
                case "4":
                    OPPORTUNITY_SERVICE.reportOppOpenByCountry();
                    break;
                case "5":
                    queryMenu();
                    break;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }
    public void oppByCityMenuOptions(){
        System.out.println("1. All opportunities by city");
        System.out.println("2. Won opportunities by city");
        System.out.println("3. Lost opportunities by city");
        System.out.println("4. Open opportunities by city");
        System.out.println("5. Go back");
    }

    public void oppByCityMenu(){
        while(true){
            oppByCityMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice){
                case "1":
                    OPPORTUNITY_SERVICE.reportOppByCity();
                    break;
                case "2":
                    OPPORTUNITY_SERVICE.reportOppClosedWonByCity();
                    break;
                case "3":
                    OPPORTUNITY_SERVICE.reportOppClosedLostByCity();
                    break;
                case "4":
                    OPPORTUNITY_SERVICE.reportOppOpenByCity();
                    break;
                case "5":
                    queryMenu();
                    break;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }
    public void oppByAccountMenuOptions(){
        System.out.println("1. Average amount of opportunities per account");
        System.out.println("2. Account with the biggest amount of opportunities");
        System.out.println("3. Account with the smallest amount of opportunities");
        System.out.println("4. Go back");
    }

    public void oppByAccountMenu(){
        while(true){
            oppByAccountMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice){
                case "1":
                    OPPORTUNITY_SERVICE.averageOppByAccount();
                    break;
                case "2":
                    OPPORTUNITY_SERVICE.maxOppByAccount();
                    break;
                case "3":
                    OPPORTUNITY_SERVICE.minOppByAccount();
                    break;
                case "4":
                    queryMenu();
                    break;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }
    public void averageEmployeeCountMenuOptions(){
        System.out.println("1. Average amount of employees");
        System.out.println("2. Account with the biggest amount of employees");
        System.out.println("3. Account with the smallest amount of employees");
        System.out.println("4. Go back");
    }

    public void averageEmployeeCountMenu(){
        while(true){
            averageEmployeeCountMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice){
                case "1":
                    ACCOUNT_SERVICE.averageEmployeeCountByAccount();
                    break;
                case "2":
                    ACCOUNT_SERVICE.maxEmployeeCountByAccount();
                    break;
                case "3":
                    ACCOUNT_SERVICE.minEmployeeCountByAccount();
                    break;
                case "4":
                    queryMenu();
                    break;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }
    public void averageQuantityMenuOptions(){
        System.out.println("1. Average amount of employees");
        System.out.println("2. Account with the biggest amount of employees");
        System.out.println("3. Account with the smallest amount of employees");
        System.out.println("4. Go back");
    }

    public void averageQuantityMenu(){
        while(true){
            averageQuantityMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice){
                case "1":
                    ACCOUNT_SERVICE.averageQuantityByAccount();
                    break;
                case "2":
                    ACCOUNT_SERVICE.maxQuantityByAccount();
                    break;
                case "3":
                    ACCOUNT_SERVICE.minQuantityByAccount();
                    break;
                case "4":
                    queryMenu();
                    break;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }
}
