package com.ironhack.project_crm_2;

import com.ironhack.project_crm_2.classes.Menu;
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


	public static void main(String[] args) {
		SpringApplication.run(ProjectCrm2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*LeadService services = new LeadService(leadRepository);
		Menu menu = new Menu(services);

		menu.mainMenu();*/

	}
}
