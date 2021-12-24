package com.ancient.currencyab.controllers;

import com.ancient.currencyab.feign.CurrencyFeign;
import com.ancient.currencyab.feign.GifFeign;
import com.ancient.currencyab.pojos.GifPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@RestController
public class MyRestController {
    GifFeign gifFeign;
    CurrencyFeign currencyFeign;

    public MyRestController(GifFeign gifFeign, CurrencyFeign currencyFeign) {
        this.gifFeign = gifFeign;
        this.currencyFeign = currencyFeign;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate yesterday = LocalDate.now().minusDays(1);
    String yesterdayForUrl = yesterday.format(formatter);

    @GetMapping("/api/get-gif-url")
    public String getGifUrl(@RequestParam(name = "cur") String cur){
        cur = cur.toUpperCase(Locale.ROOT);

        boolean rich = richOrBroke(findRes(currencyFeign.getCurrencyToday(), cur),
                findRes(currencyFeign.getCurrencyYesterday(yesterdayForUrl), cur));

        return getFinalUrl(rich);
    }

    public static double findRes(String body, String need){
        try {
            int begin = body.indexOf(need);
            int end = body.indexOf(",", begin);
            String res = body.substring(begin, end);
            String res2 = res.substring(res.indexOf(":") + 2);
            return Double.parseDouble(res2);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return 0;
    }

    public boolean richOrBroke(Double d1, Double d2){
        return d1 >= d2;
    }

    public String getFinalUrl(boolean rich){
        if(rich) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                GifPojo gifPojo = mapper.readValue(gifFeign.getRich(), GifPojo.class);
                return gifPojo.getData().getImage().getUrl().getFinUrl();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }else {
            try {
                ObjectMapper mapper = new ObjectMapper();
                GifPojo gifPojo = mapper.readValue(gifFeign.getBroke(), GifPojo.class);
                return gifPojo.getData().getImage().getUrl().getFinUrl();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "Something's wrong. Call mother...";
    }



}
