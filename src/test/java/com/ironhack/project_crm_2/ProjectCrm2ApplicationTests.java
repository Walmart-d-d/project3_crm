package com.ironhack.project_crm_2;

import com.ironhack.project_crm_2.enums.IndustryOption;
import com.ironhack.project_crm_2.enums.OppStatus;
import com.ironhack.project_crm_2.enums.ProductType;
import com.ironhack.project_crm_2.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ProjectCrm2ApplicationTests {
	private Map<Integer, Lead> leadMap;
	private Map<Integer, Opportunity> oppMap;
	private Map<Integer, Opportunity> oppMap1;
	private Map<Integer, Account> accountMap;
	private Account account;
	private Account account1;
	private static Contact decisionMaker;

	@BeforeEach
	void setUp() {
		SalesRep salesRep1 = new SalesRep("Espe");
		Lead lead1 = new Lead("Maria", 678888999, "maria@email.com", "ironhack", 1);
		Lead lead2 = new Lead("Miguel", 668766787, "miguel@email.com", "toyota", 2);

		leadMap = Map.of(
				lead1.getId(), lead1,
				lead2.getId(), lead2
		);

		oppMap = new HashMap<>();
		oppMap1 = new HashMap<>();

		Contact contact = new Contact("Maria", 678888999, "maria@email.com", "ironhack",1);
		Opportunity opportunity = new Opportunity(ProductType.BOX, contact, 2, OppStatus.OPEN);
		oppMap1.put(opportunity.getId(), opportunity);

		Account newAccount = new Account(IndustryOption.ECOMMERCE, 2, "Madrid", "Spain", new ArrayList<>(), new ArrayList<>());
		account1 = newAccount;

		accountMap = new HashMap<>();
		accountMap.put(account1.getId(), account1);
		account = null;
		decisionMaker = null;
	}
	@Test
	void contextLoads() {
	}


}
