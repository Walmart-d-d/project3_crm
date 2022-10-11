package com.ironhack.project_crm_2.classes;

import com.ironhack.project_crm_2.details.LeadInfo;
import com.ironhack.project_crm_2.models.Lead;
import com.ironhack.project_crm_2.respositories.LeadRepository;
import com.ironhack.project_crm_2.services.LeadService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class LeadServiceTests {

    @Autowired
    LeadRepository leadRepository;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private LeadService leadService;


    @BeforeEach
    public void setUp() {
       leadRepository.deleteAll();
       leadService = new LeadService(leadRepository);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


    @Test
    @DisplayName("Add new lead in db from lead info")
    void addLead_WorksOk(){
        LeadInfo leadInfo = new LeadInfo("Juan", 677898789, "Juan@email.com", "hbo");
        leadService.add(leadInfo);
        assertEquals("Juan", leadRepository.findByName("Juan").get(0).getName());
    }

    @Test
    @DisplayName("Get all leads from repository")
    void getAll_WorksOk(){
        Lead lead1 = new Lead ("Maria", 688345543, "maria@email.com", "netflix");
        Lead lead2 = new Lead ("Juan", 677898789, "Juan@email.com", "hbo");
        leadRepository.saveAll(List.of(lead1, lead2 ));

        assertEquals(2, leadService.getAll().size());

/*
        System.setOut(new PrintStream(outputStreamCaptor));
        String hibernateMsg = "Hibernate: select lead0_.lead_id as lead_id1_2_, lead0_.company_name as company_2_2_, " +
                "lead0_.email as email3_2_, lead0_.name as name4_2_, lead0_.phone_number as phone_nu5_2_, " +
                "lead0_.sales_rep_id as sales_re6_2_ from contact_lead lead0_";

        String expected = hibernateMsg + '\n'+ lead1.toString() + '\n'+ lead2.toString();*/


       /* assertEquals(expected, outputStreamCaptor.toString()
                .trim());;*/
    }

    @Test
    @DisplayName("Show Lead by invalid id - throw error")
    void showLeadById_InvalidId_ThrowError(){
        assertThrows(IllegalArgumentException.class, ()-> leadService.getById(5));
    }

    @Test
    @DisplayName("Show Lead by valid id - works ok")
    void showLeadById_validId_WorksOk(){
        Lead lead1 = new Lead ("Maria", 688345543, "maria@email.com", "netflix");
        Lead newLead = leadRepository.save(lead1);

        assertEquals("Maria", leadService.getById(newLead.getId()).getName());

       /* System.setOut(new PrintStream(outputStreamCaptor));
        String hibernateMsg = "Hibernate: select lead0_.lead_id as lead_id1_2_0_, " +
                "lead0_.company_name as company_2_2_0_, " +
                "lead0_.email as email3_2_0_, lead0_.name as name4_2_0_, " + "lead0_.phone_number as phone_nu5_2_0_, " +
                "lead0_.sales_rep_id as sales_re6_2_0_, " + "salesrep1_.id as id1_4_1_, salesrep1_.name as name2_4_1_ " +
                "from contact_lead lead0_ left outer join sales_rep salesrep1_ " +
                "on lead0_.sales_rep_id=salesrep1_.id where lead0_.lead_id=?";

        String expected = hibernateMsg + '\n'+ newLead.toString();*/


       /* assertEquals(expected, outputStreamCaptor.toString()
                .trim());;
*/
    }

}
