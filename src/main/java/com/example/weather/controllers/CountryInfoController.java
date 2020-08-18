package com.example.weather.controllers;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("info")
@RequiredArgsConstructor
public class CountryInfoController {

    @PostMapping
    @SneakyThrows
    public String getCountryNameByCode(@RequestBody Map<String, String> str) {
        return "";
    }

}
