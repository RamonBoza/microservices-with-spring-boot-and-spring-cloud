package com.in28minutes.microservices.currencyconversionservice;

import com.in28minutes.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversionBean currencyConversionBean = proxy.retrieveExchangeValue(from, to);

        currencyConversionBean.setQuantity(quantity);
        currencyConversionBean.setTotalCalculatedAmount(quantity.multiply(currencyConversionBean.getConversionMultiple()));

        logger.info("{}", currencyConversionBean);

        return currencyConversionBean;
    }
}
