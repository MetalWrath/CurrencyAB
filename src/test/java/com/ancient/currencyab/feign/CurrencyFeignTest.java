package com.ancient.currencyab.feign;

import com.ancient.currencyab.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(CurrencyFeign.class)
class CurrencyFeignTest {

    @MockBean
    CurrencyFeign currencyFeign;

    @Test
    void getCurrencyToday() {
        when(currencyFeign.getCurrencyToday()).thenReturn("okey");
        String s = currencyFeign.getCurrencyToday();
        assertNotNull(s);
        assertEquals(s, "okey");
    }

    @Test
    void getCurrencyYesterday() {
        when(currencyFeign.getCurrencyYesterday("2021-12-23")).thenReturn("okey");
        String s = currencyFeign.getCurrencyYesterday("2021-12-23");
        assertNotNull(s);
        assertEquals(s, "okey");
    }
}