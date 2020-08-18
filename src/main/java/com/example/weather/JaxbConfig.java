package com.example.weather;

import com.example.weather.clients.WeatherClient;
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
    public WeatherClient cardChecker(Jaxb2Marshaller marshaller) {
        WeatherClient  client = new WeatherClient ();
        client.setDefaultUri("http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
