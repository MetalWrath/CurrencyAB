package com.ancient.currencyab.controllers;

import com.ancient.currencyab.feign.CurrencyFeign;
import com.ancient.currencyab.feign.GifFeign;
import com.ancient.currencyab.feign.MyLocalFeign;
import com.ancient.currencyab.pojos.CurrencyPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class MyController {

    MyLocalFeign myLocalFeign;
    CurrencyFeign currencyFeign;
    GifFeign gifFeign;

    public MyController(MyLocalFeign myLocalFeign, CurrencyFeign currencyFeign, GifFeign gifFeign) {
        this.myLocalFeign = myLocalFeign;
        this.currencyFeign = currencyFeign;
        this.gifFeign = gifFeign;
    }

    @GetMapping("/")
    public String index(Model model) {
        ArrayList<String> oprionals = getParametersFromCurrency();
        model.addAttribute("optionals", oprionals);

        return "index";
    }

    @GetMapping("/just-take-url")
    public String justTakeUrl(@RequestParam("cur") String cur, Model model) {
        String res = myLocalFeign.getUrlFromApi(cur);
        double[] values = getCurrencyInDouble(cur);
        double curToday = values[0];
        double curYesterday = values[1];


        model.addAttribute("url", res);
        model.addAttribute("curToday", curToday);
        model.addAttribute("curYesterday", curYesterday);
        model.addAttribute("cur", cur);


        return "justtakeurl";
    }

    @PostMapping("/")
    public String getUrl(@RequestParam(name = "cur") String cur) {
        return "redirect:" + myLocalFeign.getUrlFromApi(cur);
    }

    public ArrayList<String> getParametersFromCurrency() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            CurrencyPojo currencyPojo = mapper.readValue(currencyFeign.getCurrencyToday(), CurrencyPojo.class);
            Map<String, Double> tempMap = currencyPojo.getRates();
            return new ArrayList<>(tempMap.keySet());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public double[] getCurrencyInDouble(String cur){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate yesterday = LocalDate.now().minusDays(1);
        String yesterdayForUrl = yesterday.format(formatter);
        double[] result = new double[2];

        try{
            ObjectMapper mapper = new ObjectMapper();
            CurrencyPojo currencyPojoToday = mapper.readValue(currencyFeign.getCurrencyToday(), CurrencyPojo.class);
            CurrencyPojo currencyPojoYesterday =
                    mapper.readValue(currencyFeign.getCurrencyYesterday(yesterdayForUrl), CurrencyPojo.class);
            result[0] = currencyPojoToday.getRates().get(cur);
            result[1] = currencyPojoYesterday.getRates().get(cur);
            return result;


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
