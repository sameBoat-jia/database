package com.example.j2ee2.controller;

import com.example.j2ee2.bean.TempNow;
import com.example.j2ee2.service.TempNowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("temp")
public class TempNowController {

    @Autowired
    TempNowService tempNowService;

    @GetMapping("add")
    public TempNow add(@RequestParam("temperature")double temperature){
        return tempNowService.add(temperature);
    }

    @GetMapping("getNow")
    public List getNow(){
        return tempNowService.getNow();
    }

    @GetMapping("getAll")
    public List getAll(){
        return tempNowService.getAll();
    }

    @GetMapping("getAverage")
    public List getAverage(){
        return tempNowService.getAverage();
    }
}
