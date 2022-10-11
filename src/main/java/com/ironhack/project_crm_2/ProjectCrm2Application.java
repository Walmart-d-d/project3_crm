package com.ironhack.project_crm_2;

import com.ironhack.project_crm_2.classes.menus.Menu;
import com.ironhack.project_crm_2.respositories.AccountRepository;
import com.ironhack.project_crm_2.respositories.ContactRepository;
import com.ironhack.project_crm_2.services.AccountService;
import com.ironhack.project_crm_2.services.ContactService;
import com.ironhack.project_crm_2.services.LeadService;
import com.ironhack.project_crm_2.respositories.LeadRepository;
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


	public static void main(String[] args) {
		SpringApplication.run(ProjectCrm2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LeadService leadService = new LeadService(leadRepository);
		ContactService contactService = new ContactService(contactRepository);
		AccountService accountService = new AccountService(accountRepository);
		Menu menu = new Menu(leadService, contactService, accountService);

		menu.mainMenu();

	}
}
