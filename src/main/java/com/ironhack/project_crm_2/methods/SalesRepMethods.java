package com.ironhack.project_crm_2.methods;

import com.ironhack.project_crm_2.models.SalesRep;

import java.util.Map;
import java.util.Scanner;

public class SalesRepMethods {
    private static Scanner input = new Scanner (System.in);
    public static SalesRep createSalesRep(){
        System.out.println("Enter the name of the Sales Representative:");
        String name = input.nextLine();
        while (name.isEmpty()){
            System.err.println("Error. You must enter a name.");
            System.out.println("Please, enter the name of the Sales Representative:");
            name = input.nextLine();
        }
        return new SalesRep(name);
    }

    public static void showSalesRepMap(Map<Integer, SalesRep> salesRepMap){
        for (Map.Entry<Integer, SalesRep> salesRepMapEntry : salesRepMap.entrySet()){
            System.out.println(salesRepMapEntry.getValue());
        }
    }
}
