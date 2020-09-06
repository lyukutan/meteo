package com.example.country.client.countryinfo;

import com.example.country.client.ServiceClient;
import org.oorsprong.websamples.CountryName;
import org.oorsprong.websamples.CountryNameResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

public class CountryInfoServiceClient extends ServiceClient {

    public CountryInfoServiceClient(Jaxb2Marshaller marshaller,
                                    HttpComponentsMessageSender httpComponentsMessageSender,
                                    String baseUrl) {
        super(marshaller, httpComponentsMessageSender, baseUrl);
    }

    public CountryNameResponse getCountryNameByISOCode(String code) {
        CountryName countryNameRequest = new CountryName();
        countryNameRequest.setSCountryISOCode(code);
        CountryNameResponse response = (CountryNameResponse) webServiceTemplate.marshalSendAndReceive(
                countryNameRequest,
                new SoapActionCallback(
                        "http://webservices.oorsprong.org/websamples.countryinfo/CurrencyName"));

        return response;
    }

}
