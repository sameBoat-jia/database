package javaee.thermometer.service.impl;

import javaee.thermometer.dao.TemperatureDao;
import javaee.thermometer.domain.Temperature;
import javaee.thermometer.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TemperatureServiceImpl implements TemperatureService {

    @Autowired
    private TemperatureDao temperatureDao;

    public List<Temperature> getAll() {
        return temperatureDao.getAll();
    }
}
