package com.KaanIsmetOkul.CurrencyConverter.model;
import org.springframework.stereotype.Component;
import java.lang.String;


@Component
public class Currency {
    private String fromCurrency;
    private double amount;
    private String toCurrency;
    private double currencyRate;

    public Currency() {}

    public Currency(String fromCurrency, double amount, String toCurrency, double currencyRate) {
        this.fromCurrency = fromCurrency;
        this.amount = amount;
        this.toCurrency = toCurrency;
        this.currencyRate = currencyRate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }

    @Override
    public String toString() {
        return "fromCurrency = " + fromCurrency + "\n" +
                "toCurrency = " + toCurrency + "\n" +
                "amount = " + Double.toString(amount) + "\n" +
                "double Rate = " + Double.toString(currencyRate);
    }
}
