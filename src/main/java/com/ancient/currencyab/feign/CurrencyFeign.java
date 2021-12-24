package com.ancient.currencyab.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "currencyClient", url = "https://openexchangerates.org/api")
public interface CurrencyFeign {

    @GetMapping("/latest.json?app_id=f59816b4d01948d5ab1b0d6df6f41c8c")
    public String getCurrencyToday();

    @GetMapping("/historical/{time}.json?app_id=f59816b4d01948d5ab1b0d6df6f41c8c")
    public String getCurrencyYesterday(@PathVariable String time);
}
