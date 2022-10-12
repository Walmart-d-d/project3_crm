package com.ironhack.project_crm_2.services;
import com.ironhack.project_crm_2.details.AccountInfo;
import com.ironhack.project_crm_2.models.Account;
import com.ironhack.project_crm_2.respositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
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

    public List<Account> getAll() {
        return ACCOUNT_REPOSITORY.findAll();
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


}
