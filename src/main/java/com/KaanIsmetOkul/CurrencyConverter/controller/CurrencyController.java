package com.KaanIsmetOkul.CurrencyConverter.controller;

import com.KaanIsmetOkul.CurrencyConverter.model.Currency;
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
            Model model)
    {
        //Get the Currency Rate from the api
        //Use the fromCurrency for a StringBuilder Variable
        //Have the StringBuilder Variable create a new Url to use the specific api
        //test it to see if it worked

        StringBuilder stringBuilder = new StringBuilder();
        String url = currencyService.getApiUrl();
        stringBuilder.append(url);
        stringBuilder.append(fromCurrency);

        url = stringBuilder.toString();

        double currencyRate = currencyService.getCurrencyRate(url, toCurrency);
        Currency currency = new Currency(fromCurrency, amount, toCurrency, currencyRate);
        double convertedAmount = currencyService.convert(currency);

        System.out.println(currency.getCurrencyRate());
        System.out.println("The amount for " + toCurrency + " is " + convertedAmount);

        model.addAttribute("fromCurrency", fromCurrency);
        model.addAttribute("toCurrency", toCurrency);
        model.addAttribute("amount", amount);
        model.addAttribute("convertedAmount", convertedAmount);
        return "Convert";
    }


}
