package com.ironhack.project_crm_2;

import com.ironhack.project_crm_2.classes.Menu;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectCrm2Application {

	public static void main(String[] args) {
		//SpringApplication.run(ProjectCrm2Application.class, args);

		Menu.mainMenu();
	}
}
