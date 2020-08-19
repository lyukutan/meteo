package com.example.country.config;

import com.example.country.client.countryinfo.CountryInfoServiceClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class ClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("org.oorsprong.websamples");
        return marshaller;
    }

    @Bean
    public CountryInfoServiceClient productionServiceClient(final Jaxb2Marshaller marshaller, final HttpComponentsMessageSender httpComponentsMessageSender, final WebServiceMessageFactory messageFactory, @Value("${base.url}") final String baseUrl) {
        return new CountryInfoServiceClient(marshaller, httpComponentsMessageSender, messageFactory, baseUrl);
    }

    @Bean
    public HttpComponentsMessageSender httpComponentsMessageSender() {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        httpComponentsMessageSender.setHttpClient(
                HttpClients.custom()
                        .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
                        .build()
        );
        return httpComponentsMessageSender;
    }

    @Bean
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.setSoapVersion(SoapVersion.SOAP_12);
        return messageFactory;
    }
}
