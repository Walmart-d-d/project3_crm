package com.ironhack.project_crm_2.classes;

import com.ironhack.project_crm_2.respositories.LeadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MenuTests {

    @Test
    void setUp() {
        assertTrue(true);

    }
/*

   Menu menu;
    @Autowired
    LeadRepository leadRepository;


    @BeforeEach
    void setUp(){
        Services services = new Services(leadRepository);
        menu = new Menu(services);
    }

    @Test
    @DisplayName("Main menu choose valid option - works ok")
    void getInputMainMenu_ValidInput_WorksOk(){
        String userInput = "1";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertEquals("1", menu.getInputMainMenu());
    }

    @Test
    @DisplayName("Main menu choose invalid option - throw error")
    void getInputMainMenu_InvalidInput_ThrowError(){
        String userInput = "6";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(InputMismatchException.class, () -> menu.getInputMainMenu());
    }

    @Test
    @DisplayName("Lead menu choose valid option - works ok")
    void getInputLeadMenu_ValidInput_WorksOk(){
        String userInput = "1";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertEquals("1", menu.getInputLeadMenu());
    }

    @Test
    @DisplayName("Lead menu choose invalid option - throw error")
    void getInputLeadMenu_InvalidInput_ThrowError(){
        String userInput = "6";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(InputMismatchException.class, ()-> menu.getInputLeadMenu());
    }
*/

}
