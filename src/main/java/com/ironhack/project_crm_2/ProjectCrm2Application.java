package com.ironhack.project_crm_2;

import com.ironhack.project_crm_2.classes.menus.Menu;
import com.ironhack.project_crm_2.respositories.*;
import com.ironhack.project_crm_2.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectCrm2Application implements CommandLineRunner {

	@Autowired
	LeadRepository leadRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	OpportunityRepository opportunityRepository;

	@Autowired
	SalesRepRepository salesRepRepository;



	public static void main(String[] args) {
		SpringApplication.run(ProjectCrm2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LeadService leadService = new LeadService(leadRepository);
		ContactService contactService = new ContactService(contactRepository);
		AccountService accountService = new AccountService(accountRepository);
		OpportunityService opportunityService = new OpportunityService(opportunityRepository);
		SalesRepService salesRepService = new SalesRepService(salesRepRepository);

		Menu menu = new Menu(leadService, contactService, accountService, opportunityService,  salesRepService);

		menu.mainMenu();

	}
}
