package com.example.country.client.countryinfo;

import com.example.country.client.ServiceClient;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

public class CountryInfoServiceClient extends ServiceClient {

    public CountryInfoServiceClient(Jaxb2Marshaller marshaller,
                                    HttpComponentsMessageSender httpComponentsMessageSender,
                                    String baseUrl) {
        super(marshaller, httpComponentsMessageSender, baseUrl);
    }

}
