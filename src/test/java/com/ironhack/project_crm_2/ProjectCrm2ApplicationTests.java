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


	@Test
	void contextLoads() {
	}


}
