package com.ancient.currencyab.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyPojo {
    private Map<String, Double> rates;

    public CurrencyPojo() {
    }

    @JsonCreator
    public CurrencyPojo(@JsonProperty("rates") Map<String, Double> rates) {
        this.rates = rates;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}

