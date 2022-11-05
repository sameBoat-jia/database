package javaee.thermometer.service;


import javaee.thermometer.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)

public class TemperatureServiceTest {


    @Autowired
    private TemperatureService temperatureService;

    @Test
    public void a()
    {
        System.out.println(temperatureService.getAll());
    }
}
