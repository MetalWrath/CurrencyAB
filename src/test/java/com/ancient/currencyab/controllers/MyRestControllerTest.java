package com.ancient.currencyab.controllers;

import com.ancient.currencyab.pojos.GifPojo;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(MyRestControllerTest.class)
class MyRestControllerTest {



    @MockBean
    MyRestController myRestController;


    @Test
    void getGifUrl() {
    when(myRestController.getGifUrl("AMD")).thenReturn("This is cool");
        String s = myRestController.getGifUrl("AMD");
        assertEquals(s, "This is cool");

    }

    @Test
    void findRes() {
        String partJson = "\"rates\": {\n" +
                "        \"AED\": 3.672934,\n" +
                "        \"AFN\": 95.889778,\n" +
                "        \"ALL\": 107.277494,\n" +
                "        \"AMD\": 483.27152,\n" +
                "        \"ANG\": 1.802446,\n" +
                "        \"AOA\": 585,\n" +
                "        \"ARS\": 100.99011,\n" +
                "        \"AUD\": 1.400119,\n" +
                "        \"AWG\": 1.80025,\n" +
                "        \"AZN\": 1.700805,\n" +
                "        \"BAM\": 1.734322,";

        assertEquals(MyRestController.findRes(partJson, "AMD"), 483.27152);
    }

    @Test
    void richOrBroke() {
        double a1 = 5, a2 = 10;
        boolean x = a1 >= a2;

        assertEquals(x, myRestController.richOrBroke(a1, a2));
    }

    @Test
    void getFinalUrl() {
    when(myRestController.getFinalUrl(true)).thenReturn("okey");
    String s = myRestController.getFinalUrl(true);
    assertEquals(s, "okey");

        when(myRestController.getFinalUrl(false)).thenReturn("okey");
        String s1 = myRestController.getFinalUrl(false);
        assertEquals(s, "okey");
    }
}