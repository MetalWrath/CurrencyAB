package com.ancient.currencyab.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "LocalFeign", url = "http://localhost:8080/api")
public interface MyLocalFeign {

    @GetMapping("/get-gif-url?cur={cur}")
    public String getUrlFromApi(@PathVariable("cur") String cur);

}
