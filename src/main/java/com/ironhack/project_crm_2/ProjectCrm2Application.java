package com.ironhack.project_crm_2;

import com.ironhack.project_crm_2.classes.Menu;
import com.ironhack.project_crm_2.classes.Services;
import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.respositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;


@SpringBootApplication
public class ProjectCrm2Application implements CommandLineRunner {

	@Autowired
	LeadRepository leadRepository;


	public static void main(String[] args) {
		SpringApplication.run(ProjectCrm2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Services services = new Services(leadRepository);
		//Menu menu = new Menu(services);

		//menu.mainMenu();


	}
}
