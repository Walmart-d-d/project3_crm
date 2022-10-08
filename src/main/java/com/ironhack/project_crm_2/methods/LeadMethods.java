package com.ironhack.project_crm_2.methods;

import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.models.SalesRep;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeadMethods {
    protected Scanner input = new Scanner (System.in);
    protected int salesRepIdInt;
    protected Map<Integer, Lead> leadMap = new HashMap<>();
    protected Map<Integer, SalesRep> salesRepMap = new HashMap<>();

    public Map<String, String> getLeadInfo(){
        Map<String, String> leadInfo = new HashMap<>();

        System.out.println("Introduce name:");
        String name = input.nextLine();

        System.out.println("Introduce telephone number:");
        String phone = input.nextLine();
        while(!NumberUtils.isParsable(phone)){
            System.err.println("Must enter a phone number.");
            System.out.println("Please, introduce telephone number:");
            phone = input.nextLine();
        }

        System.out.println("Introduce email address:");
        String email = input.nextLine();

        System.out.println("Introduce the name of the company:");
        String companyName = input.nextLine();

        System.out.println("Introduce the identification number of the Sales Representative:");
        String salesRepId = input.nextLine();
        while (!NumberUtils.isParsable(salesRepId)) {
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the identification number of the Sales Representative:");
            salesRepId = input.nextLine();
        }
        salesRepIdInt = Integer.parseInt(salesRepId);

        while (!leadMap.containsKey(salesRepIdInt)) {
            System.err.println("Sales Representative not found.");
            System.out.println("Enter the identification number of the correct Sales Representative:");
            salesRepId = input.nextLine();
            while (!NumberUtils.isParsable(salesRepId)) {
                System.err.println("The identification must be a number.");
                System.out.println("Please, enter the identification number of the Sales Representative:");
                salesRepId = input.nextLine();
            }
            salesRepIdInt = Integer.parseInt(salesRepId);
        }

        leadInfo = Map.of(
                "name", name,
                "phone", phone,
                "email", email,
                "companyName", companyName
        );

        return leadInfo;
    }

    public Lead createLead(Map<String, String> leadInfo){
        return new Lead (leadInfo.get("name"), Integer.parseInt(leadInfo.get("phone")), leadInfo.get("email"), leadInfo.get("companyName"), salesRepMap.get(salesRepIdInt));
    }


    public void showLeadMap(){
        for(Map.Entry<Integer, Lead> leadEntry : leadMap.entrySet()){
            System.out.println(leadEntry.getValue());
        }
    }

    public void removeFromLeadMap(int idInt){
        leadMap.remove(idInt);
    }

    public void showLeadById() throws NoSuchFieldException {
        System.out.println("Enter the identification number of the Lead you want to see:"); //hay que hacer catch
        String idString = input.nextLine();
        while(!NumberUtils.isParsable(idString)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the lead identification number:");
            idString = input.nextLine();
        }
        int idInt = Integer.parseInt(idString);
        if (leadMap.containsKey(idInt)){
            System.out.println(leadMap.get(idInt));
        } else {
            throw new NoSuchFieldException("Lead does not exist.");
        }
    }


}
