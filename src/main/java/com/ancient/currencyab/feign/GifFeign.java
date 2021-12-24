package com.ancient.currencyab.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gifClient",
        url = "https://api.giphy.com/v1/gifs/")
public interface GifFeign {

    @GetMapping("random?api_key=DC13nvv811axYG87lgnkJFbDf7p0Y9Jh&tag=rich")
    public String getRich();

    @GetMapping("random?api_key=DC13nvv811axYG87lgnkJFbDf7p0Y9Jh&tag=broke")
    public String getBroke();

}
