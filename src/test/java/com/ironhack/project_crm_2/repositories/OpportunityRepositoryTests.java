package com.ironhack.project_crm_2.repositories;

import com.ironhack.project_crm_2.enums.IndustryOption;
import com.ironhack.project_crm_2.enums.OppStatus;
import com.ironhack.project_crm_2.enums.ProductType;
import com.ironhack.project_crm_2.models.Account;
import com.ironhack.project_crm_2.models.Contact;
import com.ironhack.project_crm_2.models.Opportunity;
import com.ironhack.project_crm_2.models.SalesRep;
import com.ironhack.project_crm_2.respositories.AccountRepository;
import com.ironhack.project_crm_2.respositories.ContactRepository;
import com.ironhack.project_crm_2.respositories.OpportunityRepository;
import com.ironhack.project_crm_2.respositories.SalesRepRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OpportunityRepositoryTests {
   @Autowired
    OpportunityRepository opportunityRepository;
   AccountRepository accountRepository;
   ContactRepository contactRepository;
   SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp(){
        opportunityRepository.deleteAll();
        accountRepository.deleteAll();
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();

        SalesRep salesRep = new SalesRep("Karl Franz");
        salesRepRepository.save(salesRep);
        Account account = new Account(IndustryOption.ECOMMERCE, 150, "Oakenhammer", "Karak Kadrin");
        accountRepository.save(account);
        Contact contact1 = new Contact("Joseph Bugman", 888999444, "bugman@gmail.com", "Bugman Beer Inc.", account);
        Contact contact2 = new Contact("Helman Ghorst", 888999446, "helman@gmail.com", "Bugman Beer Inc.", account);
        Contact contact3 = new Contact("Imrik", 888999445, "imrik@gmail.com", "Bugman Beer Inc.", account);
        contactRepository.saveAll(List.of(contact1, contact2, contact3));
        Opportunity opp1 = new Opportunity(ProductType.HYBRID, contact1, 100, OppStatus.OPEN, account, salesRep);
        Opportunity opp2 = new Opportunity(ProductType.HYBRID, contact2, 120, OppStatus.CLOSED_LOST, account, salesRep);
        Opportunity opp3 = new Opportunity(ProductType.FLATBED, contact3, 50, OppStatus.OPEN, account, salesRep);
        opportunityRepository.saveAll(List.of(opp1, opp2, opp3));




    }


    @Test
    @DisplayName("Show number of opportunities with each product")
    void reportOppByProduct_WorksOk(){
        opportunityRepository.reportOppbyProduct();
    }

}
