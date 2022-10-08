package com.ironhack.project_crm_2.methods;

import com.ironhack.project_crm_2.enums.IndustryOption;
import com.ironhack.project_crm_2.models.Account;
import com.ironhack.project_crm_2.models.Contact;
import com.ironhack.project_crm_2.models.Opportunity;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccMethods {
    protected Map<Integer, Account> accountMap = new HashMap<>();
    protected Account account;


    public static void createAccount(Map<Integer, Account> accountMap){
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
                createAccount(accountMap);
        }
        System.out.println("Number of employees:");
        String numEmployees = input.nextLine();
        while(!NumberUtils.isParsable(numEmployees)){
            System.err.println("Must be a number.");
            System.out.println("Please, enter the number of employees in the company:");
            numEmployees = input.nextLine();
        }
        int employeeCount = Integer.parseInt(numEmployees);
        System.out.println("City:");
        String city = input.nextLine();
        System.out.println("Country:");
        String country = input.nextLine();
        List<Opportunity> oppList = new ArrayList<>();
        oppList.add(opportunity);
        List<Contact> contactList = new ArrayList<>();
        contactList.add(decisionMaker);
        Account account = new Account(industryOption, employeeCount, city, country, oppList, contactList);
        accountMap.put(account.getId(), account);
    }

    public static Account createOpportunityInAccount(Map<Integer, Account> accountMap){
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
            createOpportunityInAccount(accountMap);
        }
        account = accountMap.get(idAccInt);
        return account;
    }

    public static void showOpportunityList() throws NoSuchFieldException {
        System.out.println("Enter the identification number of the account you want to see the list of opportunities of:");
        String accString = input.nextLine();
        while(!NumberUtils.isParsable(accString)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            accString = input.nextLine();
        }
        int accInt = Integer.parseInt(accString);
        if(accountMap.containsKey(accInt)) {
            Account account = accountMap.get(accInt);
            List<Opportunity> opportunityList = account.getOpportunityList();
            for (Opportunity opportunity : opportunityList) {
                System.out.println(opportunity.toString());
            }
        }else{
            throw new NoSuchFieldException("Account not found.");
        }
    }
    public static void showContactList() throws NoSuchFieldException {
        System.out.println("Enter the identification number of the account you want to see the list of contacts of:");
        String accString = input.nextLine();
        while(!NumberUtils.isParsable(accString)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            accString = input.nextLine();
        }
        int accInt = Integer.parseInt(accString);
        if (accountMap.containsKey(accInt)) {
            Account account = accountMap.get(accInt);
            List<Contact> contactList = account.getContactList();
            for (Contact contact : contactList) {
                System.out.println(contact.toString());
            }
        }else{
            throw new NoSuchFieldException("Account not found.");
        }
    }
    public static void showAccounts(){
        for(Map.Entry<Integer, Account> accountEntry : accountMap.entrySet()){
            System.out.println(accountEntry.getValue());
        }
    }
}
