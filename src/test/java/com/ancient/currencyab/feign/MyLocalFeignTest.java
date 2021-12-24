package com.ancient.currencyab.feign;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(MyLocalFeign.class)
class MyLocalFeignTest {

    @MockBean
    MyLocalFeign myLocalFeign;


    @Test
    void getUrlFromApi() {
        when(myLocalFeign.getUrlFromApi("AMD")).thenReturn("ok");
        String s = myLocalFeign.getUrlFromApi("AMD");;
        assertNotNull(s);
        assertEquals(s, "ok");
    }
}