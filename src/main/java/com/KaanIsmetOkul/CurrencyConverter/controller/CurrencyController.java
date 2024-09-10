package com.KaanIsmetOkul.CurrencyConverter.controller;

import com.KaanIsmetOkul.CurrencyConverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.TreeMap;

@org.springframework.stereotype.Controller
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;


    @GetMapping("/") // Define a path if needed
    public String getHomePage(Model model) {
        TreeMap<String, Double> conversionRate = new TreeMap<>();








        model.addAttribute("conversionForm", "Hello");
        return "Conversion"; // This should match the name of the HTML file without the .html extension
    }

    //handle with converting form
    @PostMapping("/convert")
    public String convertCurrency(
            @RequestParam("amount") double amount,
            @RequestParam("fromCurrency") String fromCurrency,
            @RequestParam("toCurrency") String toCurrency,
            Model model) {
            return "";


    }


}
