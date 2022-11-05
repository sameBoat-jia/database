package javaee.thermometer.dao;

import javaee.thermometer.domain.Temperature;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TemperatureDao {
    @Select("select * from time_temperature ")
    public List<Temperature> getAll();
}
