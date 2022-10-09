package com.ironhack.project_crm_2.methods;

import com.ironhack.project_crm_2.enums.IndustryOption;
import com.ironhack.project_crm_2.enums.OppStatus;
import com.ironhack.project_crm_2.enums.ProductType;
import com.ironhack.project_crm_2.models.Account;
import com.ironhack.project_crm_2.models.Contact;
import com.ironhack.project_crm_2.models.Opportunity;
import com.ironhack.project_crm_2.models.SalesRep;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

public class AccMethods {
    private static Scanner input = new Scanner (System.in);
    private static Account account;


    public static Account createAccount(Opportunity opportunity, Contact decisionMaker){
        System.out.println("Choose the company's sector:");
        System.out.println("1. Produce");
        System.out.println("2. E-Commerce");
        System.out.println("3. Manufacturing");
        System.out.println("4. Medical");
        System.out.println("5. Other");
        String industryKey = input.nextLine();
        IndustryOption industryOption = null;
        switch (industryKey){
            case "1":
                industryOption = IndustryOption.PRODUCE;
                break;
            case "2":
                industryOption = IndustryOption.ECOMMERCE;
                break;
            case "3":
                industryOption = IndustryOption.MANUFACTURING;
                break;
            case "4":
                industryOption = IndustryOption.MEDICAL;
                break;
            case "5":
                industryOption = IndustryOption.OTHER;
                break;
            default:
                System.err.println("Invalid option.");
                createAccount(opportunity, decisionMaker);
        }
        System.out.println("Number of employees:");
        String numEmployees = input.nextLine();
        while(!NumberUtils.isParsable(numEmployees) || numEmployees.isEmpty()){
            System.err.println("Must be a number.");
            System.out.println("Please, enter the number of employees in the company:");
            numEmployees = input.nextLine();
        }
        int employeeCount = Integer.parseInt(numEmployees);
        System.out.println("City:");
        String city = input.nextLine();
        while (city.isEmpty()){
            System.err.println("Must enter a city.");
            city = input.nextLine();
        }
        System.out.println("Country:");
        String country = input.nextLine();
        while (city.isEmpty()){
            System.err.println("Must enter a country.");
            city = input.nextLine();
        }
        List<Opportunity> oppList = new ArrayList<>();
        List<Contact> contactList = new ArrayList<>();
        contactList.add(decisionMaker);
        oppList.add(opportunity);
        account = new Account(industryOption, employeeCount, city, country, oppList, contactList);
        return account;
    }

    public static Account selectAccount(Map<Integer, Account> accountMap) throws NoSuchFieldException {
        if (accountMap.isEmpty()){
            System.err.println("There are currently no existing Accounts.");
            Menu.createOppMenu();
        }
        System.out.println("Enter the identification number of the company account this opportunity is attached to:");
        String idAccString = input.nextLine();
        while (!NumberUtils.isParsable(idAccString)) {
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            idAccString = input.nextLine();
        }
        int idAccInt = Integer.parseInt(idAccString);
        if (!accountMap.containsKey(idAccInt)) {
            System.err.println("Account not found.");
            selectAccount(accountMap);
        }
        account = accountMap.get(idAccInt);
        return account;
    }

    public static void showOpportunityList(Map<Integer, Account> accountMap) throws NoSuchFieldException {
        if (accountMap.isEmpty()){
            System.err.println("There are no existing Accounts at the moment");
            Menu.accountMenu();
        }
        System.out.println("Enter the identification number of the account you want to see the list of opportunities of:");
        String accString = input.nextLine();
        while(!NumberUtils.isParsable(accString)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            accString = input.nextLine();
        }
        int accInt = Integer.parseInt(accString);
        if (!accountMap.containsKey(accInt)){
            System.out.println("Account not found.");
            Menu.accountMenu();
        }
        account = accountMap.get(accInt);
        List<Opportunity> opportunityList = account.getOpportunityList();
        for (Opportunity opportunity : opportunityList) {
            System.out.println(opportunity.toString());
        }

    }
    public static void showContactList(Map<Integer, Account> accountMap) throws NoSuchFieldException {
        if (accountMap.isEmpty()){
            System.err.println("There are no existing Accounts at the moment");
            Menu.accountMenu();
        }
        System.out.println("Enter the identification number of the account you want to see the list of contacts of:");
        String accString = input.nextLine();
        while(!NumberUtils.isParsable(accString)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            accString = input.nextLine();
        }
        int accInt = Integer.parseInt(accString);
        if (!accountMap.containsKey(accInt)){
            System.out.println("Account not found.");
            Menu.accountMenu();
        }
        account = accountMap.get(accInt);
        List<Contact> contactList = account.getContactList();
        for (Contact contact : contactList) {
            System.out.println(contact.toString());
        }
    }
    public static void showAccounts(Map<Integer, Account> accountMap){
        if (accountMap.isEmpty()){
            System.out.println("There are no existing Accounts at the moment.");
        }
        for(Map.Entry<Integer, Account> accountEntry : accountMap.entrySet()){
            System.out.println(accountEntry.getValue());
        }
    }
}
