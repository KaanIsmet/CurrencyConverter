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


        System.out.println(stringBuilder.toString());


        //Currency currency = new Currency(amount, fromCurrency, toCurrency);
        return "Convert";
    }


}
