package com.KaanIsmetOkul.CurrencyConverter.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/") // Define a path if needed
    public String getHomePage(Model model) {
        model.addAttribute("something", "Hello World");
        return "Home"; // This should match the name of the HTML file without the .html extension
    }
}
