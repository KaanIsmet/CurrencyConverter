package com.KaanIsmetOkul.CurrencyConverter.model;


import org.springframework.stereotype.Component;

@Component
public class CurrencyRate {
    private String fromCurrency;
    private double amount;
    private String toCurrency;
    private double currencyRate;

    public CurrencyRate(String fromCurrency, double amount, String toCurrency, double currencyRate) {
        this.fromCurrency = fromCurrency;
        this.amount = amount;
        this.toCurrency = toCurrency;
        this.currencyRate = currencyRate;
    }
}
