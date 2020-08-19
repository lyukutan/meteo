package com.example.weather;


import com.example.weather.clients.CountryInfoServiceClient;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JaxbConfig.class, args);
        CountryInfoServiceClient countryInfoServiceClient = context.getBean(CountryInfoServiceClient.class);
        System.out.println(countryInfoServiceClient.getCountryNameByISOCode("AD").getCountryNameResult());

    }

}