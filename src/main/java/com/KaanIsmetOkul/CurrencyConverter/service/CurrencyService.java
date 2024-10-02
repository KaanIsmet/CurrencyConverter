package com.KaanIsmetOkul.CurrencyConverter.service;


import com.KaanIsmetOkul.CurrencyConverter.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class CurrencyService {

    @Autowired
    private RestTemplate restTemplate;



    @Value("${api.url}")
    private String apiUrl;

    @Value("${api.key}")
    private String apiKey;


    public double getCurrencyRate(String url, String toCurrency){



        double result = 0.0;
        try {
            URI apiURI = new URI(url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(apiURI)
                    .header("Authorization", "Bearer " + apiKey)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonResponse = objectMapper.readTree(response.body());
                JsonNode toCurrencyField = jsonResponse.path("conversion_rates").path(toCurrency);
                if(!toCurrencyField.isMissingNode()) {
                    result = toCurrencyField.doubleValue();
                    System.out.println("The value for " + toCurrency + " is " + result);

                }

                else
                    System.out.println("unable to find the field");


            }
        } catch (IOException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public double convert(Currency currency ) {
        return currency.getCurrencyRate() * currency.getAmount();
    }



    public String getApiUrl() {
        return apiUrl;
    }




}
