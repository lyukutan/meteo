package com.example.country.client;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

public abstract class ServiceClient {

    private Jaxb2Marshaller marshaller;
    private HttpComponentsMessageSender httpComponentsMessageSender;
    private String baseUrl;
    protected WebServiceTemplate webServiceTemplate;

    protected ServiceClient(Jaxb2Marshaller marshaller,
                            HttpComponentsMessageSender httpComponentsMessageSender,
                            String baseUrl) {
        this.marshaller = marshaller;
        this.httpComponentsMessageSender = httpComponentsMessageSender;
        this.baseUrl = baseUrl;
        this.webServiceTemplate = webServiceTemplate();
    }

    public Object call(Object request) {
        return webServiceTemplate.marshalSendAndReceive(request);
    }

    private WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMessageSender(httpComponentsMessageSender);
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        webServiceTemplate.setDefaultUri(baseUrl);
        return webServiceTemplate;
    }

}
