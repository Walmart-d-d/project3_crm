package com.ironhack.project_crm_2.classes;

import com.ironhack.project_crm_2.details.LeadInfo;
import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.respositories.LeadRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTests {

    @Autowired
    LeadRepository leadRepository;

    @Test
    @DisplayName("Add new lead in db from lead info")
    void addLead_WorksOk(){
        Services services = new Services(leadRepository);
        LeadInfo leadInfo = new LeadInfo("Juan", 677898789, "Juan@email.com", "hbo");
        services.addLead(leadInfo);
        assertEquals("Juan", leadRepository.findByName("Juan").get(0).getName());
    }

   /* @Test
    @DisplayName("Add new lead into db")
    void addLeadIntoDB_WorksOk(){
        String userInput = String.format("Antonia%s669789987%santo@mail.com%sNetflix",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Optional<Lead> optionalLead = Optional.of(Services.addLeadIntoDB(leadRepository));
        Assertions.assertTrue(optionalLead.isPresent());
        Lead newLead = optionalLead.get();
        System.out.println(leadRepository);
        System.out.println(newLead.toString());
        assertEquals("Antonia", newLead.getName());
    }*/
}
