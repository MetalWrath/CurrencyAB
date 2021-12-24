package com.ancient.currencyab.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(MyController.class)
class MyControllerTest {

    @MockBean
    MyController myController;



    @Test
    void getParametersFromCurrency() {
        when(myController.getParametersFromCurrency()).thenReturn(new ArrayList<>());
        ArrayList<String> testList1 = myController.getParametersFromCurrency();
        assertNotNull(testList1);
    }

    @Test
    void getCurrencyInDouble() {
        when(myController.getCurrencyInDouble("AMD")).thenReturn(new double[2]);
        double[] mass = myController.getCurrencyInDouble("AMD");
        assertEquals(mass.length, 2);
        assertNotNull(mass);
    }
}