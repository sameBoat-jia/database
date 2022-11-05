package javaee.thermometer.service;

import javaee.thermometer.domain.Temperature;

import java.util.List;

public interface TemperatureService  {
    public List<Temperature> getAll();
}
