package com.ironhack.project_crm_2.classes.menus;
import com.ironhack.project_crm_2.classes.Utils;
import com.ironhack.project_crm_2.details.AccountInfo;
import com.ironhack.project_crm_2.details.ContactInfo;
import com.ironhack.project_crm_2.enums.IndustryOption;
import com.ironhack.project_crm_2.models.Account;
import com.ironhack.project_crm_2.models.Contact;
import com.ironhack.project_crm_2.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AccountMenu {

    private final Scanner INPUT = new Scanner(System.in);
    private final ContactService CONTACT_SERVICE;
    private final AccountService ACCOUNT_SERVICE;

    @Autowired
    public AccountMenu(ContactService contactService, AccountService accountService) {
        this.CONTACT_SERVICE = contactService;
        this.ACCOUNT_SERVICE = accountService;
    }

    private void displayAccountMenuOptions() {
        System.out.println("ACCOUNT MENU");
        System.out.println("1. Create account");
        System.out.println("2. Show all accounts");
        System.out.println("3. Add new contact in account");
        System.out.println("4. Go back");
    }

    public void accountMenu(){
        while (true) {
            displayAccountMenuOptions();
            String choice = INPUT.nextLine();
            switch (choice) {
                case "1": //Create account
                    AccountInfo accountInfo = requestAccountInfo();
                    ACCOUNT_SERVICE.createAccount(accountInfo);
                    break;
                case "2": // Show all accounts
                    showAccounts();
                    break;
                case "3": //Add new contact in account
                    if(ACCOUNT_SERVICE.isEmptyList()) {
                        System.err.println("Account list is empty.");
                        return;
                    } else {
                        Account selectedAccount = requestAccountById();
                        ContactInfo contactInfo = requestContactInfo();
                        contactInfo.account = selectedAccount;
                        Contact newContact = CONTACT_SERVICE.createContact(contactInfo);
                        System.out.println(newContact.toString());
                    }
                    break;
                case "4": //Go back
                    return;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }

    public ContactInfo requestContactInfo(){
        System.out.println("CREATE NEW CONTACT");
        return new ContactInfo(
                Utils.promptForString("Name: "),
                Utils.promptForPhoneNumber("PhoneNumber: "),
                Utils.promptForString("Email: "),
                Utils.promptForString("Company name: "),
                null
        );
    }


    public Account requestAccountById(){
        while (true){
            int id = Utils.promptForInt("Enter account Id: ");
            try {
                return ACCOUNT_SERVICE.getById(id);
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void showAccounts(){
        List<Account> list = ACCOUNT_SERVICE.getAll();
        if (list.size() == 0) {
            System.out.println("Empty list");
        } else {
            for (Account account : list) {
                System.out.println(list.toString());
            }
        }
    }

    public AccountInfo requestAccountInfo() {
        System.out.println("CREATE NEW ACCOUNT");
        return new AccountInfo(
                requestIndustryOption(),
                Utils.promptForInt("Number of employees: "),
                Utils.promptForString("City: "),
                Utils.promptForString("Country: ")
        );
    }
    public Account createAccountByRequest(){
        AccountInfo accountInfo = requestAccountInfo();
        return ACCOUNT_SERVICE.createAccount(accountInfo);
    }

    public static void displayIndustryOptionMenu(){
        System.out.println("Choose the company's sector:");
        System.out.println("1. Produce");
        System.out.println("2. E-Commerce");
        System.out.println("3. Manufacturing");
        System.out.println("4. Medical");
        System.out.println("5. Other");
    }

    public IndustryOption requestIndustryOption() {
        displayIndustryOptionMenu();
        while (true) {
            String choice = INPUT.nextLine();
            switch (choice) {
                case "1":
                    return IndustryOption.PRODUCE;
                case "2":
                    return IndustryOption.ECOMMERCE;
                case "3":
                    return IndustryOption.MANUFACTURING;
                case "4":
                    return IndustryOption.MEDICAL;
                case "5":
                    return IndustryOption.OTHER;
                default:
                    System.err.println("Please select a valid option");
            }
        }
    }


}
