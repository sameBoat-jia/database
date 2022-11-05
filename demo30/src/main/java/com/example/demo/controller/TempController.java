package com.example.demo.controller;


import com.example.demo.domain.Temperature;
import com.example.demo.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TempController {

    @Autowired
    private TempService tempService;

    @GetMapping("/temperature")
    public Temperature getTemperature()
    {
       return tempService.getTemperature();
    }

}
