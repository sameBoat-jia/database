package com.example.demo.dao;

import com.example.demo.domain.Temperature;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface TempDao {
@Select("select * from time_temperature order by time desc limit 1")
    public Temperature getTemperature();
}
