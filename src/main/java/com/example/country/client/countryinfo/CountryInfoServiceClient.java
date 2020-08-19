package com.example.country.client.countryinfo;

import com.example.country.client.ServiceClient;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

public class CountryInfoServiceClient extends ServiceClient {

    public CountryInfoServiceClient(final Jaxb2Marshaller marshaller,
                                    final HttpComponentsMessageSender httpComponentsMessageSender,
                                    final WebServiceMessageFactory messageFactory,
                                    final String baseUrl) {
        super(marshaller, httpComponentsMessageSender, messageFactory, baseUrl);
    }

}
