package com.ancient.currencyab.feign;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(GifFeign.class)
class GifFeignTest {

    @MockBean
    GifFeign gifFeign;


    @Test
    void getRich() {
        when(gifFeign.getRich()).thenReturn("ok");
        String s = gifFeign.getRich();
        assertNotNull(s);
        assertEquals(s, "ok");
    }

    @Test
    void getBroke() {
        when(gifFeign.getBroke()).thenReturn("ok");
        String s = gifFeign.getBroke();
        assertNotNull(s);
        assertEquals(s,"ok");
    }
}