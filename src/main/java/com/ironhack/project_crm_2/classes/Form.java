package com.ironhack.project_crm_2.classes;

import com.ironhack.project_crm_2.details.LeadInfo;

import java.util.Scanner;

public class Form {

    private final Scanner input = new Scanner(System.in);

    public LeadInfo readLeadInfo() {
        boolean validPhoneNumber = false;

        System.out.println("Introduce name:");
        String name = input.nextLine();

        System.out.println("Introduce telephone number:");
        String phoneNumber = null;
        while(!validPhoneNumber) {
            try {
                phoneNumber = input.nextLine();
                validPhoneNumber = true;
            } catch(IllegalArgumentException e){
                System.err.println("Must enter a phone number.");
            }
        }

        System.out.println("Introduce email address:");
        String email = input.nextLine();

        System.out.println("Introduce the name of the company:");
        String companyName = input.nextLine();

        return new LeadInfo(name, Integer.parseInt(phoneNumber), email, companyName);

    }
}
