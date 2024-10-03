package com.KaanIsmetOkul.CurrencyConverter.controller;

import com.KaanIsmetOkul.CurrencyConverter.model.Currency;
import com.KaanIsmetOkul.CurrencyConverter.service.CurrencyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService currencyService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testConvertCurrency() throws Exception {
        // Prepare the mock conversion rate and amount
        String fromCurrency = "USD";
        String toCurrency = "EUR";
        double amount = 100.00;
        double currencyRate = 0.85; // Mock conversion rate

        // Mock the service behavior
        when(currencyService.getCurrencyRate(anyString(), anyString())).thenReturn(currencyRate);
        when(currencyService.convert(new Currency(fromCurrency, amount, toCurrency, currencyRate)))
                .thenReturn(amount * currencyRate);

        // Prepare the correct JSON payload, now with the currencyRate included
        String json = String.format("{\"fromCurrency\":\"%s\", \"amount\":%.2f, \"toCurrency\":\"%s\", \"currencyRate\":%.2f}",
                fromCurrency, amount, toCurrency, currencyRate);

        // Perform MockMvc request to the convert endpoint
        mockMvc.perform(post("/convert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Converted amount: " + (amount * currencyRate)));
    }

}
