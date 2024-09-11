package com.KaanIsmetOkul.CurrencyConverter.controller;

import com.KaanIsmetOkul.CurrencyConverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.KaanIsmetOkul.CurrencyConverter.token.CurrencyToken;


import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;


    @GetMapping("/") // Define a path if needed
    public String getHomePage(Model model) {
        List<String> currencies = new ArrayList<>();

        for (CurrencyToken currency : CurrencyToken.values()) {
            currencies.add(currency.name());
        }
        model.addAttribute("currencies", currencies);
        return "Conversion"; // This should match the name of the HTML file without the .html extension
    }

    //handle with converting form
    @PostMapping("/convert")
    public String convertCurrency(
            @RequestParam("amount") double amount,
            @RequestParam("fromCurrency") String fromCurrency,
            @RequestParam("toCurrency") String toCurrency,
            Model model) {
            return "Convert";


    }


}
