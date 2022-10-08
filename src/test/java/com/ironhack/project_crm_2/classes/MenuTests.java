package com.ironhack.project_crm_2.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTests {

    @Test
    @DisplayName("Main menu choose valid option - works ok")
    void getInputMainMenu_ValidInput_WorksOk(){
        String userInput = "1";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertEquals("1", Menu.getInputMainMenu());
    }

    @Test
    @DisplayName("Main menu choose invalid option - throw error")
    void getInputMainMenu_InvalidInput_ThrowError(){
        String userInput = "6";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(InputMismatchException.class, Menu::getInputMainMenu);
    }

    @Test
    @DisplayName("Lead menu choose valid option - works ok")
    void getInputLeadMenu_ValidInput_WorksOk(){
        String userInput = "1";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertEquals("1", Menu.getInputLeadMenu());
    }

    @Test
    @DisplayName("Lead menu choose invalid option - throw error")
    void getInputLeadMenu_InvalidInput_ThrowError(){
        String userInput = "6";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        assertThrows(InputMismatchException.class, Menu::getInputLeadMenu);
    }

}
