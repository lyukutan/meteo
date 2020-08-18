package com.example.weather;

import com.example.weather.clients.CountryInfoServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class JaxbConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("wsdl");
        return marshaller;
    }

    @Bean
    public CountryInfoServiceClient cardChecker(Jaxb2Marshaller marshaller) {
        CountryInfoServiceClient client = new CountryInfoServiceClient();
        client.setDefaultUri("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
