package javaee.thermometer.controller;


import javaee.thermometer.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tem")
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;
    @GetMapping
//    @CrossOrigin("http://localhost:5173")
    public void get()
    {
        temperatureService.getAll();
        System.out.println(temperatureService.getAll());
        System.out.println("aaaaaaaaaaaaaa");
    }
}
