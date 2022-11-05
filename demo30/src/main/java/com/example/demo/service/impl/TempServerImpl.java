package com.example.demo.service.impl;

import com.example.demo.dao.TempDao;
import com.example.demo.domain.Temperature;
import com.example.demo.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TempServerImpl implements TempService {


    @Autowired
    private TempDao tempDao;
    @Override
    public Temperature getTemperature() {
         tempDao.getTemperature();
        return null;
    }
}
