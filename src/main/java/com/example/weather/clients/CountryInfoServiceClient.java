package com.example.weather.clients;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import wsdl.*;

public class CountryInfoServiceClient extends WebServiceGatewaySupport {

//    public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode) {
//        GetCityForecastByZIP request = new GetCityForecastByZIP();
//        request.setZIP(zipCode);
//
//        System.out.println();
//        System.out.println("Requesting forecast for " + zipCode);
//
//        GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate().marshalSendAndReceive(
//                request,
//                new SoapActionCallback(
//                        "http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));
//
//        return response;
//    }

    public CountryNameResponse getCountryNameByISOCode(String code) {
        CountryName countryNameRequest = new CountryName();
        countryNameRequest.setSCountryISOCode(code);
        CountryNameResponse response = (CountryNameResponse) getWebServiceTemplate().marshalSendAndReceive(
                countryNameRequest,
                new SoapActionCallback(
                "http://webservices.oorsprong.org/websamples.countryinfo/CurrencyName"));

        return response;
    }
}