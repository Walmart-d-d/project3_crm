package com.ironhack.project_crm_2.classes.menus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.project_crm_2.services.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class QueryMenu {
    private final Scanner INPUT = new Scanner(System.in);
    private final AccountService ACCOUNT_SERVICE;
    private final OpportunityService OPPORTUNITY_SERVICE;
    private final LeadService LEAD_SERVICE;
    private final ContactService CONTACT_SERVICE;
    private final SalesRepService SALES_REP_SERVICE;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    public QueryMenu(LeadService leadService, ContactService contactService,
                    AccountService accountService, OpportunityService opportunityService, SalesRepService salesRepService) {
        this.LEAD_SERVICE = leadService;
        this.CONTACT_SERVICE = contactService;
        this.ACCOUNT_SERVICE = accountService;
        this.OPPORTUNITY_SERVICE = opportunityService;
        this.SALES_REP_SERVICE = salesRepService;
    }



    private void queryMenuOptions() {
        System.out.println("1. Opportunities by product");
        System.out.println("2. Opportunities by country");
        System.out.println("3. Opportunities by city");
        System.out.println("4. Opportunities by account");
        System.out.println("5. Employee count");
        System.out.println("6. Quantity of products");
        System.out.println("7. Go back");
    }
    public void queryMenu() throws JsonProcessingException {
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
                oppByAccountMenu();
                break;
            case "5":
                averageEmployeeCountMenu();
                break;
            case "6":
                averageQuantityMenu();
                break;
            case "7":
                MainMenu mainMenu = new MainMenu(LEAD_SERVICE, CONTACT_SERVICE, ACCOUNT_SERVICE, OPPORTUNITY_SERVICE, SALES_REP_SERVICE);
                mainMenu.mainMenu();
                break;
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

    public void oppByProductMenu() throws JsonProcessingException {
        while(true){
        oppByProductMenuOptions();
        String choice = INPUT.nextLine();
        switch (choice){
            case "1":
                String body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppByProduct());
                System.out.println("===================================");
                System.out.println(body);
                System.out.println("===================================");
                break;
            case "2":
                body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppClosedWonByProduct());
                System.out.println("===================================");
                System.out.println(body);
                System.out.println("===================================");
                break;
            case "3":
                body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppClosedLostByProduct());
                System.out.println("===================================");
                System.out.println(body);
                System.out.println("===================================");
                break;
            case "4":
                body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppOpenByProduct());
                System.out.println("===================================");
                System.out.println(body);
                System.out.println("===================================");
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

    public void oppByCountryMenu() throws JsonProcessingException {
        while(true){
            oppByCountryMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice){
                case "1":
                    String body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppByCountry());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "2":
                    body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppClosedWonByCountry());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "3":
                    body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppClosedLostByCountry());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "4":
                    body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppOpenByCountry());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
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

    public void oppByCityMenu() throws JsonProcessingException {
        while(true){
            oppByCityMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice){
                case "1":
                    String body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppByCity());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "2":
                    body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppClosedWonByCity());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "3":
                    body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppClosedLostByCity());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "4":
                    body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.reportOppOpenByCity());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
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

    public void oppByAccountMenu() throws JsonProcessingException {
        while(true){
            oppByAccountMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice){
                case "1":
                    String body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.averageOppByAccount());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "2":
                    body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.maxOppByAccount());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "3":
                    body = objectMapper.writeValueAsString(OPPORTUNITY_SERVICE.minOppByAccount());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
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

    public void averageEmployeeCountMenu() throws JsonProcessingException {
        while(true){
            averageEmployeeCountMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice){
                case "1":
                    String body = objectMapper.writeValueAsString(ACCOUNT_SERVICE.averageEmployeeCountByAccount());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "2":
                    body = objectMapper.writeValueAsString(ACCOUNT_SERVICE.maxEmployeeCountByAccount());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "3":
                    body = objectMapper.writeValueAsString(ACCOUNT_SERVICE.minEmployeeCountByAccount());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
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
        System.out.println("1. Average amount of products");
        System.out.println("2. Biggest amount of products per account");
        System.out.println("3. Smallest quantity of products per account");
        System.out.println("4. Go back");
    }

    public void averageQuantityMenu() throws JsonProcessingException {
        while(true){
            averageQuantityMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice){
                case "1":
                    String body = objectMapper.writeValueAsString(ACCOUNT_SERVICE.averageQuantityByAccount());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "2":
                    body = objectMapper.writeValueAsString(ACCOUNT_SERVICE.maxQuantityByAccount());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
                    break;
                case "3":
                    body = objectMapper.writeValueAsString(ACCOUNT_SERVICE.minQuantityByAccount());
                    System.out.println("===================================");
                    System.out.println(body);
                    System.out.println("===================================");
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
