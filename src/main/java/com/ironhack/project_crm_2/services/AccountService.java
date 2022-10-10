package com.ironhack.project_crm_2.services;

import com.ironhack.project_crm_2.details.AccountInfo;
import com.ironhack.project_crm_2.details.ContactInfo;
import com.ironhack.project_crm_2.models.Account;
import com.ironhack.project_crm_2.models.Contact;
import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.respositories.AccountRepository;
import com.ironhack.project_crm_2.respositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AccountService {

    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(AccountInfo info){
        return accountRepository.save(new Account(
                info.industryOption,
                info.employeeCount,
                info.city,
                info.country
        ));
    }

    public Account getById(int id){
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if(optionalAccount.isPresent()) {
            return optionalAccount.get();
        } else {
            throw new IllegalArgumentException("Lead not found");
        }
    }


}
