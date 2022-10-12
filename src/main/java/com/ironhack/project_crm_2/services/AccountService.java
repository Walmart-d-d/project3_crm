package com.ironhack.project_crm_2.services;

import com.ironhack.project_crm_2.classes.Utils;
import com.ironhack.project_crm_2.details.AccountInfo;
import com.ironhack.project_crm_2.models.Account;
import com.ironhack.project_crm_2.respositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.Optional;

public class AccountService {

    private final AccountRepository ACCOUNT_REPOSITORY;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.ACCOUNT_REPOSITORY = accountRepository;
    }

    public Account createAccount(AccountInfo info){
        return ACCOUNT_REPOSITORY.save(new Account(
                info.industryOption,
                info.employeeCount,
                info.city,
                info.country
        ));
    }


    public Account getById(int id){
        Optional<Account> optionalAccount = ACCOUNT_REPOSITORY.findById(id);
        if(optionalAccount.isPresent()) {
            return optionalAccount.get();
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }

    public boolean isEmptyList() {
        return ACCOUNT_REPOSITORY.findAll().size() == 0;
    }

    public Account requestAccountById(){
        while (true){
            int id = Utils.promptForInt("Enter account Id");
            try {
                return  getById(id);
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }


}
