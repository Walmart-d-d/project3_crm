package com.ironhack.project_crm_2.classes.menus;
import com.ironhack.project_crm_2.classes.Utils;
import com.ironhack.project_crm_2.details.SalesRepInfo;
import com.ironhack.project_crm_2.models.SalesRep;
import com.ironhack.project_crm_2.services.SalesRepService;

import java.util.List;
import java.util.Scanner;

public class SalesRepMenu {
    private final Scanner INPUT = new Scanner(System.in);

    private final SalesRepService SALES_REP_SERVICE;

    public SalesRepMenu(SalesRepService SALES_REP_SERVICE) {
        this.SALES_REP_SERVICE = SALES_REP_SERVICE;
    }

    public void displaySalesRepMenuOptions() {
        System.out.println("1. Add sales representative");
        System.out.println("2. Show all sales representatives");
        System.out.println("3. Go back");
    }

    public void salesRepMenu() {
        while (true) {
            displaySalesRepMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice) {
                case "1": // add salesRep
                    addNewSalesRep();
                    System.out.println("New sales representative added");
                    break;
                case "2": // Show all sales repr
                    showSalesRep();
                    break;
                case "3": // Go back
                    return;
            }
        }
    }

    public SalesRep addNewSalesRep() {
        System.out.println("ADD NEW SALES REPRESENTATIVE");
        SalesRepInfo salesRepInfo = new SalesRepInfo(Utils.promptForString("Enter name: "));
        return SALES_REP_SERVICE.add(salesRepInfo);
    }

    public void showSalesRep() {
        List<SalesRep> allSalesRep = SALES_REP_SERVICE.getAll();
        if (allSalesRep.size() == 0) {
            System.out.println("Empty list");
        } else {
            for (SalesRep salesRep : allSalesRep) {
                System.out.println(salesRep.toString());
            }
        }
    }
}
