package com.ironhack.project_crm_2.repositories;

import com.google.gson.Gson;
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
import com.ironhack.project_crm_2.services.OpportunityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OpportunityRepositoryTests {
   @Autowired
    OpportunityRepository opportunityRepository;
   @Autowired
   AccountRepository accountRepository;
   @Autowired
   ContactRepository contactRepository;
   @Autowired
   SalesRepRepository salesRepRepository;
   @Autowired
   OpportunityService opportunityService;

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
        Opportunity opp3 = new Opportunity(ProductType.FLATBED, contact3, 50, OppStatus.CLOSED_WON, account, salesRep);
        opportunityRepository.saveAll(List.of(opp1, opp2, opp3));



    }


    @Test
    @DisplayName("Show number of opportunities with each product")
    void reportOppByProduct_WorksOk() {
        List list = opportunityService.reportOppByProduct();
         Gson gson = new Gson();
            String json = gson.toJson(list);
            System.out.println(json);
    }
    @Test
    @DisplayName("Show number of opportunities with a status of CLOSED_WON")
    void reportOppClosedWonByProduct_WorksOk() {
        List list = opportunityService.reportOppClosedWonByProduct();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    @Test
    @DisplayName("Show number of opportunities with a status of CLOSED_LOST")
    void reportOppClosedLostByProduct_WorksOk() {
        List list = opportunityService.reportOppClosedLostByProduct();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    @Test
    @DisplayName("Show number of opportunities with a status of OPEN")
    void reportOppOpenByProduct_WorksOk() {
        List list = opportunityService.reportOppOpenByProduct();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    //peta
    @Test
    @DisplayName("Show number of opportunities per country")
    void reportOppByCountry_WorksOk() {
        List list = opportunityService.reportOppByCountry();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    //peta
    @Test
    @DisplayName("Show number of opportunities with a status of CLOSED_WON per country")
    void reportOppClosedWonByCountry_WorksOk() {
        List list = opportunityService.reportOppClosedWonByCountry();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    //peta
    @Test
    @DisplayName("Show number of opportunities with a status of CLOSED_LOST per country")
    void reportOppClosedLostByCountry_WorksOk() {
        List list = opportunityService.reportOppClosedLostByCountry();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    //peta
    @Test
    @DisplayName("Show number of opportunities with a status of OPEN per country")
    void reportOppOpenByCountry_WorksOk() {
        List list = opportunityService.reportOppOpenByCountry();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    @Test
    @DisplayName("Show number of opportunities per city")
    void reportOppByCity_WorksOk() {
        List list = opportunityService.reportOppByCity();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    @Test
    @DisplayName("Show number of opportunities with a status of CLOSED_WON per city")
    void reportOppClosedWonByCity_WorksOk() {
        List list = opportunityService.reportOppClosedWonByCity();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    @Test
    @DisplayName("Show number of opportunities with a status of CLOSED_LOST per city")
    void reportOppClosedLostByCity_WorksOk() {
        List list = opportunityService.reportOppClosedLostByCity();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    @Test
    @DisplayName("Show number of opportunities with a status of OPEN per city")
    void reportOppOpenByCity_WorksOk() {
        List list = opportunityService.reportOppOpenByCity();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    @Test
    @DisplayName("Show average number of opportunities per account")
    void averageOppByAccount_WorksOk() {
        List list = opportunityService.averageOppByAccount();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    @Test
    @DisplayName("Show maximum number of opportunities in an account")
    void maxOppByAccount_WorksOk() {
        List list = opportunityService.maxOppByAccount();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
    @Test
    @DisplayName("Show minimum number of opportunities in an account")
    void minOppByAccount_WorksOk() {
        List list = opportunityService.minOppByAccount();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}


