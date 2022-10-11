package com.ironhack.project_crm_2.classes;

import java.util.Scanner;

public class Utils {

    private static final Scanner INPUT = new Scanner(System.in);

    public static int promptForInt(String message) {
        System.out.print(message);
        while (true) {
            try {
                return Integer.parseInt(INPUT.nextLine());
            } catch (IllegalArgumentException e) {
                System.err.println("Must enter a valid integer.");
            }
        }
    }

    public static int promptForPhoneNumber(String message) {
        System.out.print(message);
        while (true) {
            int phoneNumber = Utils.promptForInt("");
            if (phoneNumber > 0)
                return phoneNumber;
            System.err.println("Must enter a valid phone number.");
        }
    }

    public static String promptForString(String message) {
        System.out.print(message);
        return INPUT.nextLine();
    }
}
